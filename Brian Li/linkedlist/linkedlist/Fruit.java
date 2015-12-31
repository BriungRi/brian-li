package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class Fruit {
	LinkedList<String> bowl;

	public Fruit() {
		bowl = new LinkedList<String>();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		System.out.println(bowl);
	}

	public String displayEveryOther() {
		String s = "";
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			s += iter.next() + "\n";
			if (iter.hasNext())
				iter.next();
		}
		return s;
	}

	public String reverse() {
		String s = "";
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}
		while (iter.hasPrevious()) {
			s += iter.previous() + " ";
		}
		return s;
	}

	public void duplicate() {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
			iter.add(iter.previous());
			iter.next();
		}
		System.out.println(bowl);
	}

	public void repeat() {
		String s = "";
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			s += iter.next() + " ";
		}
		s += s;
		System.out.println(s);
	}

	public void delete(String searchFor) {
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			if(iter.next().equals(searchFor)){
				iter.remove();
			}
		}
		System.out.println(bowl);
	}
	
	public void insert(String toAdd) {
		boolean added = false;;
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			if(toAdd.compareTo(iter.next()) < 0){
				iter.previous();
				iter.add(toAdd);
				iter.next();
				added = true;
			}
		}
		if(!added){
			bowl.addLast(toAdd);
		}
		System.out.println(bowl);
	}

}
