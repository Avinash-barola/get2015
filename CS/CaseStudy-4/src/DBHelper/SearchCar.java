package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Car;
import model.Vehicle;
import ConnectionUtil.ConnectionUtil;

public class SearchCar {
	public static Map<Integer,Vehicle> searchByMake(String make) {
		Connection con = null;
		PreparedStatement ps = null;
		con = ConnectionUtil.getConnection();
		String query = "Select * from vehicle where make = '"+make+"'";
		ResultSet rs = null;
		Map<Integer,Vehicle> carMap = new HashMap<Integer, Vehicle>();
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vehicle vehicle = new Car();
				vehicle.setCreated_By(rs.getString(2));
				vehicle.setCreated_Time(rs.getString(3));
				vehicle.setMake(rs.getString(4));
				vehicle.setModel(rs.getString(5));
				vehicle.setEnginInCC(rs.getInt(6));
				vehicle.setFuelCapacity(rs.getInt(7));
				vehicle.setMilage(rs.getInt(8));
				vehicle.setPrice(rs.getInt(9));
				vehicle.setRoadTax(rs.getInt(10));
				carMap.put(rs.getInt(1), vehicle);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return carMap;
	}
	public static Map<Integer,Vehicle> searchByVehicleID(int vehicleID) {
		Connection con = null;
		PreparedStatement ps = null;
		con = ConnectionUtil.getConnection();
		String query = "SELECT * from vehicle v,car c where v.vehicle_id ="+vehicleID+" AND c.vehicle_id = "+vehicleID+";";
		ResultSet rs = null;
		Map<Integer,Vehicle> carMap = new HashMap<Integer, Vehicle>();
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vehicle vehicle = new Car();
				vehicle.setCreated_By(rs.getString(2));
				vehicle.setCreated_Time(rs.getString(3));
				vehicle.setMake(rs.getString(4));
				vehicle.setModel(rs.getString(5));
				vehicle.setEnginInCC(rs.getInt(6));
				vehicle.setFuelCapacity(rs.getInt(7));
				vehicle.setMilage(rs.getInt(8));
				vehicle.setPrice(rs.getInt(9));
				vehicle.setRoadTax(rs.getInt(10));
				if(rs.getString(12).equalsIgnoreCase("yes")) {
					((Car)vehicle).setAC(true);
					//System.out.println(((Car)vehicle).isAC()+"ACYES");
				}
				else if(!rs.getString(12).equalsIgnoreCase("yes")) {
					((Car)vehicle).setAC(false);
					//System.out.println(((Car)vehicle).isAC()+"ACNO");
				}
				if(rs.getString(13).equalsIgnoreCase("yes")) {
					((Car)vehicle).setPowerSteering(true);
					//System.out.println(((Car)vehicle).isPowerSteering()+"PSYES");
				}
				else if(!rs.getString(13).equalsIgnoreCase("yes")) {
					((Car)vehicle).setPowerSteering(false);
					//System.out.println(((Car)vehicle).isPowerSteering()+"PSNO");
				}
				if(rs.getString(14).equalsIgnoreCase("yes")) {
					((Car)vehicle).setAccessoryKit(true);
					//System.out.println(((Car)vehicle).isAccessoryKit()+"AKYES");
				}
				else if(!rs.getString(14).equalsIgnoreCase("yes")) {
					((Car)vehicle).setAccessoryKit(false);
					//System.out.println(((Car)vehicle).isAccessoryKit()+"AKNO");
				}
				carMap.put(rs.getInt(1), vehicle);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(carMap);

		return carMap;
	}
}
