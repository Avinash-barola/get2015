package Assignment2.Parser;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import Assignment2.Helper.*;

public class JsonToObject {
	public static void convertJsonToObject() {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = null;
		try {
			employee = mapper.readValue(new File("D:\\workplace\\MVC2_Session_2\\src\\Assignment2\\JSON\\employee.json"), Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(employee.toString());
	}
}
