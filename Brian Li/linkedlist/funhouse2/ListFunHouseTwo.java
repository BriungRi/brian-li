package funhouse2;

//Name -
//Date -
//Class - 
//Lab  -  

import static java.lang.System.*;
import funhouse.ListNode;

public class ListFunHouseTwo {
	private ListNode theList;
	private ListNode head;

	public ListFunHouseTwo() {
		theList = new ListNode();
	}

	public void add(Comparable data) {
		if(head == null){
			head = new ListNode(data, theList);
			theList = new ListNode(head.getValue(), head);
		}
		else{
			ListNode toAdd = theList;
			while(toAdd.getNext() != head){
				toAdd = toAdd.getNext();
			}
			toAdd.setNext(new ListNode(data, head));
			
		}
	}

	// this method will return the number of nodes present in list
	public int nodeCount() {
		return -1;
	}

	// this method will create a new node with the same value as the first node
	// and add this
	// new node at the front of the list. Once finished, the first node will
	// occur twice.
	public void doubleFirst() {

	}

	// this method will create a new node with the same value as the last node
	// and add this
	// new node at the end. Once finished, the last node will occur twice.
	public void doubleLast() {

	}

	// method skipEveryOther will remove every other node
	public void skipEveryOther() {

	}

	// this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value) {

	}

	// this method will remove every xth node in the list
	public void removeXthNode(int x) {

	}

	// this method will return a String containing the entire list
	public String toString() {
		String output = "";
		ListNode toCopy = theList;
		output += toCopy.getValue() + " ";
		toCopy = toCopy.getNext();
		while (toCopy.getNext() != head.getNext()) {
			output += toCopy.getValue() + " ";
			toCopy = toCopy.getNext();
		}

		return output;
	}

}