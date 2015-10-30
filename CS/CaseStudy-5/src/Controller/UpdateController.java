package Controller;

import helper.MyException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Service;
import model.Car;
import model.Vehicle;

/**
 * Servlet implementation class UpdateDBHelper
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vehicle vehicle = createVehicle(request);
		int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));
		try {
			Service service = new Service();
			service.updateVehicle(vehicle,vehicleID);
			HttpSession session = request.getSession();
			String email = session.getAttribute("admin").toString();
			request.setAttribute("email", email);
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		} catch (MyException e) {
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		vehicle.setRoadTax(Integer.parseInt(request.getParameter("tax")));
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
}
