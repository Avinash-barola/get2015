/*
 * this is main class
 */
package Session_1.Assignment_2;

import java.util.Iterator;
import java.util.List;

import Session_1.Assignment_2.Enum.EngineerType;
import Session_1.Assignment_2.Factory.Engineer;
import Session_1.Assignment_2.Model.IEngineer;
import Session_1.Assignment_2.Model.IWorkStation;
import Session_1.Assignment_2.Model.Office;

public class Main {
	public static void main(String args[]) {
		String name = "Avinash";//first set name
		EngineerType role = EngineerType.Developer;//then get type of engineer
		Engineer engineer = new Engineer();//create object of factory class
		IEngineer iEngineer = engineer.getEngineer(role);//factory class object return Developer class instance
		iEngineer.setName(name);
		IWorkStation iWorkStation = Office.getOfficeInstance();//to get instance of Office class
		iWorkStation.setEngineerList(iEngineer);//setting iEngineer Object
		name = "rohit";
		role = EngineerType.MechenicalEngineer;
		iEngineer = engineer.getEngineer(role);
		iEngineer.setName(name);
		iWorkStation.setEngineerList(iEngineer);
		List<IEngineer>engineerList = iWorkStation.getEngineerList();//to get engineer List
		Iterator<IEngineer> iterator = engineerList.iterator();
		while(iterator.hasNext()) {
			iEngineer = iterator.next();
			System.out.println(iEngineer.toString());
		}
	}
}
