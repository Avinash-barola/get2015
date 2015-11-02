package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Employee;

public class EmployeeDetails {
	public static Employee getEmployeeDetails(Connection con,String name) throws SQLException {
		String query = "Select * from employee where name = '"+name+"'";
		ResultSet resultSet = null;
		Employee employee = new Employee();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				employee.setName(resultSet.getString(1));
				//System.out.println("DB");
				employee.setDateOfBirth(resultSet.getString(2));
				employee.setEmail(resultSet.getString(3));
				employee.setAddress(resultSet.getString(4));

			}
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				} 
				if(stmt!=null) {
					stmt.close();
				}	
			}catch (SQLException e) {
			e.printStackTrace();
			}
		}
		return employee;
	}
}