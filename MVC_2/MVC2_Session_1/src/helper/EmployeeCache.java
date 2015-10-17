/*
 * This is helper class to maintain a concurrent map which stores employee.It is a singleton class. 
 */
package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;





import model.Employee;

public class EmployeeCache {
	private static EmployeeCache employeeCache = new EmployeeCache();
	private static Map<Integer,Employee> cache = new ConcurrentHashMap<Integer, Employee>();
	private EmployeeCache() {
		
	}
	//method to get instance of this class
	public static EmployeeCache getInstance() {
		return employeeCache;
	}
	//static method which invoke when application starts
	static {
		cache.put(1, new Employee("Avinash", "avinash@gmail.com", 1, 21, new java.util.Date().toString()));
		cache.put(2, new Employee("Rohit", "rohit@gmail.com", 2, 21, new java.util.Date().toString()));
		cache.put(3, new Employee("Babalu", "babalu@gmail.com", 3, 21, new java.util.Date().toString()));
		cache.put(4, new Employee("Banwari", "banwari@gmail.com", 4, 21, new java.util.Date().toString()));
		cache.put(5, new Employee("Amit", "amit@gmail.com", 5, 21, new java.util.Date().toString()));
	}
	//method to get id
	public Employee getEmployeeForId(int id) {
		if( cache.get(id)!= null ) {
			return cache.get(id);
		}
		else {
			return null;
		}
	}
	//method which return all the employee
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>(cache.values());
		return list;
	}
	//method to update information of employee
	public void updateEmployee(Employee e) {
		cache.put(e.getId(), e);
	}
	//method to add new information of employee
	public void addEmployee(Employee e) {
		cache.put(e.getId(), e);
	}
}
