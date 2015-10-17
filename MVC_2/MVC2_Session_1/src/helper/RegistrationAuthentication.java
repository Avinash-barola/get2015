/*
 * Class to authenticate that id is already exists or not
 */
package helper;

public class RegistrationAuthentication {
	
	public static boolean authenticate( int id ) {
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		if ( employeeCache.getEmployeeForId(id) == null ) {
			return true;
		}
		else {
			return false;
		}
	}
}
