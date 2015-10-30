package DBHelper;

import helper.MyException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import model.Car;
import model.Vehicle;

public class VehicleJDBCHelper {
	
	//Method to insert vehicle data in database
	@SuppressWarnings("resource")
	public static void create( Connection con,Vehicle vehicle ) throws MyException, SQLException
	{
		PreparedStatement prepareStmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			/* take data from vehicle to corresponding variables*/
			String author = vehicle.getCreated_By();
			String date = vehicle.getCreated_Time();
			String make = vehicle.getMake();
			String model = vehicle.getModel();
			int engineCC = vehicle.getEnginInCC();
			int fuelCapacity = vehicle.getFuelCapacity();
			int milage = vehicle.getMilage();
			int price = vehicle.getPrice();
			int roadTax = vehicle.getRoadTax();
			// query for inserting data
			String query = "INSERT INTO Vehicle(created_by,created_time,make,model,engine_cc,fuel_capacity,milage,price,roadTax) VALUES(?,?,?,?,?,?,?,?,?)";
			prepareStmt = con.prepareStatement(query); // make prepare statement object
			prepareStmt.setString(1, author);
			prepareStmt.setString(2, date);
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
					System.out.println("Hello");
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
		}
		catch (Exception e) {
			throw e;
		} finally {
			if (prepareStmt != null) {
				try {
					prepareStmt.close();
				} catch (SQLException e) {
					System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
				}
			}
		}
	}
	public static void update(Connection con ,Vehicle vehicle ,int vehicleID) throws MyException
	{
		PreparedStatement prepareStmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			/* take data from vehicle to corresponding variables*/
			String author = vehicle.getCreated_By();
			String date = vehicle.getCreated_Time();
			String make = vehicle.getMake();
			String model = vehicle.getModel();
			int engineCC = vehicle.getEnginInCC();
			int fuelCapacity = vehicle.getFuelCapacity();
			int milage = vehicle.getMilage();
			int price = vehicle.getPrice();
			int roadTax = vehicle.getRoadTax();
			// query for inserting data
			String query = "update vehicle set created_by='"+author+"',created_time='"+date+"',make='"+make+"',model="+model+",engine_cc="+engineCC+",fuel_capacity="+fuelCapacity+",milage="+milage+",price="+price+",roadTax="+roadTax+" where vehicle_id=2";
			prepareStmt = con.prepareStatement(query); // make prepare statement object
			System.out.println("hello-hello");
			query = "SELECT vehicle_id FROM Vehicle ORDER BY vehicle_id DESC"; //take vehicle id for current inserting data
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			if(vehicle instanceof Car) // check if vehicle is instance of car than entry do in car table
			{
				String ac = "NO", powerSteering = "NO", accessoryKit = "NO";
				if(((Car)vehicle).isAC())
				{
					//System.out.println("Hello");
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
				query = "update Car set ac='"+ac+"',powersteering='"+powerSteering+"',accessorykit='"+accessoryKit+"'where vehicle_id="+vehicleID;// query for inserting data in car table
				prepareStmt = con.prepareStatement(query);
				prepareStmt.execute();			// execute query
			}
		}
		catch (SQLException e) {
			System.out.println("Cant communicate with database");
			throw new MyException(e);
			}
		finally{	
			try {
				stmt.close();
				prepareStmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Cant communicate with database");
				throw new MyException(e);
			}
			
		}
	}
}
