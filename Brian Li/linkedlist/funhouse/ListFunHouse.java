package funhouse;

import static java.lang.System.*;

import java.util.ArrayList;

public class ListFunHouse {
	// this method will print the entire list on the screen
	public static void print(ListNode list) {
		while (list != null) {
			System.out.print(list.getValue());
			if (list.getNext() != null)
				System.out.print(", ");
			list = list.getNext();
		}
	}

	// this method will return the number of nodes present in list
	public static int nodeCount(ListNode list) {
		int count = 0;
		while (list != null) {
			count++;
			list = list.getNext();
		}
		return count;
	}

	// this method will create a new node with the same value as the first node
	// and add this
	// new node to the list. Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list) {
		list.setNext(new ListNode(list.getValue(), list.getNext()));
	}

	// this method will create a new node with the same value as the last node
	// and add this
	// new node at the end. Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list) {
		while (list.getNext() != null) {
			list = list.getNext();
		}
		list.setNext(new ListNode(list.getValue(), null));
	}

	// method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list) {
		removeXthNode(list, 2);
	}

	// this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value) {
		ListNode t = new ListNode(list.getValue(), list.getNext());
		int count = nodeCount(list);
		for (int i = 0; i < count / x; i += x) {
			list.setNext(new ListNode(value, list.getNext().getNext()));
		}
	}

	// this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x) {
		ListNode t = new ListNode(list.getValue(), list.getNext());
		for (int i = 0; i < nodeCount(list); i++) {
			if (i == x * (nodeCount(list) - 1) / x) {
				list.setValue(t.getValue());
				list.setNext(null);
			} else if (i % x == 0) {
				list.setValue(t.getValue());
				list = list.getNext();
			}
			t = t.getNext();
		}
	}

}