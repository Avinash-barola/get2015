package Service;
import java.sql.Connection;
import java.sql.SQLException;

import ConnectionFactory.ConnectionFactory;
import Facade.EmployeeFacade;
import Model.Employee;


public class EmployeeService {
	public Employee getEmployeeDetails(String name) {
		Employee employee = null;
		Connection connection = ConnectionFactory.getConnection();
		EmployeeFacade facade = new EmployeeFacade();
		try {
			employee =  facade.getEmployeeDetails(connection, name);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(connection);
		}
		return employee;
	}	
}
