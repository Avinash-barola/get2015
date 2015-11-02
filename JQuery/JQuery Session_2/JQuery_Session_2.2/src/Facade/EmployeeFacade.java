package Facade;

import java.sql.Connection;
import java.sql.SQLException;

import DBHelper.EmployeeDetails;
import Model.Employee;

public class EmployeeFacade {
	public Employee getEmployeeDetails(Connection con,String name) throws SQLException {
		return EmployeeDetails.getEmployeeDetails(con,name);
	}	
}
