package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class Students {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("K");
		list.add("V");
		list.add("A");
		list.add("V");
		list.add("J");
		list.add("P");
		list.add("D");
		list.add("T");
		
		System.out.println(list);
		
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()){
			iter.next();
		}
		while(iter.hasPrevious()){
			System.out.println(iter.previous());
		}
		
	}
}
