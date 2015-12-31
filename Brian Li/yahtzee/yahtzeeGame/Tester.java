package yahtzeeGame;

public class Tester {

	public static void main(String[] args) {
		FiveDie g = new FiveDie();
		Dice a = new Dice(3);
		Dice b = new Dice(4);
		
		System.out.println("total sum " + g.sum(-1));
		System.out.println("sum of 1's " + g.sum(1));	
		System.out.println("sum of 2's " + g.sum(2));
		System.out.println("sum of 3's " + g.sum(3));
		System.out.println("sum of 4's " + g.sum(4));
		System.out.println("sum of 5's " + g.sum(5));
		System.out.println("sum of 6's " + g.sum(6));
		System.out.println("four of a kind " + g.tok());
		//g.reroll("2");
		System.out.println("three of a kind " + g.tok());
		System.out.println("Small straight " + g.SS());
		System.out.println("large Straight " + g.LS());
		System.out.println("Yahthzee " + g.Y());
		
	}
}
