/*
 * this is view class to display menu on console
 */
package Session_2.Assignment_3.View;

import java.util.Scanner;

import Session_2.Assignment_3.Cricket;
import Session_2.Assignment_3.Enum.GameType;
import Session_2.Assignment_3.Factory.TypeOfCricket;

public class CricketView {
	public static void view() {
		GameType gameType;//creating object of enum GameType
		int choice;
		do {
			System.out.println("Enter game type::");
			System.out.println("\n1:20-20\n2:One Day\n3:Test\n0:Exit");
			Scanner scanner =new Scanner(System.in);
			while (!scanner.hasNextInt()) {
				System.out.println("Please Enter only Integer!");
				scanner.next();
			}
			choice = scanner.nextInt();
			if(choice == 1) {
				gameType = GameType._20__20;
				TypeOfCricket typeOfCricket = new TypeOfCricket();//Object of Factory class TypeOfCricket
				Cricket cricket = typeOfCricket.getCricketType(gameType);//now taking object of _20_20 class in cricket object
				cricket.play();//calling of play method of _20_20 class
			}
			else if(choice == 2) {
				gameType = GameType.OneDay;
				TypeOfCricket typeOfCricket = new TypeOfCricket();
				Cricket cricket = typeOfCricket.getCricketType(gameType);
				cricket.play();
			}
			else if(choice == 3) {
				gameType = GameType.Test;
				TypeOfCricket typeOfCricket = new TypeOfCricket();
				Cricket cricket = typeOfCricket.getCricketType(gameType);
				cricket.play();
			}
			else if(choice == 0) {
				System.out.println("Exit::");
				System.exit(0);
			}
			else {
				System.out.println("Please Enter Correct Choise");
			}
		}while(choice != 0);
	}
}
