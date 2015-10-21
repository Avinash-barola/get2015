/*
 * Interface IEngineer
 */
package Session_1.Assignment_2.Model;

import Session_1.Assignment_2.Enum.EngineerType;
public interface IEngineer {
	public void setName(String name);
	public String getName();
	public EngineerType getRole();
	public String toString();
}
