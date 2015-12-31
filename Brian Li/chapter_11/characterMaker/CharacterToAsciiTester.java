package characterMaker;

public class CharacterToAsciiTester {

	public static void main(String[] args) {
		AA_174407 convert = new AA_174407();

		String test = "THISe";

		for (int count = 0; count < test.length(); count++) {
			System.out.println(convert.toString(test.charAt(count)));
		}
	}
}
