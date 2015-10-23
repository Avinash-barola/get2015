
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		boolean isValid = true;
		if(userName == "") {
			print.print("User Name can't be empty");
			isValid = false;
		}
		if(password == "") {
			print.print("Password can't be empty");
			isValid = false;
		}
		if(isValid == true) {
			if(AddIntoDatabase.isLogInCorrect(userName,password)) {
				request.getRequestDispatcher("loginsuccessful.jsp").forward(request, response);
			}
			else {
				request.setAttribute("a","ID Password not match");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
