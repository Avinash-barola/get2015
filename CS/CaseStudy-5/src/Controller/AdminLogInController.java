package Controller;

import helper.MyException;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Service;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminLogInController")
public class AdminLogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher;
		Service service = new Service();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	//	LogIn logIn = new LogIn();
		try {
			if(service.isValidAdmin(email, password)) {
				request.setAttribute("email", email);
				request.setAttribute(password, password);
				HttpSession session = request.getSession();
				session.setAttribute("admin", email);
				dispatcher =request.getRequestDispatcher("adminHome.jsp"); 
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("message","ID Password not match");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (MyException e) {
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
