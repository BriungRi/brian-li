package method;

import java.util.Stack;

public class StackMethods {

	public static double getAverage(Stack<Integer> one) {
		double sum = 0;
		int count = 0;
		for(Integer i : one){
			sum += i;
			count++;
		}
		return sum / count;
	}
	
	private static Stack<String> reverse(Stack<String> s){
		Stack<String> temp = new Stack<String>();
		while(!s.isEmpty()){
			temp.push(s.pop());
		}
		return temp;
	}

	public static Stack<String> alternateStack(Stack<String> one,
			Stack<String> two) {
		one = reverse(one);
		two = reverse(two);
		Stack<String> a = new Stack<String>();
		while(!one.isEmpty() && !two.isEmpty()){
			a.push(one.pop());
			a.push(two.pop());
		}
		if(one.isEmpty()){
			while(!two.isEmpty()){
				a.push(two.pop());
			}
		}
		else{
			while(!one.isEmpty()){
				a.push(one.pop());
			}
		}
		
		return a;
	}

	// Good Question: For alternating stacks, are they the same size??…Do they
	// have to be???

	public static Stack<String> removeEveryOther(Stack<String> one) {
		int count = 0;
		Stack<String> a = new Stack<String>();
		for(String s : one){
			if(count % 2 == 0){
				a.push(s);
			}
			count++;
		}
		return a;
	}

	// Removes every other element in the stack – but the order of others
	// shouldn’t change.

	public static void display(Stack<String> one) {
		for(String s : one){
			System.out.println(s + " ");
		}
	}

	// We want to print in the order that it comes off the stack

	public static void main(String[] args) {

		Stack<Integer> a = new Stack<Integer>();

		a.push(5);

		a.push(2);

		a.push(7);
		
		System.out.println(getAverage(a) + "\n"); // 4.667

		Stack<String> b = new Stack<String>();

		b.push("one");

		b.push("two");

		Stack<String> c = new Stack<String>();

		c.push("three");

		c.push("four");

		c.push("five");

		display(alternateStack(b, c));

		System.out.println();

		Stack<String> d = new Stack<String>();

		d.push("six");

		d.push("seven");

		d.push("eight");

		d.push("nine");

		d.push("ten");

		display(removeEveryOther(d));

	}
}