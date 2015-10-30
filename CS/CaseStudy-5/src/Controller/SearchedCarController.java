package Controller;

import helper.MyException;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Service;
import model.Vehicle;

/**
 * Servlet implementation class SearchedCarController
 */
@WebServlet("/SearchedCarController")
public class SearchedCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchedCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String make = request.getParameter("make");
		Service service = new Service();
		Map<Integer, Vehicle> carMap = null;
		try {
			carMap = service.searchByMake(make);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("carMap", carMap);
		request.getRequestDispatcher("searchedCars.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
