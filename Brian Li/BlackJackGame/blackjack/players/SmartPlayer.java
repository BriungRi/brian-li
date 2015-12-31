package blackjack.players;

import java.util.List;

import blackjack.BlackjackPlayer;
import blackjack.Card;
import blackjack.HandUtilities;
import blackjack.PlayerAction;
import blackjack.Result;
import blackjack.Value;

public class SmartPlayer implements BlackjackPlayer {
	private String[][] hardSet = {
			{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
			{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
			{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
			{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
			{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
			{ "H", "H", "Dh", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
			{ "H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "H" },
			{ "H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh" },
			{ "H", "H", "H", "S", "S", "S", "H", "H", "H", "H" },
			{ "H", "S", "S", "S", "S", "S", "H", "H", "H", "H" },
			{ "H", "S", "S", "S", "S", "S", "H", "H", "H", "H" },
			{ "H", "S", "S", "S", "S", "S", "H", "H", "H", "Rh" },
			{ "Rh", "S", "S", "S", "S", "S", "H", "H", "Rh", "Rh" },
			{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
			{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
			{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
			{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" } };

	private String[][] softSet = {
			{ "H", "H", "H", "H", "Dh", "Dh", "H", "H", "H", "H" },
			{ "H", "H", "H", "H", "Dh", "Dh", "H", "H", "H", "H" },
			{ "H", "H", "H", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
			{ "H", "H", "H", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
			{ "H", "H", "Dh", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
			{ "H", "S", "Ds", "Ds", "Ds", "Ds", "S", "S", "H", "H" },
			{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
			{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" } };

	private String[][] splitSet = {
			{ "P", "P", "P", "P", "P", "P", "P", "P", "P", "P" },
			{ "H", "Ph", "Ph", "P", "P", "P", "P", "H", "H", "H" },
			{ "H", "Ph", "Ph", "P", "P", "P", "P", "H", "H", "H" },
			{ "H", "H", "H", "H", "Ph", "Ph", "H", "H", "H", "H" },
			{ "H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "H" },
			{ "H", "Ph", "P", "P", "P", "P", "H", "H", "H", "H" },
			{ "H", "P", "P", "P", "P", "P", "P", "H", "H", "H" },
			{ "P", "P", "P", "P", "P", "P", "P", "P", "P", "P" },
			{ "S", "P", "P", "P", "P", "P", "S", "P", "P", "S" },
			{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" } };

	@Override
	public String id() {
		return "Brian Li Basic Stratagy";
	}

	@Override
	public double bet(double minBet, double maxBet) {
		return minBet;
	}

	@Override
	public PlayerAction act(List<Card> ownHand, Card dealerUpCard,
			List<PlayerAction> allowedActions) {
		String action = "";

		int sum = HandUtilities.value(ownHand);

		int dealerCardIndex = dealerUpCard.value().numericValue() - 1;

		boolean canSplit = ownHand.get(0).value()
				.equals(ownHand.get(1).value())
				&& ownHand.size() == 2
				&& allowedActions.contains(PlayerAction.SPLIT);

		if (canSplit) {
			int index;
			if (ownHand.get(0).value().equals(Value.ACE))
				index = 0;
			else
				index = ownHand.get(0).value().numericValue() - 1;
			action += splitSet[index][dealerCardIndex];
		} else if (HandUtilities.soft(ownHand)) {
			action += softSet[sum - 13][dealerCardIndex];
		} else {
			action += hardSet[sum - 4][dealerCardIndex];
		}

		if (action.substring(0, 1).equals("D")) {
			if (allowedActions.contains(PlayerAction.DOUBLE))
				return PlayerAction.DOUBLE;
			else
				action = action.substring(1);
		}

		if (action.substring(0, 1).equals("R")) {
			if (allowedActions.contains(PlayerAction.SURRENDER))
				return PlayerAction.SURRENDER;
			else
				action = action.substring(1);
		}

		if (action.substring(0, 1).equals("P")
				&& allowedActions.contains(PlayerAction.SPLIT))
			return PlayerAction.SPLIT;
		else if (action.substring(0, 1).equals("P")
				&& !allowedActions.contains(PlayerAction.SPLIT)) {
			if (action.length() == 1)
				action = hardSet[sum - 4][dealerCardIndex];
			else
				action = action.substring(1);
		}

		if (action.equalsIgnoreCase("H"))
			return PlayerAction.HIT;
		else
			return PlayerAction.STAND;

	}
	
	public void countHigh()
	{
//		hardSet[5] = hardSet[7];
//		hardSet[6] = hardSet[7];
	}
	
	public void countNorm()
	{
		String[][] newHard = {
				{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
				{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
				{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
				{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
				{ "H", "H", "H", "H", "H", "H", "H", "H", "H", "H" },
				{ "H", "H", "Dh", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
				{ "H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "H" },
				{ "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh" },
				{ "H", "H", "H", "S", "S", "S", "H", "H", "H", "H" },
				{ "H", "S", "S", "S", "S", "S", "H", "H", "H", "H" },
				{ "H", "S", "S", "S", "S", "S", "H", "H", "H", "H" },
				{ "H", "S", "S", "S", "S", "S", "H", "H", "H", "Rh" },
				{ "Rh", "S", "S", "S", "S", "S", "H", "H", "Rh", "Rh" },
				{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
				{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
				{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
				{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" } };
		String[][] newSoft = {
				{ "H", "H", "H", "H", "Dh", "Dh", "H", "H", "H", "H" },
				{ "H", "H", "H", "H", "Dh", "Dh", "H", "H", "H", "H" },
				{ "H", "H", "H", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
				{ "H", "H", "H", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
				{ "H", "H", "Dh", "Dh", "Dh", "Dh", "H", "H", "H", "H" },
				{ "H", "S", "Ds", "Ds", "Ds", "Ds", "S", "S", "H", "H" },
				{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" },
				{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" } };
		String[][] newSplit = {
				{ "P", "P", "P", "P", "P", "P", "P", "P", "P", "P" },
				{ "H", "Ph", "Ph", "P", "P", "P", "P", "H", "H", "H" },
				{ "H", "Ph", "Ph", "P", "P", "P", "P", "H", "H", "H" },
				{ "H", "H", "H", "H", "Ph", "Ph", "H", "H", "H", "H" },
				{ "H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "H" },
				{ "H", "Ph", "P", "P", "P", "P", "H", "H", "H", "H" },
				{ "H", "P", "P", "P", "P", "P", "P", "H", "H", "H" },
				{ "P", "P", "P", "P", "P", "P", "P", "P", "P", "P" },
				{ "S", "P", "P", "P", "P", "P", "S", "P", "P", "S" },
				{ "S", "S", "S", "S", "S", "S", "S", "S", "S", "S" } };
		hardSet = newHard;
		softSet = newSoft;
		splitSet = newSplit;
	}
	
	public void countLow()
	{
		hardSet[8] = hardSet[0];
		hardSet[9] = hardSet[0];

	}

	@Override
	public boolean insureHand(List<Card> ownHand, Card dealerUpCard) {
		return false;
	}

	@Override
	public void playerIDs(List<String> playerIDs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialBet(int playerIndex, double bet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialBets(List<Double> bets) {
		// TODO Auto-generated method stub

	}

	@Override
	public void faceUpCard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insuranceDecision(int playerIndex, List<Card> playersHand,
			Card dealersUpCard, boolean insuredHand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insuranceResult(int playerIndex, double bet,
			List<Card> playersHand, Card dealersUpCard, boolean insuranceBetWon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decision(int playerIndex, List<Card> playersHand,
			Card dealersUpCard, List<PlayerAction> allowedActions,
			PlayerAction action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void result(int playerIndex, double bet, List<Card> playersHand,
			List<Card> dealersHand, Result result) {
		// TODO Auto-generated method stub

	}

}
