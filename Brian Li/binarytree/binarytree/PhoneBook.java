package binarytree;

public class PhoneBook {
	private BinarySearchTree bst;
	
	public PhoneBook(){
		bst = new BinarySearchTree();
	}
	
	public void add(PhoneEntry a){
		bst.add(a);
	}
	
	public void lookupNumber(String a){
		bst.lookupNumber(new PhoneEntry(a, ""));
	}
	
	public void reverseLookup(String a){
		bst.reverseLookup(new PhoneEntry("", a));
	}
	
	public String display(){
		return bst.toString();
	}
	
	public void delete(String deletedName){
		bst.deleteNumber(new PhoneEntry(deletedName, ""));
	}
}
