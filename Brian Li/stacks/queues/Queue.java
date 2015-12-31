package queues;

import java.util.LinkedList;

public class Queue implements MyQueue {

	private LinkedList<Object> l = new LinkedList<Object>();

	@Override
	public Object offer(Object item) {
		l.add(item);
		return item;
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return l.remove(0);
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return l.getFirst();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return l.size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return l.size();
	}

	@Override
	public int search(Object a) {
		// TODO Auto-generated method stub
		int count = 1;
		for (Object b : l) {
			if (b.equals(a))
				return count;
			count++;
		}
		return -1;
	}
	
	public String toString(){
		String s = "";
		for(Object o : l){
			s += o + " ";
		}
		return s;
	}

	public static void main(String[]args){
	
	Queue tc = new Queue ();

	System.out.println(tc.offer("quarter"));

	System.out.println(tc.offer("dime"));

	System.out.println(tc.offer("nickel"));

	System.out.println(tc.offer("penny"));

	System.out.println( "toString() " + tc);

	System.out.println( "peek() " + tc.peek());

	System.out.println( "search for dime " + tc.search("dime"));

	System.out.println( "search for euro " + tc.search("euro"));

	System.out.println( "Size " + tc.size());

	System.out.println("pop() and isEmpty()");

	while (!tc.isEmpty())

	System.out.println(tc.poll());

}}
