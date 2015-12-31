package stakz;

import java.util.Iterator;
import java.util.Stack;
public class CDStack {
	Stack <String> myStack;
	
	public CDStack(){
		myStack = new Stack<String>();
		myStack.push("Journey");
		myStack.push("Iagy PoP");
		myStack.push("Hall & Oats");
		myStack.push("Genesis");
		myStack.push("Foreigner");
		myStack.push("Eagles");
		myStack.push("Deep Purple");
		myStack.push("Cheap Trick");
		myStack.push("Beatles");
		myStack.push("Aerosmith");
	}
	
	public String nextCD(){
		return myStack.peek();
	}
	
	public String playNextCD(){
		return myStack.pop();
	}
	
	public void printCD(){
//		while(!myStack.empty()){
//			System.out.println(myStack.pop() + " ");
//		} //1
		
		Iterator<String> i = myStack.iterator();
//		while(i.hasNext()){
//			System.out.println(i.next());
//		} // 2
		
//		for(String s : myStack){
//			System.out.println(s);
//		} //3
		
		
	}
	
	public void toBinary(int num){
		Stack<String> s = new Stack<String>();
		while(num != 0){
			s.push("" + num % 2);
			num /= 2;
		}
		
		while(!s.empty()){
			System.out.println(s.pop() + " ");
		}
	}
	
	public void reverse(){
		Stack<String> n = new Stack<String>();
		while(!myStack.empty())
			n.push(myStack.pop());
		myStack = n;
	}
	
	public void printCDRecursive(){
		if(myStack.empty()){
			return;
		}
		System.out.println(myStack.pop() + " ");
		printCDRecursive();
	}
}
