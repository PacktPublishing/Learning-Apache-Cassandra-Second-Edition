import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class QueryBuilderUpdate {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").build();
		Session session = cluster.connect();

		Statement statement = QueryBuilder.update("my_status", "users")
				.with(QueryBuilder.set("location", "San Francisco, CA"))
				.and(QueryBuilder.set("email", "alice@hotmail.com"))
				.where(QueryBuilder.eq("username", "alice"));
		session.execute(statement);

		cluster.close();

	}

}
