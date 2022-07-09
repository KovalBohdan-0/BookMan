
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewBookServlet
 */
@WebServlet({ "/NewBookServlet", "/addBook" })
public class NewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String email = "";
		String password = "";

		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];

			if (cookie.getName().equals("email")) {
				email = cookie.getValue();
			} else if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}

		try {
			UsersDBController usersController = new UsersDBController();
			if (usersController.login(email, password) == true) {
				request.getRequestDispatcher("/WEB-INF/newBook.jsp").forward(request, response);

				String name = request.getParameter("name");
				String author = request.getParameter("author");
				String pages = request.getParameter("pages");
				String description = request.getParameter("description");

				if (name != null && author != null) {
					usersController.addBook(name, author, email, pages, description);
				}

			} else {
				request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
