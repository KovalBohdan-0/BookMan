
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

		String usernameValidationResponse = ValidateRegistration.usernameIsValid(username);
		String emailValidationResponse = ValidateRegistration.emailIsValid(email);
		String passwordValidationResponse = ValidateRegistration.passwordIsValid(password);
		String repeatedPasswordValidationResponse = ValidateRegistration.repeatedPasswordIsValid(repeatedPassword,
				password);

		request.setAttribute("usernameError", usernameValidationResponse);
		request.setAttribute("emailError", emailValidationResponse);
		request.setAttribute("passwordError", passwordValidationResponse);
		request.setAttribute("repeatedPasswordError", repeatedPasswordValidationResponse);

		if (usernameValidationResponse.equals("") && emailValidationResponse.equals("")
				&& passwordValidationResponse.equals("") && repeatedPasswordValidationResponse.equals("")) {
//			request.getRequestDispatcher("/books").forward(request, response);
				UsersDBController userController = new UsersDBController();
				try {
					userController.addUser(username, email, password);
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("/BookingWeb/books");
		} else {
			request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
		}

	}

}
