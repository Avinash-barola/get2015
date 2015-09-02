import java.util.InputMismatchException;
import java.util.Scanner;
//class to create a binary search tree and its operation
class Node {
	Object nodeInformation;
	Node rightChildAddress,leftChildAddress,rootNode;
	public Node() {
		rootNode=null;
	}
	public Node getNewNode(Object nodeInformation) {
		Node newNode=new Node();
		newNode.nodeInformation=nodeInformation;
		return newNode;
	}
}
class Preorder {
	String result="";
	Node nodeObject=new Node();
	//to insert a new node in tree
	public Node insertNode(Node node,Object nodeInformation) {	
		if(node==null) {       //base condition of recursive method
			node=nodeObject.getNewNode(nodeInformation);
			node.leftChildAddress=null;
			node.rightChildAddress=null;
		}
		else if((int)node.nodeInformation>=(int)nodeInformation) {
			node.leftChildAddress=insertNode(node.leftChildAddress,nodeInformation);
		}
		else {
			node.rightChildAddress=insertNode(node.rightChildAddress, nodeInformation);
		}
		return node;
	}		
	//to show preorder traversal
	public String displayPreorderTraversal(Node node) {
		if(node!=null) {
			result=result+node.nodeInformation+"->";
			displayPreorderTraversal(node.leftChildAddress);                                                                                   
			displayPreorderTraversal(node.rightChildAddress);
		}	
		return result;
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Node nodeObject=new Node();
		Preorder preorderObject=new Preorder();
		System.out.println("Enter Choise");
		try {
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,8);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,9);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,3);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,1);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,10);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,5);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,4);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,0);
	
				String result=preorderObject.displayPreorderTraversal(nodeObject.rootNode);
				System.out.println("Preorder Traversal is :"+result);
		}catch(Exception exception) {System.out.println("Please Enter only Integer values");}
	}
}

