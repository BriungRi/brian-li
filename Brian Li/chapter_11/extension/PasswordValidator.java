package extension;

import validatedInput.Validator;

public class PasswordValidator implements Validator<String>
{
	private String password;
	
	public PasswordValidator(String pass)
	{
		this.password = "password"; //The password preset
	}
	
	public String prompt()
	{
		return "Enter password";
	}
	
	public String error()
	{
		return "Incorrect password. Please try again";
	}

	
	public boolean isValid(String text)
	{
		return text.equals(password);
	}
}
