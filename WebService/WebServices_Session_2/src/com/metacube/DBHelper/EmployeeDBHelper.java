/*
 * Class to use apply function on database
 */
package com.metacube.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.ConnectionFactory.ConnectionFactory;
import com.metacube.Model.EmployeeModel;

public class EmployeeDBHelper {
	//Method to use get an employee by its ID
	public static EmployeeModel getEmployeeByID(int employeeID) {
		EmployeeModel employee = new EmployeeModel();
		Connection connection = ConnectionFactory.getConnection();//getting connection by connectionFactory class
		ResultSet resultSet = null;//initialize resultSet
		PreparedStatement preparedStatement = null;//initialize PreparedStatement
		String query = "Select * from employeeTable where id ="+employeeID;//setting query string
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();//run query
			while (resultSet.next()) {
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setDateOfBirth(resultSet.getString(3));
				employee.setEmail(resultSet.getString(4));
				employee.setAddress(resultSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employee;
	}
	//Method to insert a new employee
	public static int addEmployee(EmployeeModel employeeModel) {
		Connection connection = ConnectionFactory.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String name = employeeModel.getName();
		String dob = employeeModel.getDateOfBirth();
		String email = employeeModel.getEmail();
		String address = employeeModel.getAddress();
		int isInserted = 0;
		String query = "insert into employeeTable(name,dateOfBirth,email,address)values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, dob);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, address);
			isInserted = preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isInserted;
	}
	//	//Metrhod to use get an employee by its Name
	public static List<EmployeeModel> getEmployeeByName(String name) {
		List<EmployeeModel> employeeList = new ArrayList<EmployeeModel>();
		Connection connection = ConnectionFactory.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String query = "Select * from employeeTable where name =?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeModel employee = new EmployeeModel();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setDateOfBirth(resultSet.getString(3));
				employee.setEmail(resultSet.getString(4));
				employee.setAddress(resultSet.getString(5));
				employeeList.add(employee);
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employeeList;
	}
	//Method to get all employee
	public static List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> employeeList = new ArrayList<EmployeeModel>();
		Connection connection = ConnectionFactory.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String query = "Select * from employeeTable";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeModel employee = new EmployeeModel();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setDateOfBirth(resultSet.getString(3));
				employee.setEmail(resultSet.getString(4));
				employee.setAddress(resultSet.getString(5));
				employeeList.add(employee);
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employeeList;
	}
	
	
	//method to delete an employee based on ID
	public static int deleteByID(int id) {
		int isDeleted = 0;
		Connection connection = ConnectionFactory.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String query = "delete from employeetable where id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			isDeleted = preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(isDeleted);
		return isDeleted;
	}
}
