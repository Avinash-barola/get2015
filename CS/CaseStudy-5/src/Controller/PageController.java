package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageController
 */
@WebServlet("/PageController")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =  request.getParameter("type");
		System.out.print("hii"+type);
		if(type.equalsIgnoreCase("CarDekho")) {
			request.getRequestDispatcher("CarDekho.jsp").forward(request, response);
		}
		else if(type.equalsIgnoreCase("login")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(type.equalsIgnoreCase("adminHome")) {
			HttpSession session = request.getSession();
			String email = session.getAttribute("admin").toString();
			request.setAttribute("email", email);
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		}
		else if(type.equalsIgnoreCase("createCar")) {
			request.getRequestDispatcher("create.jsp").forward(request, response);
		}
		else if(type.equalsIgnoreCase("logOut")) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", null);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(type.equalsIgnoreCase("contactUs")) {
			request.getRequestDispatcher("ContactUs.jsp").forward(request, response);
		}
		else if(type.equalsIgnoreCase("AboutUs")) {
			request.getRequestDispatcher("ContactUs.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
