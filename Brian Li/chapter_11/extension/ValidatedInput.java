package extension;

import java.util.Scanner;

import validatedInput.Validator;

public class ValidatedInput 
{
	private Scanner scan = new Scanner(System.in);
	
	private boolean getInput(Validator validator)
	{
		String validInput = null;
		int retries = 3;
		while(validInput == null && retries >= 0)
		{
			System.out.println(validator.prompt());
			String input = scan.nextLine();
			if(validator.isValid(input))
			{
				return true;
			}
			else
			{
				System.out.println(validator.error());
				System.out.println("Retries left: " + retries);
				retries--;
			}
		}
		return false;
	}
	
	public boolean getInput()
	{
		return getInput(new PasswordValidator(""));
	}
	
	
}
