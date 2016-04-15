package binarytree;

import static java.lang.System.*;
import java.util.LinkedList;

public class BinarySearchTree {
	private TreeNode root;
	private String output;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null) {
			tree = new TreeNode(val);
			return tree;
		}

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);

		if (dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void revOrder() {
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null) {
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight()))
			return 1 + getNumLevels(tree.getLeft());
		else
			return 1 + getNumLevels(tree.getRight());
	}

	// add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull

	public boolean search(Comparable value) {
		return search(value, root);
	}

	private boolean search(Comparable value, TreeNode tree) {
		if (tree.getValue() == value)
			return true;
		if (tree.getRight() == null && tree.getLeft() == null)
			return false;
		return search(value, tree.getRight()) || search(value, tree.getLeft());
	}
	
	public boolean lookupNumber(Comparable value){
		return lookupNumber(value, root);
	}
	
	private boolean lookupNumber(Comparable value, TreeNode tree) {
		String name = ((PhoneEntry)tree.getValue()).getName();
		if (name.equals(((PhoneEntry)value).getName())){
			System.out.println(((PhoneEntry)tree.getValue()).getNumber());
			return true;
		}
		if (tree.getRight() == null || tree.getLeft() == null)
			return false;
		return lookupNumber(value, tree.getRight()) || lookupNumber(value, tree.getLeft());
	}
	
	public boolean reverseLookup(Comparable value){
		return reverseLookup(value, root);
	}
	
	private boolean reverseLookup(Comparable value, TreeNode tree) {
		if (((PhoneEntry)tree.getValue()).getNumber().equals(((PhoneEntry)value).getNumber())){
			System.out.println(((PhoneEntry)tree.getValue()).getName());
			return true;
		}
		if (tree.getRight() == null || tree.getLeft() == null)
			return false;
		return reverseLookup(value, tree.getRight()) || reverseLookup(value, tree.getLeft());
	}

	public int getHeight() {
		return getNumLevels() - 1;
	}

	public int getWidth() {
		return getNumLevels(root.getLeft()) + getNumLevels(root.getRight()) + 1;
	}

	public int getLeaves() {
		return getLeaves(root);
	}

	private int getLeaves(TreeNode tree) {
		if (tree.getLeft() == null && tree.getRight() == null)
			return 1;
		else if (tree.getLeft() != null && tree.getRight() != null)
			return getLeaves(tree.getLeft()) + getLeaves(tree.getRight());
		else if (tree.getLeft() != null)
			return getLeaves(tree.getRight());
		else
			return getLeaves(tree.getRight());
	}

	public int getNodes() {
		return getNodes(root);
	}

	private int getNodes(TreeNode tree) {
		if (tree.getLeft() == null || tree.getRight() == null)
			return 1;
		else
			return 1 + getNodes(tree.getLeft()) + getNodes(tree.getRight());
	}

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(TreeNode tree) {
		if (tree.getRight() != null && tree.getLeft() != null)
			return isFull(tree.getLeft()) && isFull(tree.getRight());
		else if (tree.getRight() == null && tree.getLeft() == null)
			return true;
		else
			return false;
	}

	public Comparable maxNode() {
		return maxNode(root).getValue();
	}

	private TreeNode maxNode(TreeNode tree) {
		if (tree.getRight() == null && tree.getLeft() == null)
			return tree;
		else
			return maxNode(tree.getRight());
	}

	public Comparable minNode() {
		return minNode(root).getValue();
	}

	private TreeNode minNode(TreeNode tree) {
		if (tree.getRight() == null && tree.getLeft() == null)
			return tree;
		else
			return minNode(tree.getLeft());
	}

	public void levelOrder() {
		levelOrder(root);

	}

	private void levelOrder(TreeNode tree) {
		if (tree.getLeft() == null && tree.getRight() == null)
			System.out.print(tree.getValue() + " ");
		else {
			System.out.print(tree.getValue() + " ");
			levelOrder(tree.getLeft());
			levelOrder(tree.getRight());
		}
	}

	// level order

	// display like a tree

	// remove
	public void remove(Comparable value) {
		remove(value, root);
	}

	private TreeNode remove(Comparable val, TreeNode tree) {
		if (tree != null) {
			int dirTest = val.compareTo(tree.getValue());
			if (dirTest < 0)
				tree.setLeft(remove(val, tree.getLeft()));
			else if (dirTest > 0)
				tree.setRight(remove(val, tree.getRight()));
			else {
				if (tree.getRight() == null) {
					tree = tree.getLeft();
				} else {
					TreeNode successor = getSmallest(tree.getRight());
					tree.setValue(successor.getValue());
					tree.setRight(remove(successor.getValue(), tree.getRight()));
				}

			}
		}
		return tree;
	}
	
	public void deleteNumber(Comparable value) {
		remove(value, root);
	}

	private TreeNode deleteNumber(Comparable val, TreeNode tree) {
		if (tree != null) {
			int dirTest = (((PhoneEntry)val)).getName().compareTo(((PhoneEntry)(tree.getValue())).getName());
			if (dirTest < 0)
				tree.setLeft(remove(val, tree.getLeft()));
			else if (dirTest > 0)
				tree.setRight(remove(val, tree.getRight()));
			else {
				if (tree.getRight() == null) {
					tree = tree.getLeft();
				} else {
					TreeNode successor = getSmallest(tree.getRight());
					tree.setValue(successor.getValue());
					tree.setRight(remove(successor.getValue(), tree.getRight()));
				}

			}
		}
		return tree;
	}

	private TreeNode getSmallest(TreeNode tree) {
		if (tree.getLeft() == null)
			return tree;
		else
			return getSmallest(tree.getLeft());
	}

	public String toString() {
//		output = "";
//		setOutput(root);
//		return output;
		return toString(root);
	}

	 private String toString(TreeNode tree) {
	 if (tree.getLeft() == null && tree.getRight() == null)
	 return tree.getValue() + "";
	 return toString(tree.getLeft()) + " " + tree.getValue() + " "
	 + toString(tree.getRight());
	 }
	private void setOutput(TreeNode tree) {
		if (tree != null) {
			setOutput(tree.getLeft());
			output += (tree.getValue() + "\n");
			setOutput(tree.getRight());
		}
	}
}