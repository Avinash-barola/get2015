import java.util.InputMismatchException;
import java.util.Scanner;
//class used to define a stack and its operation
class Node {
	Node addressOfNextNode,top;
	Object listInformation;
}
class StackUsingLinkedList extends Node{
	
	public StackUsingLinkedList() { //constructor to initialize stack
		top=null;
	}
	//method to used add an item 
	public void pushAnItem(int listInformation) {
		StackUsingLinkedList node=new StackUsingLinkedList();
		node.listInformation=listInformation;
		if(top==null) {
			top=node;
			node.addressOfNextNode=null;
		}
		else {
			node.addressOfNextNode=top;
			top=node;
		}
	}
	//method to remove an item
	public Object popAnItem() {
		Object poppedItem=null;
		if(top==null) {
			return poppedItem;
		}
		else if(top.addressOfNextNode==null) {
			poppedItem=top.listInformation;
			top=null;
			return poppedItem;
		}
		else {
			poppedItem=top.listInformation;
			top=top.addressOfNextNode;
			return poppedItem;
		}
	}
	// method to display stack items
	public void display() {
		if(top==null) {
			System.out.println("Stack is empty");
		}
		else {
			Node traversingNode=top;
			while(traversingNode!=null) {
				System.out.println(traversingNode.listInformation);
				traversingNode=traversingNode.addressOfNextNode;
			}
		}
	}
}
public class MainStackImplementation {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		StackUsingLinkedList stackUsingLinkedListObject=new StackUsingLinkedList();
		try {
					stackUsingLinkedListObject.pushAnItem(1);
					stackUsingLinkedListObject.pushAnItem(2);
					stackUsingLinkedListObject.pushAnItem(3);
					stackUsingLinkedListObject.pushAnItem(4);
					stackUsingLinkedListObject.pushAnItem(5);
					stackUsingLinkedListObject.display();
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					stackUsingLinkedListObject.display();
		}catch(InputMismatchException exception){System.out.println("Please enter only values given at screen");}
	}
}
