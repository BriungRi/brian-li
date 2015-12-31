package yahtzeeGame;
import java.util.ArrayList;

public class Yahtzee {

	private ArrayList<String> actions = new ArrayList<String>();
	private Player a, b;
	private int turnsLeft = 26;
	private int numRolls = 2;
	
	/**
	 * Constructor
	 * @param one first player
	 * @param two second player
	 */
	public Yahtzee(Player one, Player two)
	{
		a = one;
		b = two;
	}
	
	/**
	 * Gets turns left
	 * @return turnsLeft
	 */
	public int getTurnsLeft()
	{
		return turnsLeft;
	}
	
	/**
	 * Displays die
	 * @param p
	 * @return String of displayed die
	 */
	public String display(Player p)
	{
		return "  a b c d e\n>>" + p.showDice();
	}
	
	public boolean allowedAction(Player p, String s)
	{
		return p.allowedAction(s);
	}
	
	/**
	 * Rerolls 
	 * @param c player
	 * @param s string
	 */
	public void reroll(Player c, String s)
	{
		if(!s.contains("a") && !s.contains("b") && !s.contains("c") && !s.contains("d") && !s.contains("e"))
			numRolls = 0;
		
		else if(numRolls > 0)
		{
			c.reroll(s);
			numRolls--;
		}
	}
	
	/**
	 * Shows winner
	 * @return winner
	 */
	public String winner()
	{
		if(getTurnsLeft() == 0)
		{
			if(a.getScore() > b.getScore())
				return "Player one wins";
			else
				return "Player two wins";
		}
		return "Game not over yet";
	}
	
	/**
	 * Returns number of rolls
	 * @return numRolls
	 */
	public int getNumRerolls()
	{
		return numRolls;
	}
	
	/**
	 * Acts
	 * @param p player
	 * @param s action
	 */
	public void act(Player p, String s)
	{
		p.action(s);
		turnsLeft--;
		numRolls = 2;
	}
	
	
}
