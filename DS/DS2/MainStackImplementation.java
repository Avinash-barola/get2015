import java.util.InputMismatchException;
import java.util.Scanner;
//class used to define a stack and its operation
class Node {
	Node addressOfNextNode;
	public static Node top;
	Object nodeInformation;
	Node()
	{
		top = null;
	}
	Node(Object nodeInformation) {
		this.nodeInformation=nodeInformation;
	}
}
class StackUsingLinkedList extends Node{
	Node nodeObject = new Node();
	//method to used add an item 
	public void pushAnItem(Object nodeInformation) {
		Node newNode=new Node(nodeInformation);
		if(top==null) {
			top=newNode;
			newNode.addressOfNextNode=null;
		}
		else {
			newNode.addressOfNextNode=top;
			top=newNode;
		}
	}
	public boolean isEmpty()
	{
		boolean isEmpty = false;
		if( top == null )
		{
			isEmpty = true;
		}
		return isEmpty;
	}
	//method to remove an item
	public Object popAnItem() {
		Object poppedItem=null;
		boolean isEmpty;
		isEmpty = isEmpty();
		
		if( isEmpty == true)
		{
			return "Stack is empty";
		}
		else if(top.addressOfNextNode==null) {
			poppedItem=top.nodeInformation;
			top=null;
			return poppedItem;
		}
		else {
			poppedItem=top.nodeInformation;
			top=top.addressOfNextNode;
			return poppedItem;
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
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
					System.out.println("Popped item is "+stackUsingLinkedListObject.popAnItem());
		}catch(InputMismatchException exception){System.out.println("Please enter only values given at screen");}
	}
}

