import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//class to create a binary tree
public class BinaryTree extends Node{
	Node nodeObject=new Node();
	int countNode = 1;//variable to count total number of nodes
	String inorderItem = "";
	//method to insert a node in binary tree
	public Node insert ( Node node,Object nodeInformation) {
		if( node == null ) {    //base condition of recursive method
			node= nodeObject.getNewNode(nodeInformation);
			node.leftChildAddress = null;
			node.rightChildAddress = null;
			countNode++;
		}
		else {         //recursive call of method
			if( countNode%2 == 0 ) {
				node.leftChildAddress = insert(node.leftChildAddress,nodeInformation);
			}
			else {
				node.rightChildAddress = insert( node.rightChildAddress, nodeInformation );
			}
		}
		return node;
	}
	//method to show inorder traversal
	String inorder( Node node ) {
		if( node != null ) {
			inorder( node.leftChildAddress );
			inorderItem = inorderItem+(node.nodeInformation);
			inorder( node.rightChildAddress );
		}
		return inorderItem;
	}
	//Method to check trees are mirror image or not
	boolean mirrorImage( BinaryTree binaryTree2 ) {
		String tree1, tree2;
		boolean isMirrorImage=false;
		tree1 = inorder( rootNode );
		tree2 = binaryTree2.inorder( binaryTree2.rootNode );
		tree2 = new StringBuffer(tree2).reverse().toString();
		if( tree1.length() == tree2.length() ) {
				if( tree1.equals(tree2) ) {
					isMirrorImage=true;
					return isMirrorImage;
				}
				else
				{
					return isMirrorImage;
				}
			}
		else {
			return isMirrorImage;
		}
	}
	public static void main(String[] args) {
		int choise;
		Scanner sc = new Scanner(System.in);
		BinaryTree binaryTree1=new BinaryTree();
		BinaryTree binaryTree2=new BinaryTree();
		//try {
			while(true) {
				System.out.print("\n 1. Insert in first tree\n 2. Insertion in second tree\n 3. Check Mirror Image\n 4. Exit");
				System.out.print("\n Enter your choice : ");
				choise = sc.nextInt();
				switch(choise) { 
				case 1:
					System.out.print("\n Enter node value : ");
					Object item = sc.nextInt();
					binaryTree1.rootNode = binaryTree1.insert( binaryTree1.rootNode, item );
					break;
				case 2:
					System.out.print("\n Enter node value : ");
					item = sc.nextInt();
					binaryTree2.rootNode = binaryTree2.insert( binaryTree2.rootNode, item );
					break;
				case 3:
					boolean isMirrorImage=binaryTree1.mirrorImage(binaryTree2); 
					if(isMirrorImage) {
						System.out.println("yes Mirror Image");
					}
					else {
						System.out.println("no mirror Image");
					}
					break;
				case 4:
					System.exit(0); break;
				default:System.out.println("PLease enter only integer value");
				}
			}
			
		//}//catch(Exception e){System.out.println("Please enter correct value");}

	}

}

