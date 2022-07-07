

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookingTableServlet
 */
public class BooksTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			UsersDBController usersController = new UsersDBController();
			if(usersController.login(email, password) == true) {
				System.out.println("Found");
				ArrayList<Book> books = usersController.selectUsersBooks(email);
				request.setAttribute("books", books);
				request.getRequestDispatcher("/WEB-INF/bookTable.jsp").forward(request, response);
//				usersController.addBook("name1", "author", "user1@gmail.com", 0, "de th cription");
			} else {
				System.out.println("Not found");
				request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
