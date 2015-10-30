package Facade;

import helper.MyException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import DBHelper.LogIn;
import DBHelper.AvailableMake;
import DBHelper.SearchCar;
import DBHelper.VehicleJDBCHelper;
import model.Vehicle;

public class Facade {
	public void createVehicle(Connection con,Vehicle vehicle) throws MyException {
		try {
			VehicleJDBCHelper.create(con,vehicle);
		} catch (SQLException e) {
			System.out.println("Exception while creating sales person " + e.getMessage());		
		}
	}
	
	public void updateVehicle(Connection con,Vehicle vehicle,int vehicleID) throws MyException{
		try {
			VehicleJDBCHelper.update(con,vehicle,vehicleID);
		} catch (MyException e) {
			e.printStackTrace();
			throw e;
		}
	}
	public List<String> getAllCarMake(Connection con) throws MyException {
		return AvailableMake.getAllCarMake(con);
	}
	
	public Map<Integer,Vehicle> searchByMake(Connection con,String make) throws MyException {
		return SearchCar.searchByMake(con,make);
	}
	
	public boolean isValidAdmin(Connection con,String email,String password) throws MyException {
		return LogIn.isValidAdmin(con,email, password);
	}
	public Map<Integer,Vehicle> searchByVehicleID(Connection con,int vehicleID) throws MyException {
		return SearchCar.searchByVehicleID(con,vehicleID);
	}
}
