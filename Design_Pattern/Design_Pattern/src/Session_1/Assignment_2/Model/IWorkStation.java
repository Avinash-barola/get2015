/*
 * Interface IEngineer
 */
package Session_1.Assignment_2.Model;

import java.util.ArrayList;
import java.util.List;

public interface IWorkStation {
	static List<IEngineer> engineerList = new ArrayList<IEngineer>();
	public void setEngineerList(IEngineer engineer);
	public List<IEngineer> getEngineerList();
}
