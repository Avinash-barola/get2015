/*
 * Its a model class for set and get engineer List
 */
package Session_1.Assignment_2.Model;

import java.util.List;

public class Office implements IWorkStation{
	private static Office office = new Office();
	private Office() {
		
	}
	public static Office getOfficeInstance() {
		return office;
	}
	@Override
	public void setEngineerList(IEngineer engineer) {
		engineerList.add(engineer);
	}

	@Override
	public List<IEngineer> getEngineerList() {
		return engineerList;
	}
	
}
