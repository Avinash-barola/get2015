import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Precedence {
	public static int getPrcedence(Object operand) {
		int precendendeNumber=0;
		switch((char)operand) {
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
		InfixToPostfix stack=new InfixToPostfix();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Infix String");
		String infixString=sc.next();
		String postFixString="";
		List<Object> operandList = new ArrayList<Object>();
		operandList.add('+');
		operandList.add('-');
		operandList.add('*');
		operandList.add('/');
		operandList.add('%');
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
					while(!top.nodeInformation.equals((Object)'(')) {
						postFixString=postFixString+stack.popAnItem();
					}
					stack.popAnItem();
				}
				else if((operandList.contains(currentInfixCharacter)) && top==null) {
			    	stack.pushAnItem(currentInfixCharacter);
			    }
			    else if(operandList.contains(currentInfixCharacter)) {
			    	precendencrOfInfixElement=Precedence.getPrcedence(currentInfixCharacter);
			    	precendencrOfTopElement=Precedence.getPrcedence(top.nodeInformation);
			    	while(top!=null && precendencrOfTopElement>=precendencrOfInfixElement && top.nodeInformation!=(Object)'(') {
			    		postFixString=postFixString+stack.popAnItem();
			    	}
			    	stack.pushAnItem(currentInfixCharacter);
			    }
			    else {
			    	postFixString=postFixString+currentInfixCharacter;
			    }
			}
			while(!stack.isEmpty()) 
				postFixString=postFixString+stack.popAnItem();
			System.out.println(postFixString);
		}
	}



