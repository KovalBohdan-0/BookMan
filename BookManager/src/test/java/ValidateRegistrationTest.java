import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ValidateRegistrationTest {
	private RegistrationValidator registrationValidator;
	
	public ValidateRegistrationTest() throws ClassNotFoundException, SQLException {
		registrationValidator = new RegistrationValidator();
	}
	
	@Test
	void emptyUsernameShouldReturnError() throws ClassNotFoundException, SQLException {
		assertEquals("Enter your username", registrationValidator.usernameIsValid(""));
	}
	
	@Test
	void tooSmallUsernameShouldReturnError() throws ClassNotFoundException, SQLException {
		assertEquals("Username must use only letters and numbers and must have atleast 3 and maximum 17 characters", registrationValidator.usernameIsValid("df"));
	}
	
	@Test
	void tooLongUsernameShouldReturnError() throws ClassNotFoundException, SQLException {
		assertEquals("Username must use only letters and numbers and must have atleast 3 and maximum 17 characters", registrationValidator.usernameIsValid("alexdfpotdterkidng"));
	}
	
	@Test
	void usernameWithSymbolsShouldReturnError() throws ClassNotFoundException, SQLException {
		assertEquals("Username must use only letters and numbers and must have atleast 3 and maximum 17 characters", registrationValidator.usernameIsValid("df"));
	}
	
	@Test
	void validUsernameShouldReturnNothing() throws ClassNotFoundException, SQLException {
		assertEquals("", registrationValidator.usernameIsValid("alex"));
	}
	
	@Test
	void emptyEmailShouldReturnError() throws SQLException {
		assertEquals("Enter your email", registrationValidator.emailIsValid(""));
	}
	
	@Test
	void invalidEmailShouldReturnError() throws SQLException {
		assertEquals("Input valid email", registrationValidator.emailIsValid("alex"));
	}
	
	@Test
	void validEmailShouldReturnNothing() throws SQLException {
		assertEquals("", registrationValidator.emailIsValid("alex@gmail.com"));
	}
	
	@Test
	void emptyPasswordShouldReturnError() {
		assertEquals("Enter your password", registrationValidator.passwordIsValid(""));
	}
	
	@Test
	void tooSmallPasswordShouldReturnError() {
		assertEquals("Password must use only letters and numbers and must have atleast 6 and maximum 21 characters", registrationValidator.passwordIsValid("df"));
	}
	
	@Test
	void tooLongPasswordShouldReturnError() {
		assertEquals("Password must use only letters and numbers and must have atleast 6 and maximum 21 characters", registrationValidator.passwordIsValid("alexdfpotdter58j3kidng"));
	}
	
	@Test
	void passwordWithSymbolsShouldReturnError() {
		assertEquals("Password must use only letters and numbers and must have atleast 6 and maximum 21 characters", registrationValidator.passwordIsValid("dffd_>gfd"));
	}
	
	@Test
	void validPasswordShouldReturnNothing() {
		assertEquals("", registrationValidator.passwordIsValid("O4jKmLff"));
	}
	
	@Test
	void emptyRepeatedPasswordShouldReturnError() {
		assertEquals("Repeat your password", registrationValidator.repeatedPasswordIsValid("" ,"password"));
	}
	
}
