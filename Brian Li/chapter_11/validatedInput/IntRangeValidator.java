package validatedInput;

public class IntRangeValidator implements Validator<Integer>
{
	private int max, min;
	
	public IntRangeValidator(int min, int max)
	{
		this.min = min;
		this.max = max;
	}
	
	public String prompt()
	{
		return "Enter a valid integer between " + min + "and" + max;
	}
	
	public String error()
	{
		return "Not a valid integer between " + min + "and" + max;
	}
	
	public boolean isValid(String input)
	{
		if((new AnyIntegerValidator().isValid(input)))
		{
			int validInput = Integer.parseInt(input);
			return min <= validInput && validInput <= max;
		}
		return false;
	}
}
