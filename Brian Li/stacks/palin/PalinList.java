package palin;

// PalinLins.java

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class PalinList
{
	private Queue<String> queue = new LinkedList<String>();
	private Stack<String> stack = new Stack<String>();
	String palindrome = "";

	public PalinList(String list)
	{
		setList(list);
	}

	public void setList(String list)
	{
		Scanner input = new Scanner(list);
		while(input.hasNext()){
			String temp = input.next() + " ";
			palindrome += temp;
			queue.add(temp);
			stack.add(temp);
		}
	}

	public boolean isPalin()
	{
		String forw = "";
		String back = "";
		
		while(!queue.isEmpty()){
			forw += queue.poll();
		}
		while(!stack.isEmpty()){
			back += stack.pop();
		}
		
		return forw.equals(back);
	}


	public String toString(){
		String s = palindrome + ":";
		palindrome = "";
		return s;
	}
}