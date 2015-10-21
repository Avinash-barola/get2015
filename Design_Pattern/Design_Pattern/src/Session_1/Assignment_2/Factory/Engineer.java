/*
 * this is a factory class to create object
 */
package Session_1.Assignment_2.Factory;

import Session_1.Assignment_2.Enum.EngineerType;
import Session_1.Assignment_2.Model.Developer;
import Session_1.Assignment_2.Model.IEngineer;
import Session_1.Assignment_2.Model.MechanicalEngineer;

public class Engineer {
	/*
	 * if Engineer Type is Developer then it will return Developer Object else Mechanical Object
	 */
	public IEngineer getEngineer(EngineerType engineerType) {
		if(engineerType.equals(EngineerType.Developer)) {
			return  Developer.getDeveloperInstance();
		}
		else{
			return MechanicalEngineer.getMechanicalEngineerInstance();
		}
	}
}
