import java.sql.SQLException;

public class RegistrationValidator {
	private UsersDBController usersController;

	public RegistrationValidator() throws ClassNotFoundException, SQLException {
		usersController = new UsersDBController();
	}

	public String usernameIsValid(String username) throws ClassNotFoundException, SQLException {
		if (username.equals("")) {
			return "Enter your username";
		} else if (usersController.usernameIsUsed(username) == true) {
			return "Username is already in use";
		} else if (username.matches("[a-zA-Z0-9]{3,16}")) {
			return "";
		} else {
			return "Username must use only letters and numbers and must have atleast 3 and maximum 17 characters";
		}
	}

	public String emailIsValid(String email) throws SQLException {
		if (email.equals("")) {
			return "Enter your email";
		} else if (usersController.emailIsUsed(email) == true) {
			return "Email is already in use";
		} else if (email.matches("^(.+)@(.+)$")) {
			return "";
		} else {
			return "Input valid email";
		}
	}

	public String passwordIsValid(String password) {
		if (password.equals("")) {
			return "Enter your password";
		} else if (password.matches("[a-zA-Z0-9]{6,20}")) {
			return "";
		} else {
			return "Password must use only letters and numbers and must have atleast 6 and maximum 21 characters";
		}
	}

	public String repeatedPasswordIsValid(String repeatedPassword, String password) {
		if (repeatedPassword.equals("")) {
			return "Repeat your password";
		} else if (repeatedPassword.equals(password)) {
			return "";
		} else {
			return "Your passwords do not match";
		}
	}

}
