package general;

public class Hanoi 
{
	public static void main(String[]args){
		int numPegs 
		= 5;
		hanoi(numPegs, 
				"Peg 1", 
				"Peg 2", 
				"Peg 3");
		System.out.println
		("Number of Moves: "
				+ "" + 
				(int)
				(Math.pow(2, numPegs) - 1));
	}
	
	public static void hanoi(int n, 
			String start, String mid, String end) {
		if(n == 1)
			System.
			out.println(start + " -> " + end);
		else{
			hanoi
			(n - 
					1, start, end, mid); //moves everything but large
			System.out.
			println(start + " -> " + end); //moves the large to the last peg
			hanoi(n - 1, 
					mid, 
					start, 
					end); //moves the rest onto last peg
		}
	}
}
