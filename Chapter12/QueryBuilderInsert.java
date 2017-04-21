import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class QueryBuilderInsert {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").build();
		Session session = cluster.connect();

		Statement statement = QueryBuilder.insertInto("my_status", "users").value("username", "alice")
				.value("email", "alice@aol.com").value("location", "Los Angeles, CA");
		session.execute(statement);

		cluster.close();

	}

}
