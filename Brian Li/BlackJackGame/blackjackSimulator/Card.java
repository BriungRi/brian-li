package blackjackSimulator;

public class Card 
{
	private int value;
	private String suit;
	
	/**
	 * Constructor of Card
	 * @param value the card's value
	 * @param suit the card's suit
	 */
	public Card(int value, String suit)
	{
		this.value = value;
		if(value >= 10)
			this.value = 10;
		if(value == 1)
			this.value = 11;

		
		this.suit = suit;
	}
	
	/**
	 * Gives value of card in terms of blackjack
	 * @return value of this Card
	 */
	public int getValue()
	{
		return this.value;
	}
	
	/**
	 * Gives suit of card 
	 * @return suit of this Card
	 */
	public String getSuit()
	{
		return this.suit;
	}
	
	/**
	 * Adjusts ace value accordingly
	 * @return if the value of the card was changed
	 */
	public boolean changeAceValue()
	{
		if(this.value == 11)
		{
			this.value = 1;
			return true;
		}
		return false;
	}

	/**
	 * This card in form of string
	 * @return Card in format SUIT VALUE in String
	 */
	public String toString()
	{
		return this.getSuit() + " " + this.getValue();
	}
}
