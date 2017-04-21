import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class SimplePreparedQuery {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").build();
		Session session = cluster.connect();

		PreparedStatement ps1 = session.prepare("INSERT INTO my_status.users (username , email) VALUES (?, ?)");
		PreparedStatement ps2 = session.prepare("SELECT * FROM my_status.users WHERE username = ?");
		
		BoundStatement bs1 = ps1.bind();
		bs1.setString("username", "alice");
		bs1.setString("email", "alice@yahoo.com");
		
		BoundStatement bs2 = ps2.bind();
		bs2.setString("username", "alice");
		
		bs1.setConsistencyLevel(ConsistencyLevel.ONE);
		bs2.setConsistencyLevel(ConsistencyLevel.QUORUM);
		
		
		session.execute(bs1);
		ResultSet rs = session.execute(bs2);
		for (Row row : rs.all()) {
			System.out.printf("Username: %s, Email: %s, Location: %s\n", row.getString("username"),
					row.getString("email"), row.getString("location"));
		}

		cluster.close();

	}

}
