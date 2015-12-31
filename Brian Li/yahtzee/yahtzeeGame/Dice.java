package yahtzeeGame;

/**
 * Dice properties
 * @author 165374
 *
 */
public class Dice {
	
	private int value;
	
	/**
	 * Constructor
	 */
	public Dice()
	{
		reroll();
	} 
	
	public Dice(int i)
	{
		value = i;
	}
	
	/**
	 * Gets value of dice
	 * @return value
	 */
	public int getValue()
	{
		return this.value;
	}
	
	/**
	 * Rerolls dice
	 */
	public void reroll()
	{
		this.value = (int)(Math.random() * 6) + 1;
	}
	
	/**
	 * Returns string of dice
	 * @return string
	 */
	public String toString()
	{
		return "" + this.value;
	}	
}
