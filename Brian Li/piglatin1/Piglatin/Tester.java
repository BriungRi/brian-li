package Piglatin;

public class Tester 
{
	public static void main(String[]args)
	{
		Translator rosetta = new Translator();
		
		rosetta.translate("I am: Brian Li");
		rosetta.display();
	}
}
