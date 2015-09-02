import java.util.InputMismatchException;
import java.util.Scanner;
//class to create a binary search tree and its operation
class Postorder {
	String result="";	
	//to show post order traversal*/
	public String getPostorderTraversal(Node node) {
		if(node!=null) {
			getPostorderTraversal(node.leftChildAddress);                                                                                   
			getPostorderTraversal(node.rightChildAddress);
			result=result+node.nodeInformation+"->";
		}	
		return result;
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Node nodeObject=new Node();
		Preorder preorderObject=new Preorder();
		Postorder postorderObject=new Postorder();
		//try {
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,8);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,9);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,3);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,1);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,10);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,5);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,4);
				nodeObject.rootNode=preorderObject.insertNode(nodeObject.rootNode,0);
	
				String result=postorderObject.getPostorderTraversal(nodeObject.rootNode);
				System.out.println("Postorder Traversal is :"+result);
		//}//catch(Exception exception) {System.out.println("Please Enter only Integer values");}
	}
}
