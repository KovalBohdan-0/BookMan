import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UsersDBController {

	private static String url = "jdbc:postgresql://localhost/bookmanager";
	private static Properties props = new Properties();
	private static Connection connection;
	private static Statement statement;
	
	public UsersDBController() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");

		props.setProperty("user", "postgres");
		props.setProperty("password", "rszrsz300");
		props.setProperty("ssl", "true");

		props.setProperty("sslmode", "require");

		connection = DriverManager.getConnection(url, props);

		statement = connection.createStatement();

	}

	public void addUser(String username, String email, String password) throws SQLException, ClassNotFoundException {
//		Class.forName("org.postgresql.Driver");
//
//		props.setProperty("user", "postgres");
//		props.setProperty("password", "rszrsz300");
//		props.setProperty("ssl", "true");
//
//		props.setProperty("sslmode", "require");
//
//		Connection connection = DriverManager.getConnection(url, props);
//
//		Statement statement = connection.createStatement();
		statement.executeUpdate(String.format("INSERT INTO users(username,password,email) VALUES(\'%s\',\'%s\',\'%s\');",
				username, password, email));

//		System.out.println(statment.execute(
//				String.format("SELECT exists (SELECT 1 FROM users WHERE username = '%s' LIMIT 1);", username)));

//		statement.close();
	}

	public boolean usernameIsUsed(String username) throws SQLException, ClassNotFoundException {
//		Class.forName("org.postgresql.Driver");
//		
//		Connection connection = DriverManager.getConnection(url, props);
//		Statement statement = connection.createStatement();
//		
		return statement
				.execute(String.format("SELECT exists (SELECT 1 FROM users WHERE username = '%s' LIMIT 1);", username));

	}

	public boolean emailIsUsed(String email) throws SQLException {
//		Connection connection = DriverManager.getConnection(url, props);
//		Statement statement = connection.createStatement();
		
		return statement
				.execute(String.format("SELECT exists (SELECT 1 FROM users WHERE email = '%s' LIMIT 1);", email));
	}
}
