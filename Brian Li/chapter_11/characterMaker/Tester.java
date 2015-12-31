package characterMaker;

public class Tester 
{
	public static void main(String[] args)
	{
		CharacterMaker convert = new AA_174407();
		String lettersToWrite = "";
		for(int count = 0; count < args.length; count++)
			lettersToWrite += args[count];
		String output = "";
		for(int i = 0; i < 10; i++) //First line of ASCII
		{
			for(int j = 0; j < lettersToWrite.length(); j++) //Which letter is being run
			{
				for(int k = 0; k < 10; k++)  //the 10 letters for the letter
				{
					char[][] temp = convert.characterToAscii(lettersToWrite.charAt(j));
					output += temp[i][k];					
				}
				output += "  "; //spaces between letters
			}
			output += "\n";
		}
		System.out.println(output);
	}
}	
