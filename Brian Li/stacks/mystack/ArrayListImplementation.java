package mystack;

import java.util.ArrayList;

public class ArrayListImplementation implements MyStack{
	private ArrayList<Object> a = new ArrayList<Object>();
	
	@Override
	public Object push(Object item) {
		a.add(0, item);
		return item;
	}

	@Override
	public Object pop() {
		return a.remove(0);
	}

	@Override
	public Object peek() {
		return a.get(0);
	}

	@Override
	public boolean isEmpty() {
		return a.size() == 0;
	}

	@Override
	public int size() {
		return a.size();
	}

	@Override
	public int search(Object item) {
		if(a.indexOf(item) == -1)
			return -1;
		else
			return a.indexOf(item) + 1;
	}
	
	public String toString(){
		return a.toString();
	}

}
