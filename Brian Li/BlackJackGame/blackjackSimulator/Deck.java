package blackjackSimulator;

import java.util.ArrayList;

public class Deck 
{
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck()
	{
		for(int i = 0; i < 13; i++)
		{
			deck.add(new Card(i, "DIAMONDS"));
		}
		for(int i = 0; i < 13; i++)
		{
			deck.add(new Card(i, "HEARTS"));
		}
		for(int i = 0; i < 13; i++)
		{
			deck.add(new Card(i, "JACKS"));
		}
		for(int i = 0; i < 13; i++)
		{
			deck.add(new Card(i, "SPADES"));
		}
	}
	
}
