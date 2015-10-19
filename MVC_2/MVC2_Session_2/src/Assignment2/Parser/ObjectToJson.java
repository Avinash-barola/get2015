package Assignment2.Parser;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import Assignment2.Helper.*;

public class ObjectToJson {
	public static void convertObjectToJson() {
		Employee employee = new Employee();
		employee.setEmployeeName("Avinash");
		employee.setDateOfBirth("12-03-1992");
		employee.setDateOfJoining("3-08-2015");
		employee.setEmailId("avinash01.barola@gmail.com");
		employee.setEmployeeId(1);
		employee.setCtcPerAnnum(100000);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("D:\\workplace\\MVC2_Session_2\\src\\Assignment2\\JSON\\employeejsonfromemployee.json"), employee);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
