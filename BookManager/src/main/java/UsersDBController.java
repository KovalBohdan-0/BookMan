
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
		connection = DriverManager.getConnection(url, props);
		statement = connection.createStatement();

	}

	public void addUser(String username, String email, String password) throws SQLException, ClassNotFoundException {
		statement.executeUpdate(String.format(
				"INSERT INTO users(username,password,email) VALUES(\'%s\',\'%s\',\'%s\');", username, password, email));
	}

	public void addBook(String name, String author, String email, String pages, String description)
			throws SQLException {
		int pageCount = 0;

		if (!pages.equals("")) {
			try {
				Integer.parseInt(pages);
				pageCount = Integer.parseInt(pages);
			} catch (NumberFormatException e) {	
			}
		}
		statement.executeUpdate(String.format(
				"INSERT INTO books(name, author, email, pagescount, description) VALUES(\'%s\',\'%s\',\'%s\',\'%d\',\'%s\');",
				name, author, email, pageCount, description));

	}

	public boolean usernameIsUsed(String username) throws SQLException, ClassNotFoundException {
		ResultSet rs = statement.executeQuery(
				String.format("SELECT exists (SELECT 1 FROM users WHERE username = '%s' LIMIT 1);", username));
		rs.next();
		return rs.getBoolean("exists");
	}

	public boolean emailIsUsed(String email) throws SQLException {
		ResultSet rs = statement
				.executeQuery(String.format("SELECT exists (SELECT 1 FROM users WHERE email = '%s' LIMIT 1);", email));
		rs.next();
		return rs.getBoolean("exists");

	}

	public boolean login(String email, String password) throws SQLException {
		ResultSet rs = statement.executeQuery(String.format(" SELECT password FROM users WHERE email='%s';", email));
		if (rs.next()) {
			if (rs.getString("password").equals(password)) {
				return true;
			}
		}

		return false;
	}

	public List<Book> selectUsersBooks(String email) throws SQLException {
		ResultSet rs = statement.executeQuery(String.format(" SELECT * FROM books WHERE email='%s';", email));
		List<Book> books = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book(rs.getString("name"), rs.getString("author"), email, rs.getString("pagescount"), rs.getString("description"));
			books.add(book);
		}

		return books;
	}
}
