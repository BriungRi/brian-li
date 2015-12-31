package yahtzeeGame;

import java.util.ArrayList;

public class FiveDie {
	private ArrayList<Dice> five = new ArrayList<Dice>();

	public FiveDie() {
		for (int i = 0; i < 5; i++)
			five.add(new Dice());
	}

	/**
	 * s numbers to reroll
	 * 
	 * @param s
	 */
	public void reroll(String s) {
		if (!s.contains("a"))
			five.get(0).reroll();
		if (!s.contains("b"))
			five.get(1).reroll();
		if (!s.contains("c"))
			five.get(2).reroll();
		if (!s.contains("d"))
			five.get(3).reroll();
		if (!s.contains("e"))
			five.get(4).reroll();
	}

	public Dice get(int index) {
		return five.get(index);
	}

	/**
	 * return total sum when i < 0
	 *
	 * @param i
	 * @return
	 */
	public int sum(int i) {
		int sum = 0;
		for (Dice d : five) {
			if (i > 0 && d.getValue() == i)
				sum += d.getValue();
			else if (i <= 0)
				sum += d.getValue();
		}
		return sum;
	}

	/**
	 * Checks if there is 3 of a number, and 2 of another number
	 * 
	 * @return
	 */
	public boolean fullHouse() {
		// boolean flag = true;
		//
		// if(tok()){
		// int tok = tokNum(), i = 1;
		// if(tok == i) i = 2;
		// while( (i > 0 && i < tok) || (i > tok && i <= 6) ){
		// flag = sum(i) != i * 2;
		// i++;
		// }
		// return !flag;
		// }
		// return false;

		return this.tok() && this.twoOfAKind();
	}

	private boolean twoOfAKind() {
		boolean flag = true;
		int i = 1;
		while (i <= 6 && flag) {
			flag = sum(i) != i * 2;
			i++;
		}
		return !flag;
	}

	public boolean tok() {
		boolean flag = true;
		int i = 1;
		while (i <= 6 && flag) {
			flag = sum(i) != i * 3;
			i++;
		}
		return !flag;
	}

	// will return 6 if there is no 3 of a number
//	private int tokNum() {
//		boolean flag = true;
//		int i = 1;
//		while (i <= 6 && flag) {
//			flag = sum(i) != i * 3;
//			i++;
//		}
//		return i;
//	}

	public boolean fok() {
		boolean flag = true;
		int i = 1;
		while (i <= 6 && flag) {
			flag = sum(i) != i * 4;
			i++;
		}
		return !flag;
	}

	public boolean SS() {
		return (contains(new Dice(1)) && contains(new Dice(2))
				&& contains(new Dice(3)) && contains(new Dice(4)))
				|| (contains(new Dice(2)) && contains(new Dice(3))
						&& contains(new Dice(4)) && contains(new Dice(5)))
				|| (contains(new Dice(3)) && contains(new Dice(4))
						&& contains(new Dice(5)) && contains(new Dice(6)));
	}

	public boolean LS() {
		return (contains(new Dice(1)) && contains(new Dice(2))
				&& contains(new Dice(3)) && contains(new Dice(4)) && contains(new Dice(5)))
				|| (contains(new Dice(2)) && contains(new Dice(3))
						&& contains(new Dice(4))
						&& contains(new Dice(5)) && contains(new Dice(6)));
	}

	public boolean Y() {
		boolean flag = true;
		int i = 1;
		while (i <= 6 && flag) {
			flag = sum(i) != i * 5;
			i++;
		}
		return !flag;
	}

	public String toString() {
		String output = "";
		for (Dice d : five)
			output += d + " ";
		return output;

	}
	
	private boolean contains(Dice d) {
		boolean flag = false;
		for (Dice dice : five)
		{
			if (dice.getValue() == d.getValue())
				flag = true;
		}
		return flag;
			
	}
}
