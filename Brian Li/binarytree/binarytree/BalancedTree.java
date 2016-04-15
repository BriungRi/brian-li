package binarytree;

public class BalancedTree {
	String code = "";
	TreeNode root;
	
	public BalancedTree(Morse[]data){
		setRoot(balance(data));
	}
	
	public void setRoot(TreeNode tree){
		root = tree;
	}
	
	public TreeNode getRoot(){
		return root;
	}
	

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + "\n");
			inOrder(tree.getRight());
		}
	}

	
	public TreeNode balance(Morse arr[]){
		return balance(arr, 0, arr.length-1);
	}
	
	private TreeNode balance(Morse[] arr, int start, int end){
		if(start > end)
			return null;
					
		int mid = start + (end - start) / 2;
		TreeNode temp = new TreeNode(arr[mid]);
		
		temp.setLeft(balance(arr, start, mid - 1));
		temp.setRight(balance(arr, mid + 1, end));
		
		return temp;
		
			
	}
	

	public static void main(String[] args) {
//		int[] data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//		BalancedTree x = new BalancedTree(data);
//		System.out.println("InOrder");
//		x.inOrder();
//		TreeNode temp = x.getRoot();
//		System.out.println("Right Branch");
//		while(temp != null){
//			System.out.print(temp+ " ");
//			temp = temp.getRight();
//		}

	}

}
