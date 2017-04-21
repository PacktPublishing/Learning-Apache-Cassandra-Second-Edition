import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class QueryBuilderSelect {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").build();
		Session session = cluster.connect();

		Statement statement = QueryBuilder.select("username", "email", "location").from("my_status", "users")
				.where(QueryBuilder.eq("username", "alice"));
		ResultSet rs = session.execute(statement);
		Row row = rs.one();
		System.out.printf("Username: %s, Email: %s, Location: %s\n", row.getString("username"), row.getString("email"),
				row.getString("location"));

		cluster.close();

	}

}
