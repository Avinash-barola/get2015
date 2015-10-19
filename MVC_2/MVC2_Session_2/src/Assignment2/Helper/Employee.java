package Assignment2.Helper;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Employee {
	
	private String employeeName;
	private int employeeId;
	@JsonIgnore
	private String emailId;
	private String dateOfBirth;
	@JsonIgnore
	private String dateOfJoining;
	@JsonIgnore
	private double ctcPerAnnum;
	
	@JsonProperty
	public String getEmployeeName() {
		return employeeName;
	}
	
	@JsonProperty
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@JsonProperty
	public int getEmployeeId() {
		return employeeId;
	}
	
	@JsonProperty
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@JsonProperty
	public String getEmailId() {
		return emailId;
	}
	
	@JsonIgnore
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@JsonIgnore
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	@JsonProperty
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@JsonProperty
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	
	@JsonIgnore
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	@JsonIgnore
	public double getCtcPerAnnum() {
		return ctcPerAnnum;
	}
	
	@JsonIgnore
	public void setCtcPerAnnum(double ctcPerAnnum) {
		this.ctcPerAnnum = ctcPerAnnum;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId="
				+ employeeId + ", emailId=" + emailId + ", dateOfBirth="
				+ dateOfBirth + ", dateOfJoining=" + dateOfJoining
				+ ", ctcPerAnnum=" + ctcPerAnnum + "]";
	}
	
}
