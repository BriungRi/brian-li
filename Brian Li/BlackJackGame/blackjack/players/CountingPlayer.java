package blackjack.players;

import java.util.List;

import blackjack.Card;
import blackjack.PlayerAction;
import blackjack.Value;

public class CountingPlayer extends SmartPlayer {
	private int count;

	public double bet(double minBet, double maxBet) {
		double midBet = (minBet + maxBet) / 2;
		if (count < 0)
			return minBet;
		else if (count > 30)
			return maxBet;
		else
			return minBet;
	}

	public PlayerAction act(List<Card> ownHand, Card dealerUpCard,
			List<PlayerAction> allowedActions) {
		if (count > 10)
			countHigh();
		else if (count < -10)
			countLow();
		else
			countNorm();

		return super.act(ownHand, dealerUpCard, allowedActions);
	}

	public boolean insureHand(List<Card> ownHand, Card dealerUpCard) {
			return dealerUpCard.value().equals(Value.ACE) && count > 60;
//		return false;
	}

	public void faceUpCard(Card card) {
		if (card.value().equals(Value.ACE))
			count -= 0;
		switch (card.value().numericValue()) {
		case 2:
			count += 2;
			break;
		case 3:
			count += 3;
			break;
		case 4:
			count += 3;
			break;
		case 5:
			count += 4;
			break;
		case 6:
			count += 2;
			break;
		case 7:
			count += 1;
			break;
		case 8:
			count += 0;
			break;
		case 9:
			count -= 2;
			break;
		case 10:
			count -= 3;
			break;
		}

	}

	public void shuffle() {
		count = 0;

	}
}
