
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import helper.MyException;
import helper.VehicleHelper;
import helper.VehicleJDBCHelper;
import helper.VehicleType;
import model.Vehicle;
import VehicleXML.ReadInputXml;
public class VehicleMain {

	public static void main(String[] args) throws MyException {
		Vehicle vehicleObj1 = VehicleHelper.createVehicle(VehicleType.Bike, "apacheRTR", "TVS");
		Vehicle vehicleObj2 = VehicleHelper.createVehicle(VehicleType.Bike, "Pulsar", "Bajaj");
		Vehicle vehicleObj3 = VehicleHelper.createVehicle(VehicleType.Bike, "apacheRTR", "TVS");
		/* make a set of vehicles */
		Set<Vehicle> vehicleSet = new HashSet<Vehicle>();
		vehicleSet.add(vehicleObj1);
		vehicleSet.add(vehicleObj2);
		vehicleSet.add(vehicleObj3);
		/* check duplicate entries should not be come */
		System.out.println("\n Size of vehicleSet is : "+vehicleSet.size());
		 
		/* read xml file and make a list of vehicle objects*/
		ReadInputXml read = new ReadInputXml();
		List<Vehicle> vehicleList = read.readConfig("Config.xml");
		for(Vehicle vehicleItems : vehicleList)
		{
			VehicleJDBCHelper.create(vehicleItems);   // put all objects in database from list
		}
				
		/* add vehicles in database using vehicleHelper*/		
		Vehicle vehicle = VehicleHelper.createVehicle(VehicleType.Bike, "starcity", "TVS"); // call create vehicle for bike
		VehicleJDBCHelper.create(vehicle);
		
		vehicle = VehicleHelper.createVehicle(VehicleType.Car, "i10", "Hyundai");
		VehicleJDBCHelper.create(vehicle);

	}

}
