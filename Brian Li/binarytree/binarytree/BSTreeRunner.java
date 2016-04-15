package binarytree;


import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
 		BinarySearchTree bst = new BinarySearchTree();
 		bst.add(90);
 		bst.add(80);
 		bst.add(70);
 		bst.add(100);
 		bst.add(98);
 		bst.add(120);
 		bst.add(85);
 		System.out.println("In Order: "); 
 		bst.inOrder();
 		System.out.println("Pre Order: "); 
 		bst.preOrder();
 		System.out.println("Post Order: "); 
 		bst.postOrder();
 		System.out.println("Reverse Order: "); 
 		bst.revOrder();
 		System.out.println("Tree height is " + bst.getHeight()); 	
 		System.out.println("Tree width is " + bst.getWidth());
 		System.out.println("Number of leaves is " + bst.getLeaves());
 		System.out.println("Number of nodes is " + bst.getNodes());
		System.out.println("Number of levels " + bst.getNumLevels()); 
 		System.out.println("Tree as String " + bst.toString());
 		System.out.println("The tree is " + ((bst.isFull() == true) ? "full" : "not full"));
 		System.out.println("\n\n");
 		System.out.println("The tree " + ((bst.search(100) == true) ? "contains " : "does not contain ") + 100);
 		System.out.println("The tree " + ((bst.search(114) == true) ? "contains " : "does not contain ") + 114);
 		System.out.println("The smallest tree node " + bst.minNode());
 		System.out.println("The largest tree node " + bst.maxNode());
 		System.out.println("\n\n");
 		System.out.println("Tree before removing any nodes");
 		bst.inOrder();
 		System.out.println();
 		System.out.println("Tree after removing 90.");
 		bst.remove(90);
 		bst.inOrder();
 		
 		
 		
 		
 		
 		
 		
 		
 
   }
}