package blackjackSimulator;

import java.util.ArrayList;

public class Shoe {
	private ArrayList<Card> shoe = new ArrayList<Card>();

	/**
	 * Constructs a shoe that has 4 decks of 52 cards each containing Cards valued 1-13 with 4 suits
	 */
	public Shoe() {
		for (int count = 0; count < 4; count++) {
			for (int i = 1; i < 14; i++) {
				shoe.add(new Card(i, "DIAMONDS"));
			}
			for (int i = 1; i < 14; i++) {
				shoe.add(new Card(i, "HEARTS"));
			}
			for (int i = 1; i < 14; i++) {
				shoe.add(new Card(i, "CLUBS"));
			}
			for (int i = 1; i < 14; i++) {
				shoe.add(new Card(i, "SPADES"));
			}
		}
		shuffle();
	}
	
	/**
	 * Draws a card from the deck
	 * @return The card drawn from top of deck
	 */
	public Card draw()
	{
		return shoe.remove(shoe.size() - 1);
	}
	
	/**
	 * The shoe's size;
	 * @return The current size of the shoe 
	 */
	public int shoeSize()
	{
		return shoe.size();
	}
	
	/**
	 * Scrambles order of cards in shoe
	 */
	public void shuffle()
	{
		for(int i = 0; i < shoe.size(); i++)
		{
			int tempIndex = (int)(Math.random() * shoe.size());
			Card temp = shoe.get(tempIndex);
			shoe.set(tempIndex, shoe.get(i));
			shoe.set(i, temp);
		}
	}
}
