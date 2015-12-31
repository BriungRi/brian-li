package p18_1_and_p18_3;

public class StringReverser
{
	public static void main(String[] args)
	{
	    String greeting = "Hello!";
	    System.out.println(reverseIteratively(greeting));
	}
	
	public static String reverse(String toReverse)
	{
		if(toReverse.length() == 0)
			return toReverse;
		
		String reverse = reverse(toReverse.substring(1));
		
		return reverse + toReverse.charAt(0);
	}
	
	public static String reverseIteratively(String toReverse)
	{
		String newString = "";
		for(int count = toReverse.length() - 1; count >= 0; count--)
		{
			newString += toReverse.charAt(count);
		}
		return newString;
	}
}