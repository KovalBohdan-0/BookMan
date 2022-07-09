

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
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
//				for(int i = 0; i < 1000; i++) {
//					usersController.addBook("name1", "author", "user1@gmail.com", 0, "de th cription");	
//				}
				
				// Add email and passwords cookies for 30 days
				Cookie emailCookie = new Cookie("email", email);
				emailCookie.setMaxAge(30*24*60*60);
				response.addCookie(emailCookie);
				Cookie passwordCookie = new Cookie("password", password);
				passwordCookie.setMaxAge(30*24*60*60);
				response.addCookie(passwordCookie);
				
				//Create list books and transport it to jsp file
				List<Book> books = usersController.selectUsersBooks(email);
				request.setAttribute("books", books);
				request.getRequestDispatcher("/WEB-INF/bookTable.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
