package Assignment1;

import java.lang.reflect.Method;

public class MainAnnotation {
	public static void main(String[] args) throws Exception {
		Employee employee = new Employee();
		Method[] methods = employee.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Enhancement.class)) {
				Enhancement test = method.getAnnotation(Enhancement.class);
				int info = test.id();
				String synopsis = test.synopsis();
				if (1 == info) {
					System.out.println("info is awesome!");
					method.invoke(Employee.class.newInstance(), info, synopsis,test.engineer(), test.date());
				}
			}
		}
	}
}
