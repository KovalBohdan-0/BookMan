
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		
		RegistrationValidator registrationValidator;
		try {
			registrationValidator = new RegistrationValidator();
			String usernameValidationResponse = registrationValidator.usernameIsValid(username);
			String emailValidationResponse = registrationValidator.emailIsValid(email);
			String passwordValidationResponse = registrationValidator.passwordIsValid(password);
			String repeatedPasswordValidationResponse =registrationValidator.repeatedPasswordIsValid(repeatedPassword,
					password);

			request.setAttribute("usernameError", usernameValidationResponse);
			request.setAttribute("emailError", emailValidationResponse);
			request.setAttribute("passwordError", passwordValidationResponse);
			request.setAttribute("repeatedPasswordError", repeatedPasswordValidationResponse);

			if (usernameValidationResponse.equals("") && emailValidationResponse.equals("")
					&& passwordValidationResponse.equals("") && repeatedPasswordValidationResponse.equals("")) {
				UsersDBController userController = null;
				userController = new UsersDBController();
				userController.addUser(username, email, password);
				response.sendRedirect("/BookManager/books");
			} else {
				request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	}

}
