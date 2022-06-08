
public class ValidateRegistration {
	public static String usernameIsValid(String username) {
		if(username.equals("")){
			return "Enter your username";
		}
		else if (username.matches("[a-zA-Z0-9]{3,16}")) {
			return "";
		} else {
			return "Username must use only letters and numbers and must have atleast 3 and maximum 17 characters";
		}
	}

	public static String emailIsValid(String email) {
		if(email.equals("")){
			return "Enter your email";
		}
		else if (email.matches("^(.+)@(.+)$")) {
			return "";
		} else {
			return "Input valid email";
		}
	}

	public static String passwordIsValid(String password) {
		if(password.equals("")){
			return "Enter your password";
		}
		else if (password.matches("[a-zA-Z0-9]{6,20}")) {
			return "";
		} else {
			return "Password must use only letters and numbers and must have atleast 6 and maximum 21 characters";
		}
	}
	
	public static String repeatedPasswordIsValid(String repeatedPassword, String password) {
		if(repeatedPassword.equals("")){
			return "Repeat your password";
		}
		else  if(repeatedPassword.equals(password)) {
			return "";
		} else {
			return "Your passwords do not match";
		}
	}

}
