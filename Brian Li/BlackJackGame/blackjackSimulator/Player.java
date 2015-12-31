package blackjackSimulator;

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> cards = new ArrayList<Card>();
	private int balance = 1000, bettingAmt;

	/**
	 * Gives player another card
	 * @param toAdd the card drawn from the shoe
	 */
	public void hit(Card toAdd) {
		cards.add(toAdd);
	}

	/**
	 * Sums the cards and handles aces
	 * @return sum of cards
	 */
	public int sumCards() {
		int sum = 0;

		for (int i = 0; i < cards.size(); i++) {
			sum += cards.get(i).getValue();
		}
		
		if(sum > 21)
		{
			int i = 0;
			while(sum > 21 && i < cards.size())
			{
				if(cards.get(i).changeAceValue())
					sum -= 10;
				i++;
			}

		}
		return sum;

	}

	/**
	 * Checks for blackjack
	 * @return if Player has blackjack
	 */
	public boolean blackjack() {
		return sumCards() == 11
				&& (cards.get(0).getValue() == 1 || cards.get(1).getValue() == 1);
	}

	/**
	 * Cards in form of String
	 * @return Cards player is holding
	 */
	public String showCards()
	{
		String output = "Player has: ";
		for(int i = 0; i < cards.size(); i++)
		{
			output += cards.get(i).toString() + " ";
		}
		return output;
	}
	
	/**
	 * Gives current balance
	 * @return Current balance in form of String
	 */
	public String getBalance()
	{
		return "Balance: " + this.balance;
	}
	
	/**
	 * Assigns bet amount
	 * @param bet Amount player wants to bet
	 */
	public void bet(int bet)
	{
		balance -= bet;
		bettingAmt = bet;
	}
	
	/**
	 * Handles if player won/pushed
	 * @param win if player won
	 * @param push if game was a push
	 */
	public void endTurn(boolean win, boolean push)
	{
		if(win && !blackjack())
			balance += bettingAmt * 2;
		else if(win && blackjack())
			balance += bettingAmt + bettingAmt * 1.5;
		else if(!win && push)
			balance += bettingAmt;
		
	}
	
	/**
	 * Only shows first card
	 * @return first card of Player
	 */
	public String showFirst()
	{
		return cards.get(0).toString();
	}
	
	/**
	 * Discards current cards and recieves new cards
	 * @param one First card of Player
	 * @param two Second card of Player
	 */
	public void newHand(Card one, Card two)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(one);
		cards.add(two);
		this.cards = cards;
	}
	
	/**
	 * Checks to see if player is busted
	 * @return if player can keep getting cards
	 */
	public boolean canHit()
	{
		return sumCards() < 21;
	}
	
	/**
	 * Returns a card 
	 * @param i index of card wanted
	 * @return Card at index i
	 */
	public Card getCard(int i)
	{
		return cards.get(i);
	}
}
