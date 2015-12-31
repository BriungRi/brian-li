package p18_16;

import java.util.ArrayList;

public class Fibonacci {
	ArrayList<Integer> values = new ArrayList<Integer>();
	
	public Fibonacci()
	{
		
	}
	
	public Fibonacci(int term)
	{
		values.add(1);
		values.add(1);
		calculate(term);
	}
	
	public int calculate(int term)
	{
		if(term == 0)
			return 1;
		if(term == 1)
			return 1;
		
		if(!exists(term - 1))
		{
			values.add(term - 1, calculate(term - 1));
		}
		return values.get(term - 1) + term;
	}
	
	public boolean exists(int value)
	{
		for(int count = 0; count < values.size(); count++)
		{
			if(values.get(count) == value)
				return true;
		}
		
		return false;
	}
}


