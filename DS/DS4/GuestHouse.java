import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
class RoomAlotement {
	public List<String> showRoomStatus(Enumeration<Integer> roomNumbers,Hashtable<Integer, String> rooms,int roomNumber) {
		List< String> roomStatus=new ArrayList<String>();
		roomNumbers = rooms.keys();	// room numbers hold all the keys (room numbers) from hash table
		while(roomNumbers.hasMoreElements()) {
	         roomNumber = roomNumbers.nextElement();
	         roomStatus.add("Room "+(roomNumber) + " : " +rooms.get(roomNumber));
	           // show the status of each room
		}
		return roomStatus;
	}
	public String allotRoom(Hashtable<Integer, String>rooms,int age,String name,int numberOfRooms) {
		int i,count=0,hashCode;
		String result="";
		boolean flag = true;
		hashCode = age % numberOfRooms;	// if age is greater than 18 than generate hash code
		for(i = hashCode; i <= (numberOfRooms - 1);) {   // continue the loop until house is empty
			if(rooms.get(i).equals("")) {   // if room is empty
				rooms.put(i, name); // than allocate that room to that user
				System.out.println("Room number "+i+" is alloted to "+name);
				flag = false;
				break;
			}
			else {
				i += 3;	// if room is full than increment i with 3 
			}
		}
		i = 0;
		while(flag) {   // if room not found
			for(int j = i; j <= (numberOfRooms - 1); j++) {  // than check rooms status from starting
				if(rooms.get(j).equals("")) {   // if empty than allocate
					rooms.put(j, name);
					result="Room number "+j+" is alloted to "+name;
					flag = false;
					break;
				}
				else {
					j += 3;
				}
			}
			i++;
		}
		count++;
		return result;
	}
	public String getPerticularRoomStatus(int roomNumber,Hashtable<Integer, String>rooms) {
		String result="";
		if( rooms.get(roomNumber) != "" ) // if room is allocated someone than print that person name
			result="Room "+roomNumber+" is alloted to "+rooms.get(roomNumber);
		else							// otherwise print not alloted to any one
			result = "Room is not alloted to anyone yet";
		return result;
	}
	public String getPerticularPersonStatus(String name,Hashtable<Integer,String> rooms,Enumeration<Integer> roomNumbers,int roomNumber) {
		String result="";
		boolean flag = false;
		roomNumbers = rooms.keys();
		while(roomNumbers.hasMoreElements()) { // find any room is allocated to this person or not
			roomNumber = roomNumbers.nextElement();
			if(rooms.get(roomNumber).equalsIgnoreCase(name)) {
	        	flag = true;
				break;
			}
		}
		if(flag == true)
			result=name+" is alloted room Number "+ roomNumber;
		else
			result="Not alloted any room to "+name;
		return result;
	}
}
public class GuestHouse {
	private static void input() {
		Scanner scan = null;
		RoomAlotement roomAlotementObject=new RoomAlotement();
		BufferedReader bufferedReaderObj = null;
		try
		{
			scan = new Scanner(System.in); // object to take choice of user
			String name;
			int age, i, count = 1;
			int roomNumber = 0;
			boolean flag=false;
			Enumeration<Integer> roomNumbers = null;
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));	// object to enter the name from user		
			int numberOfRooms;
			int choice;
			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();// make a hash table which holds status of each room
			do {
				System.out.println("Enter Number of rooms: (must be prime number)\n"
						+ "(Please Enter Positive integer Number)");	// enter total number of rooms from user
			while(!scan.hasNextInt()) {				// to check whether number is integer or not
				System.out.println("Please Enter Integer Number");
				scan.next();
			}
			numberOfRooms = scan.nextInt();
			} while(numberOfRooms <= 0);
			
			for(i = 0; i < numberOfRooms; i++)
			{
				rooms.put(i, "");	// initially each room is empty
			}
			
			
			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: "); // at last print status of all rooms
			roomNumbers = rooms.keys();
			while(roomNumbers.hasMoreElements()) {
		         roomNumber = roomNumbers.nextElement();
		    do{
				flag = true;
				System.out.println("1. Show Status of rooms");	// create menu for user option
				System.out.println("2. Allot room to a guest");
				System.out.println("3. Particular Room Status");
				System.out.println("4. Particular Person Status");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				do {
					System.out.println("(Please Enter Positive integer Number less than 6)");	// take user choice
				while(!scan.hasNextInt()) {
					System.out.println("Please Enter Integer Number");
					scan.next();
				}
				choice = scan.nextInt();
				} while( choice <= 0 || choice >= 6 );
				switch(choice)
				{
					case 1:
						System.out.println("Status of rooms is: ");
						System.out.println(roomAlotementObject.showRoomStatus(roomNumbers,rooms,roomNumber));
					    break;
				    
					case 2:
						System.out.println("Enter name of guest: ");
						name = bufferedReaderObj.readLine(); // take the name of guest
						System.out.println("Enter age of the guest: ");
						do {
							System.out.println("(Please Enter Positive integer Number greater than or equal to 18)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();			// take age of guest
						}
						age = scan.nextInt();
						} while(age < 18);
						System.out.println(roomAlotementObject.allotRoom(rooms,age,name,numberOfRooms));
						break;
						
					case 3:
						System.out.println("Enter Room Number: ");
						do {
							System.out.println("(Please Enter Positive integer Number)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						roomNumber = scan.nextInt();
						} while(roomNumber < 0 || roomNumber > (numberOfRooms - 1)); // check room status
						System.out.println(roomAlotementObject.getPerticularRoomStatus(roomNumber, rooms));
						break;
						
					case 4:
						System.out.println("Enter Name: ");
						roomNumber = 0;
						name = bufferedReaderObj.readLine();// take name of guest
						System.out.println(roomAlotementObject.getPerticularPersonStatus(name, rooms, roomNumbers, roomNumber));
						break;
						
					case 5:
						System.out.println("System Exited");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter correct Choice");
				}
			} while(count < numberOfRooms); // continue the loop until all rooms is full
		         System.out.println("Room "+(roomNumber) + " : " +
		         rooms.get(roomNumber));
			}
			scan.close();
			bufferedReaderObj.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			scan.close();
		}
	}
	public static void main(String[] args) {
		input();
	}
}

