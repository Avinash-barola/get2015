
/*
 * Its a model class for set and get name of Engineer 
 *  */
package Session_1.Assignment_2.Model;

import Session_1.Assignment_2.Enum.EngineerType;

public class Developer implements IEngineer{
	String name;
	EngineerType role = EngineerType.Developer;
	private Developer() {
		
	}
	public static Developer getDeveloperInstance() {
		return new Developer();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EngineerType getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "Developer [name=" + name + ", role=" + role + "]";
	}
	
}
