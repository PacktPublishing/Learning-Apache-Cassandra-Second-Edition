import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class SimpleQuery {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").build();
		Session session = cluster.connect();

		session.execute("INSERT INTO my_status.users (username , email) VALUES ('greg', 'greg@gmail.com')");
		ResultSet rs = session.execute("SELECT * FROM my_status.users");
		for (Row row : rs.all()) {
			System.out.printf("Username: %s, Email: %s, Location: %s\n", row.getString("username"),
					row.getString("email"), row.getString("location"));
		}

		cluster.close();

	}

}
