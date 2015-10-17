package controller;

import helper.EmployeeCache;
import helper.RegistrationAuthentication;

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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()s
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		String date = request.getParameter("date");
		if(!RegistrationAuthentication.authenticate(id)) {
			request.setAttribute("message", "Id already exist");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		else {
			
			EmployeeCache employeeCache = EmployeeCache.getInstance();
			employeeCache.addEmployee(new Employee(name, email, id, age, date));
			List<Employee> employeeList = employeeCache.getAllEmployees();
			request.setAttribute("employeeList", employeeList);
			request.getRequestDispatcher("listemployee.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
