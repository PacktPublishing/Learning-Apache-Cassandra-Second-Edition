
import com.datastax.driver.core.*;

public class GetMetadata {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").build();
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Cluster name: %s\n", metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.println("Host: " + host.getAddress() + "\n");
		}
		cluster.close();
		
	}
	
}
