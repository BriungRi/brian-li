package yahtzeeGame;

import java.util.ArrayList;

public class Player 
{
	private int score;
	private FiveDie d = new FiveDie();
	private Scorecard s = new Scorecard();
	private String name;
	
	/**
	 * Constructor
	 * @param n name
	 */
	public Player(String n)
	{
		name = n;
	}
	
	/**
	 * Acts and rerolls die
	 * @param action
	 */
	public void action(String action)
	{
		score += s.act(action, d);
		d.reroll("01234");
	}
	
	/**
	 * Gets name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	//should it be boolean or should we make another method, one to check, one for summing, and
	//in which class - can we incorporate creating this method into scorecard instead?
	//also act removes the action, so we have to check it at end of game...
//	public void bonus(){
//		int upperScore = s.act("ACES", d) + s.act("TWOS", d) + s.act("THREES", d) + 
//				s.act("FOURS", d) + s.act("FIVES", d) + s.act("SIXES", d);
//		if(upperScore > 63)
//			score += 35;
//	}
	
	/**
	 * Gets score
	 * @return score
	 */
	public int getScore()
	{
		return this.score;
	}
	
	/**
	 * Shows dice
	 * @return string of die
	 */
	public String showDice()
	{
		return d.toString();
	}
	
	/**
	 * Rerolls certain die
	 * @param s die to reroll
	 */
	public void reroll(String s)
	{
		d.reroll(s);
	}
	
	public boolean allowedAction(String a)
	{
		return s.contains(a);
	}
	
	/**
	 * Shows title/actions 
	 * @return title/actions
	 */
	public String showActions()
	{
		return this.getName() + "'s " + s.toString();
	}
}
