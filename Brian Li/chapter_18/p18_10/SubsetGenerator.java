package p18_10;

import java.util.ArrayList;

public class SubsetGenerator 
{
	public ArrayList<String> generate(String word)
	{
		ArrayList<String> words = new ArrayList<String>();
		
		words.add(word);
		
		if(word.length() < 1)
			return words;
		
		ArrayList<String> shorterList1 = generate(word.substring(1));

		for(int count = 0; count < shorterList1.size(); count++)
		{
			words.add(shorterList1.get(count));
		}
		
		return words;
	}
	
	public ArrayList<String> hackLetters(String word)
	{
		ArrayList<String> words = new ArrayList<String>();
		
		words.add(word);
		
		if(word.length() == 2)
		{
			words.add()
		
		
	}
}
