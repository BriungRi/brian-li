import static java.lang.System.*;
import binarytree.TreeNode;

public class HistoTree {
	private HistoNode root;
	private String output;

	public HistoTree() {
		root = null;
	}

	public void addData(Comparable val) {
		root = addData(val, root);
	}

	private HistoNode addData(Comparable val, HistoNode tree) {
		if (tree == null) {
			tree = new HistoNode(val, 1, null, null);
			return tree;
		}

		if (val.equals(tree.getData())) {
			tree = new HistoNode(val, tree.getDataCount() + 1, tree.getLeft(),
					tree.getRight());
			return tree;
		}

		Comparable treeValue = tree.getData();
		int dirTest = val.compareTo(treeValue);

		if (dirTest <= 0)
			tree.setLeft(addData(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(addData(val, tree.getRight()));

		return tree;
	}

	public HistoNode search(Comparable data) {
		return search(data, root);
	}

	private HistoNode search(Comparable data, HistoNode tree) {
		if(data.equals(tree.getData()))
			return tree;
		else if(tree.getRight() == null && tree.getLeft() == null)
			return null;
		int dirTest = data.compareTo(tree.getData());
		
		if(dirTest <= 0)
			return search(data, tree.getLeft());
		else
			return search(data, tree.getRight());
	}

	public String toString() {
		output = "";
		setOutput(root);
		return output;
	}

	private void setOutput(HistoNode tree) {
		if (tree != null) {
			setOutput(tree.getLeft());
			output += (tree.toString() + "\t");
			setOutput(tree.getRight());
		}
	}
}