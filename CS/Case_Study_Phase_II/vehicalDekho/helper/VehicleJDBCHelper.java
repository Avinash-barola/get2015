package helper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.Bike;
import model.Vehicle;
import Utills.ConnectionUtill;

public class VehicleJDBCHelper {
	
	//Method to insert vehicle data in database
	@SuppressWarnings("resource")
	public static void create( Vehicle vehicle ) throws MyException
	{
		/* Creating connection*/
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		PreparedStatement prepareStmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			/* take data from vehicle to corresponding variables*/
			String author = vehicle.getCreated_By();
			java.sql.Date date = vehicle.getCreated_Time();
			String make = vehicle.getMake();
			String model = vehicle.getModel();
			int engineCC = vehicle.getEnginInCC();
			int fuelCapacity = vehicle.getFuelCapacity();
			int milage = vehicle.getMilage();
			double price = vehicle.getPrice();
			double roadTax = vehicle.getRoadTax();
			// query for inserting data
			String query = "INSERT INTO Vehicle(created_by,created_time,make,model,engine_cc,fuel_capacity,milage,price,roadTax) VALUES(?,?,?,?,?,?,?,?,?)";
			prepareStmt = con.prepareStatement(query); // make prepare statement object
			prepareStmt.setString(1, author);
			prepareStmt.setDate(2, date);
			prepareStmt.setString(3, make);
			prepareStmt.setString(4, model);
			prepareStmt.setInt(5, engineCC);
			prepareStmt.setInt(6, fuelCapacity);
			prepareStmt.setInt(7, milage);
			prepareStmt.setDouble(8, price);
			prepareStmt.setDouble(9, roadTax);
			prepareStmt.execute(); // execute query
			
			query = "SELECT vehicle_id FROM Vehicle ORDER BY vehicle_id DESC"; //take vehicle id for current inserting data
			int vehicleId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			vehicleId = rs.getInt(1);
			if(vehicle instanceof Car) // check if vehicle is instance of car than entry do in car table
			{
				String ac = "NO", powerSteering = "NO", accessoryKit = "NO";
				if(((Car)vehicle).isAC())
				{
					ac = "YES";
				}
				if(((Car)vehicle).isPowerSteering())
				{
					powerSteering = "YES";
				}
				if(((Car)vehicle).isAccessoryKit())
				{
					accessoryKit = "YES";
				}
				query = "INSERT INTO Car(ac,powersteering,accessorykit,vehicle_id) VALUES(?,?,?,?)"; // query for inserting data in car table
				prepareStmt = con.prepareStatement(query);
				prepareStmt.setString(1, ac);
				prepareStmt.setString(2, powerSteering);
				prepareStmt.setString(3, accessoryKit);
				prepareStmt.setInt(4, vehicleId);
				prepareStmt.execute();			// execute query
			}
			else				// otherwise do in bike table
			{
				String selfStart = "NO";
				double helmetprice = ((Bike)vehicle).getHelmetPrize();
				if(((Bike)vehicle).isSelfStart())
				{
					selfStart = "YES";
				}
				query = "INSERT INTO Bike(selfstart,helmetprice,vehicle_id) VALUES(?,?,?)"; // query for inserting data in Bike table
				prepareStmt = con.prepareStatement(query);
				prepareStmt.setString(1, selfStart);
				prepareStmt.setDouble(2, helmetprice);
				prepareStmt.setInt(3, vehicleId);
				prepareStmt.execute();
			}
		}
		catch (SQLException e) {
			throw new MyException(e);
		}
		finally{
			try {
				stmt.close();
				prepareStmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MyException(e);
			}
			
		}
	}
}
