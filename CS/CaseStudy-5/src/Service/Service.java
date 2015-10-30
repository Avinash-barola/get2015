package Service;

import helper.MyException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Factory.ConnectionFactory;
import Facade.Facade;
import model.Vehicle;

public class Service {
	public void createVehicle(Vehicle vehicle) throws MyException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		Facade facade = new Facade();
		try {
			facade.createVehicle(connection,vehicle);
		} catch (MyException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		}
		finally{
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void updateVehicle(Vehicle vehicle,int vehicleID) throws MyException {
		Connection connection = ConnectionFactory.getConnection();
		Facade facade = new Facade();
		try {
			facade.updateVehicle(connection,vehicle,vehicleID);
		} catch (MyException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		}
		finally{
			ConnectionFactory.closeConnection(connection);
		}
	}
	public List<String> getAllCarMake() throws MyException {
		Connection connection = ConnectionFactory.getConnection();
		Facade facade = new Facade();
		try {
			return facade.getAllCarMake(connection);
		} catch (MyException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		}
		finally{
			ConnectionFactory.closeConnection(connection);
		}
	}
	public Map<Integer,Vehicle> searchByMake(String make) throws MyException {
		Connection connection = ConnectionFactory.getConnection();
		Facade facade = new Facade();
		try {
			return facade.searchByMake(connection,make);
		} catch (MyException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		}
		finally{
			ConnectionFactory.closeConnection(connection);
		}
	}
	public boolean isValidAdmin(String email,String password) throws MyException {
		Connection connection = ConnectionFactory.getConnection();
		Facade facade = new Facade();
		try {
			return facade.isValidAdmin(connection,email,password);
		} catch (MyException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		}
		finally{
			ConnectionFactory.closeConnection(connection);
		}
	}
	public Map<Integer,Vehicle> searchByVehicleID(int vehicleID) throws MyException {
		Connection connection = ConnectionFactory.getConnection();
		Facade facade = new Facade();
		try {
			return facade.searchByVehicleID(connection,vehicleID);
		} catch (MyException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		}
		finally{
			ConnectionFactory.closeConnection(connection);
		}
	}
}
