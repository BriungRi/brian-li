//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class PQRunner
{
	public static void main ( String[] args )
	{
		YourPQ test = new YourPQ();

		Scanner keyboard=new Scanner(System.in);
		
		String s = "111222123321213231312333";
		int count = 0;
		while(count < s.length()){
			int h = Integer.parseInt(s.substring(count, count + 1));
			int w = Integer.parseInt(s.substring(count + 1, count + 2));
			int a = Integer.parseInt(s.substring(count + 2, count + 3));
			test.add(new Monster(h, w, a));
			count += 3;
		}

		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());
		
		System.out.println(test);
		
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());
		
		System.out.println(test);
		
		
		//add more test cases
		
			
	}
}