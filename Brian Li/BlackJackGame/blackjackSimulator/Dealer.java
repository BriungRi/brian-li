package blackjackSimulator;

public class Dealer extends Player{
	
	/**
	 * Shows only one card of the dealer
	 * @return Card of dealer in form of String
	 */
	public String showCards()
	{
		return "Dealer has: " + getCard(0).toString();
	}
	
	/**
	 * Reveals rest of dealer's cards
	 * @return Cards of dealer in form of String
	 */
	public String endTurn()
	{
		return "Dealer has: " + super.showCards().substring(12);
	}

}
