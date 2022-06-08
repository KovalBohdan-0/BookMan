import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UsersDBController {
	
	private static String url = "jdbc:postgresql://localhost/bookmanager";
	
	private static Properties props = new Properties();
	
	public void addUser(String username, String email, String password) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		
		props.setProperty("user","postgres");
		props.setProperty("password","rszrsz300");
		props.setProperty("ssl","true");
		
		props.setProperty("sslmode","require");

		Connection connection = DriverManager.getConnection(url, props);	
		
		Statement statment = connection.createStatement();
		statment.executeUpdate(String.format("INSERT INTO users(username,password,email) VALUES(\'%s\',\'%s\',\'%s\');", username, password, email));
		
		statment.close();
	}
}
