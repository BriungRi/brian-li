package PiglatinConverter;

import java.util.Scanner;
public class PiglatinTester 
{
	public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("I can translate English sentences and phrases into Pig Latin. "
				+ "\nPlease type an English sentence or phrase and then press <Enter>.");
		translateThis(input.nextLine());
		boolean done = false;
		while(!done)
		{
			System.out.println("Would you like to translate another phrase?");
			if(input.next().equals("n"))
				done = true;
			else
				System.out.println("Please type an English sentence or phrase and then press <Enter>.");
			translateThis(input.nextLine());
		}
	}
	public static void translateThis(String sentence)
	{
		Translator newTranslator = new Translator();
		newTranslator.translate(sentence);
		System.out.println(">" + newTranslator.getPhrase());
	}
}
