import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateRegistrationTest {
	
	@Test
	void emptyUsernameShouldReturnError() {
		assertEquals("Enter your username", ValidateRegistration.usernameIsValid(""));
	}
	
	@Test
	void tooSmallUsernameShouldReturnError() {
		assertEquals("Username must use only letters and numbers and must have atleast 3 and maximum 17 characters", ValidateRegistration.usernameIsValid("df"));
	}
	
	@Test
	void tooLongUsernameShouldReturnError() {
		assertEquals("Username must use only letters and numbers and must have atleast 3 and maximum 17 characters", ValidateRegistration.usernameIsValid("alexdfpotdterkidng"));
	}
	
	@Test
	void usernameWithSymbolsShouldReturnError() {
		assertEquals("Username must use only letters and numbers and must have atleast 3 and maximum 17 characters", ValidateRegistration.usernameIsValid("df"));
	}
	
	@Test
	void validUsernameShouldReturnNothing() {
		assertEquals("", ValidateRegistration.usernameIsValid("alex"));
	}
	
	@Test
	void emptyEmailShouldReturnError() {
		assertEquals("Enter your email", ValidateRegistration.emailIsValid(""));
	}
	
	@Test
	void invalidEmailShouldReturnError() {
		assertEquals("Input valid email", ValidateRegistration.emailIsValid("alex"));
	}
	
	@Test
	void validEmailShouldReturnNothing() {
		assertEquals("", ValidateRegistration.emailIsValid("alex@gmail.com"));
	}
	
	@Test
	void emptyPasswordShouldReturnError() {
		assertEquals("Enter your password", ValidateRegistration.passwordIsValid(""));
	}
	
	@Test
	void tooSmallPasswordShouldReturnError() {
		assertEquals("Password must use only letters and numbers and must have atleast 6 and maximum 21 characters", ValidateRegistration.passwordIsValid("df"));
	}
	
	@Test
	void tooLongPasswordShouldReturnError() {
		assertEquals("Password must use only letters and numbers and must have atleast 6 and maximum 21 characters", ValidateRegistration.passwordIsValid("alexdfpotdter58j3kidng"));
	}
	
	@Test
	void passwordWithSymbolsShouldReturnError() {
		assertEquals("Password must use only letters and numbers and must have atleast 6 and maximum 21 characters", ValidateRegistration.passwordIsValid("dffd_>gfd"));
	}
	
	@Test
	void validPasswordShouldReturnNothing() {
		assertEquals("", ValidateRegistration.passwordIsValid("O4jKmLff"));
	}
	
	@Test
	void emptyRepeatedPasswordShouldReturnError() {
		assertEquals("Repeat your password", ValidateRegistration.repeatedPasswordIsValid("" ,"password"));
	}
	
}
