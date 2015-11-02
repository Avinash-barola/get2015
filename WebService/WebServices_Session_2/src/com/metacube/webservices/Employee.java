//Webservice class
package com.metacube.webservices;
 
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.metacube.DBHelper.EmployeeDBHelper;
import com.metacube.Model.EmployeeModel;
 
@Path("/Employee")//to set path
public class Employee {
	@Path("{name}/{dob}/{email}/{address}")//to create parameter
	@GET//method type
	@Produces("application/xml")
	//method to get Employee By its ID
	public String getEmployeeByID(@PathParam("name") String name,@PathParam("dob") String dob,@PathParam("email") String email,@PathParam("address") String address) {
		EmployeeModel employeeModel = new EmployeeModel();//creating object of model class
		//setting parameter of employeeModel Object
		employeeModel.setName(name);
		employeeModel.setEmail(email);
		employeeModel.setDateOfBirth(dob);
		employeeModel.setAddress(address);
		int isInserted = EmployeeDBHelper.addEmployee(employeeModel);//calling function of DBHelper class 
		if(isInserted == 1) {
			String result = "@Produces(\"application/xml\") Output: \n\nEmployee Insert Output: \n\n Employee named "+name+" created successfully ";
			return "<Employee>"+result+"</Employee>";
			
		}
		else {
			String result = "@Produces(\"application/xml\") Output: Employee Insert Output: \n\n Sorry Cant Create a new Employee named "+name;
			return "<ctofservice>" +result;
		}
	}
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String getEmployeeByID(@PathParam("c") int id) {
		int employeeID = id;
		EmployeeModel employeeModel = EmployeeDBHelper.getEmployeeByID(employeeID);
		if(employeeModel.getId()!=0) {
			String result = "@Produces(\"application/xml\") Output: \n\nEmployee Search result: \n\n";
			return "<Employee>" +result+ "<ID>" + employeeModel.getId() + "</ID>" +  "<Name>" + employeeModel.getName() + "</Name>" + "<DOB>" + employeeModel.getDateOfBirth() + "</DOB>" + "<E-mail>" + employeeModel.getEmail() + "</E-mail>" + "<Address>" + employeeModel.getAddress() + "</Address>" +"</Employee>";
		}
		else {
			return "<Employee>No Employee Available with this ID:"+id+"</Employee>";
		}
	}
	
	@Path("/name/{nameOfEmployee}")
	@GET
	@Produces("application/xml")
	public String getEmployeeByName(@PathParam("nameOfEmployee") String nameOfEmployee) {
		System.out.println("name");
		int i=1;
		List<EmployeeModel> employeeList = EmployeeDBHelper.getEmployeeByName(nameOfEmployee);
		EmployeeModel employeeModel;
		if(employeeList.size()>0) {
			String result = "";
			Iterator<EmployeeModel> iterator = employeeList.listIterator();
			while (iterator.hasNext()) {
				employeeModel = iterator.next();
				result += " \n\n<employee"+(i++)+">\n<ID>" + employeeModel.getId() + "</ID>" +  "\n<Name>" + employeeModel.getName() + "</Name>" + "\n<DOB>" + employeeModel.getDateOfBirth() + "</DOB>" + "\n<E-mail>" + employeeModel.getEmail() + "</E-mail>" + "\n<Address>" + employeeModel.getAddress() + "</Address></employee>";			
			}
			return "<Employee>" +result+"</Employee>";
		}
		else {
			String result = "@Produces(\"application/xml\") Output: \n\nEmployee search result: No employee available with name "+nameOfEmployee+"\n\n";
			return "<Employee>" +result+"</Employee>";
		}
	}
	
	@Path("/getAllEmployee")
	@GET
	@Produces("application/xml")
	public String getAllEmployees() {
		int i=1;
		List<EmployeeModel> employeeList = EmployeeDBHelper.getAllEmployees();
		EmployeeModel employeeModel;
		if(employeeList.size()>0) {
			String result = "";
			Iterator<EmployeeModel> iterator = employeeList.listIterator();
			while (iterator.hasNext()) {
				employeeModel = iterator.next();
				result += " \n\n<employee"+(i++)+">\n<ID>" + employeeModel.getId() + "</ID>" +  "\n<Name>" + employeeModel.getName() + "</Name>" + "\n<DOB>" + employeeModel.getDateOfBirth() + "</DOB>" + "\n<E-mail>" + employeeModel.getEmail() + "</E-mail>" + "\n<Address>" + employeeModel.getAddress() + "</Address></employee>";			
			}
			return "<ctofservice>" +result+"</ctofservice>";
		}
		else {
			String result = "@Produces(\"application/xml\") Output: \n\nEmployee search result: No employee available\n\n";
			return "<Employee>" +result+"</Employee>";
		}
	}
	
	@Path("/delete/{id}")
	@GET
	@Produces("application/xml")
	public String deleteByID(@PathParam("id") int id) {
		int employeeID = id;
		int isDeleted = EmployeeDBHelper.deleteByID(employeeID);
		if(isDeleted == 1) {
			return "<Employee>Employee with id "+id+"deleted successfully</Employee>";
		}
		else {
			return "<Employee>Can not delete Employee with id "+id+"</Employee>";
		}
	}
}
