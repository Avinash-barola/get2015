package Session_1.Assignment_2.Model;

import Session_1.Assignment_2.Enum.EngineerType;

public class MechanicalEngineer implements IEngineer{
	String name;
	EngineerType role = EngineerType.MechenicalEngineer;
	private MechanicalEngineer(){
		
	}
	public static MechanicalEngineer getMechanicalEngineerInstance() {
		return new MechanicalEngineer();
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
