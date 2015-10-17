package model;


public class Employee {
	String name;
	String email;
	int id;
	int age;
	String registrationDate;
	public Employee(String name, String email, int id, int age,
			String registrationDate) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
		this.age = age;
		this.registrationDate = registrationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
}
