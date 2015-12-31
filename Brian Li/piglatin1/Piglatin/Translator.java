package Piglatin;

import java.util.ArrayList;

public class Translator 
{
	private ArrayList<String> phrase = new ArrayList<String>();
		
	public void translate(String english)
	{
		divider(english + " ");
	}
	
	private void divider(String english)
	{
		String word = "";
		for(int count = 0; count < english.length(); count++)
		{
			if(Character.isLetter(english.charAt(count)))
				word += Character.toString(english.charAt(count));
			else
			{
				this.phrase.add(word);
				word = "";
				phrase.add(Character.toString(english.charAt(count)));
			}
		}
		for(int count = 0; count < phrase.size(); count++)
		{
			if(Character.isLetter(phrase.get(count).charAt(0)))
				phrase.set(count, translatePhrase(phrase.get(count)));
		}
	}
	
	public void display()
	{
		System.out.println(phrase.toString());
	}
	
	private String translatePhrase(String english)
	{
		if(!containsVowel(english))
		{
			return upperFix(english + "ay");
		}
		else if(startsVowel(english))
		{
			return upperFix(english + "yay");
		}
		else
		{
			return upperFix(hasVowel(english));
		}
	}
	
	private boolean containsVowel(String word)
	{
		if(word.indexOf("a") >= 0 ||
				word.indexOf("e") >= 0 ||
				word.indexOf("i") >= 0 ||
				word.indexOf("o") >= 0 ||
				word.indexOf("u") >= 0 ||
				word.indexOf("A") >= 0 ||
				word.indexOf("E") >= 0 ||
				word.indexOf("I") >= 0 ||
				word.indexOf("O") >= 0 ||
				word.indexOf("U") >= 0)
			return true;
		else
			return false;
	}
	
	private boolean startsVowel(String word)
	{
		if(word.charAt(0) == 'a' ||
				word.charAt(0) == 'e' ||
				word.charAt(0) == 'i' ||
				word.charAt(0) == 'o' ||
				word.charAt(0) == 'u' ||
				word.charAt(0) == 'A' ||
				word.charAt(0) == 'E' ||
				word.charAt(0) == 'I' ||
				word.charAt(0) == 'O' ||
				word.charAt(0) == 'U')
			return true;
		else 
			return false;
	}
	
	private String hasVowel(String word)
	{
		String start = word.substring(0, indexOfVowel(word));
		String end = word.substring(indexOfVowel(word));
		return end + start + "ay";
	}
	
	private int indexOfVowel(String word)
	{
		int index = word.length() - 1;		
		if(word.indexOf("a") < index && word.indexOf("a") >= 0)
			index = word.indexOf("a");
		if(word.indexOf("e") < index && word.indexOf("e") >= 0)
			index = word.indexOf("e");
		if(word.indexOf("i") < index && word.indexOf("i") >= 0)
			index = word.indexOf("i");
		if(word.indexOf("o") < index && word.indexOf("o") >= 0)
			index = word.indexOf("o");
		if(word.indexOf("u") < index && word.indexOf("u") >= 0)
			index = word.indexOf("u");
		if(word.indexOf("A") < index && word.indexOf("A") >= 0)
			index = word.indexOf("A");
		if(word.indexOf("E") < index && word.indexOf("E") >= 0)
			index = word.indexOf("E");
		if(word.indexOf("I") < index && word.indexOf("E") >= 0)
			index = word.indexOf("I");
		if(word.indexOf("O") < index && word.indexOf("O") >= 0)
			index = word.indexOf("O");
		if(word.indexOf("U") < index && word.indexOf("U") >= 0)
			index = word.indexOf("U");
		return index;
	}
	
	private String upperFix(String piglatin)
	{
		if(containsUpper(piglatin))
		{
			for(int count = 0; count < piglatin.length(); count++)
			{
				if((int)piglatin.charAt(count) >= 65 && (int)piglatin.charAt(count) <= 90)
				{
					Character.toUpperCase(piglatin.charAt(0));
					Character.toLowerCase(piglatin.charAt(count));
				}
			}
		}
		return piglatin;
	}
	
	private boolean containsUpper(String piglatin)
	{
		for(int count = 0; count < piglatin.length(); count++)
		{
			if((int)piglatin.charAt(count) >= 65 && (int)piglatin.charAt(count) <= 90)
				return true;
		}
		return false;
	}
//	public String getPhrase()
//	{
//		return this.phrase;
//	}
}
