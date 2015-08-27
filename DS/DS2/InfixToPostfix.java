import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class Stack {
	Object listInformation;
	char listInformationInChar;
	Stack addressOfNextNode,top;
	public Stack() {
		top=null;
	}
	public void pushAnItem(Object listInformation) {
		Stack node=new Stack();
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
	public void pushAnItem(char listInformationInChar) {
		Stack node=new Stack();
		node.listInformationInChar=listInformationInChar;
		if(top==null) {
			top=node;
			node.addressOfNextNode=null;
		}
		else {
			node.addressOfNextNode=top;
			top=node;
		}
	}
	public Stack popAnItem() {
		Stack stackTopElement;
		if(top==null) {
			stackTopElement=null;
			return stackTopElement;
		}
		else if(top.addressOfNextNode==null) {
			stackTopElement=top;
			top=null;
			return stackTopElement;
		}
		else {
			stackTopElement=top;
			top=top.addressOfNextNode;
			return stackTopElement;
		}
	}
	public void display() {
		if(top==null) {
			System.out.println("Stack is empty");
		}
		else {
			Stack traversingNode=top;
			while(traversingNode!=null) {
				System.out.println(traversingNode.listInformation);
				traversingNode=traversingNode.addressOfNextNode;
			}
		}
	}
}
class Precedence {
	public int getPrcedence(char operand) {
		int precendendeNumber=0;
		switch(operand) {
		case '+':precendendeNumber=1;
			break;
		case '-':precendendeNumber=1;
			break;
		case '*':precendendeNumber=2;
			break;
		case '/':precendendeNumber=2;
			break;
		case '%':precendendeNumber=3;
			break;
		case ')':precendendeNumber=0;
			break;
		case '(':precendendeNumber=0;
		break;
		}
		return precendendeNumber;
	}
}
public class InfixToPostfix extends StackUsingLinkedList{
	public static void main(String args[]) {
		Stack stack=new Stack();
		Precedence precedenceObject=new Precedence();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Infix String");
		String infixString=sc.next();
		String postFixString="";
		int precendencrOfInfixElement,precendencrOfTopElement,infixStingLength=infixString.length();
		int i=0;
			while(infixStingLength!=0)
			{
				char currentInfixCharacter=infixString.charAt(i);
				i++;
				infixStingLength--;
				if(currentInfixCharacter=='(')
					stack.pushAnItem(currentInfixCharacter);
				else if(currentInfixCharacter==')') {
					while(stack.top!=null && stack.top.listInformationInChar!='(') {
						postFixString=postFixString+stack.popAnItem().listInformationInChar;
					}
					stack.popAnItem();
				}
				else if((currentInfixCharacter=='+'||currentInfixCharacter=='-'||currentInfixCharacter=='*'||currentInfixCharacter=='/'||currentInfixCharacter=='%'||currentInfixCharacter=='('||currentInfixCharacter==')') && stack.top==null) {
			    	stack.pushAnItem(currentInfixCharacter);
			    }
			    else if(currentInfixCharacter=='+'||currentInfixCharacter=='-'||currentInfixCharacter=='*'||currentInfixCharacter=='/'||currentInfixCharacter=='%') {
			    	precendencrOfInfixElement=precedenceObject.getPrcedence(currentInfixCharacter);
			    	precendencrOfTopElement=precedenceObject.getPrcedence(stack.top.listInformationInChar);
			    	while(stack.top!=null && precendencrOfTopElement>=precendencrOfInfixElement && stack.top.listInformationInChar!='(') {
			    		postFixString=postFixString+stack.popAnItem().listInformationInChar;
			    	}
			    	stack.pushAnItem(currentInfixCharacter);
			    }
			    else {
			    	postFixString=postFixString+currentInfixCharacter;
			    }
			}
			if(stack.top!=null){
			while(stack.top!=null) 
				postFixString=postFixString+stack.popAnItem().listInformationInChar;}
			System.out.println(postFixString);
		}
	}

