package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Service;
import model.Car;
import model.Vehicle;

/**
 * Servlet implementation class CreateController
 */
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vehicle vehicle = createVehicle(request);
		Service service = new Service();
		try {
			service.createVehicle(vehicle);
			request.setAttribute("message","Car created successfully");
			request.getRequestDispatcher("create.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message","Sorry Cant Create Car");
			request.getRequestDispatcher("create.jsp").forward(request, response);
		}
	}
	
	private Vehicle createVehicle(HttpServletRequest request) {
		Vehicle vehicle = new Car();
		int price = Integer.parseInt(request.getParameter("showRoomPrice"));
		price = price+price*Integer.parseInt(request.getParameter("tax"))/100;
		vehicle.setMake(request.getParameter("make"));
		vehicle.setCreated_By((String) request.getParameter("createdBy"));
		vehicle.setModel((String) request.getParameter("model"));
		vehicle.setEnginInCC(Integer.parseInt((request.getParameter("engineInCC"))));
		vehicle.setFuelCapacity((Integer.parseInt(request.getParameter("fuelCapacity"))));
		vehicle.setPrice(price);
		vehicle.setRoadTax((Integer.parseInt( request.getParameter("tax"))));
		vehicle.setCreated_Time(request.getParameter("createdTime"));
		vehicle.setMilage((Integer.parseInt(request.getParameter("milage"))));
		String ps = request.getParameter("ps");
		String ak = request.getParameter("ak");
		String ac = request.getParameter("ac");
		if("ps".equals(ps)) {
			((Car)vehicle).setPowerSteering(true);
		}
		if("ak".equals(ak)) {
			((Car)vehicle).setAccessoryKit(true);
		}
		if("ac".equals(ac)) {
			((Car)vehicle).setAC(true);
		}
		return vehicle;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
