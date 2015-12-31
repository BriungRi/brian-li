package characterMaker;

public class AA_174407 implements CharacterMaker {

	private String[] stringArray = {
			"__________|___  ___|    ||        ||        ||        ||                                            ",
			"|        ||        ||________||        ||        ||        |                                        ",
			" _______     | |       | |       | |       | |       | |    ___| |___                               ",
			" _______  /       \\ |         \\______          \\          |  ______/                                ",
			" ________ /        \\|        ||________/|         \\_________                                        " };

	// 0 is 'T', 1 is 'H', 2 is 'I', 3 is 'S', 4 is 'e'
	@Override
	/**
	 * Takes a character and turns it into ASCII
	 */
	public char[][] characterToAscii(char character) {
		if (characterSupported(character)) {
			char[][] ascii = new char[10][10];
			int count = 0;
			{
				for (int i = 0; i < ascii.length; i++) {
					for (int j = 0; j < ascii[i].length; j++) {
						ascii[i][j] = stringArray[selectionOfCharacter(character)]
								.charAt(count);
						count++;
					}
				}
			}
			return ascii;
		}
		return null;
	}

	@Override
	/**
	 * Determines which characters can be run
	 */
	public boolean characterSupported(char character) {
		char[] supported = supportedCharacters();
		for (int count = 0; count < supported.length; count++) {
			if (supported[count] == character)
				return true;
		}
		return false;
	}

	@Override
	/**
	 * List of supported Characters
	 */
	public char[] supportedCharacters() {
		char[] accepted = { 'T', 'H', 'I', 'S', 'e' };
		return accepted;
	}

	public int selectionOfCharacter(char c) {
		String allowed = "THISe";
		for (int count = 0; count < allowed.length(); count++) {
			if (allowed.charAt(count) == c) {
				return count;
			}
		}
		return -1;
	}

	/**
	 * Returns the char[] into a String
	 * 
	 * @param c
	 *            Which character to run
	 * @return the String
	 */
	public String toString(char c) {
		CharacterMaker convert = new AA_174407();
		char[][] asciiArray = convert.characterToAscii(c);

		String asciiLetter = "";

		for (int i = 0; i < asciiArray.length; i++) {
			for (int j = 0; j < asciiArray[i].length; j++) {
				asciiLetter += (asciiArray[i][j]);
			}
			asciiLetter += "\n";
		}
		return asciiLetter;
	}
}
