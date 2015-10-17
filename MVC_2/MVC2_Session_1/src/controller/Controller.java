package controller;

import helper.EmployeeCache;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = null;
		String type = request.getParameter("type");
		if( type.equals("Home")) {
			dis = request.getRequestDispatcher("landing.jsp");
		}
		else if( type.equals("Registration")) {
			dis = request.getRequestDispatcher("registration.jsp");
		}
		else if( type.equals("ListEmployee")) {
			EmployeeCache employeeCache = EmployeeCache.getInstance();
			List<Employee> employeeList = employeeCache.getAllEmployees();
			request.setAttribute("employeeList", employeeList);
			dis = request.getRequestDispatcher("listemployee.jsp");
		}
		else if( type.equals("Detail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			dis = request.getRequestDispatcher("detail.jsp");
		}
		else if( type.equals("Edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			dis = request.getRequestDispatcher("edit.jsp");
		}
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
