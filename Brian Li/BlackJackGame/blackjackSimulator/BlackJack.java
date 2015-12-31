package blackjackSimulator;

import java.util.Scanner;

public class BlackJack {

	final private boolean PUSH = true;

	/**
	 * logic sequence of the game of BlackJack
	 * 
	 * @param p
	 *            Current player
	 * @param d
	 *            Current dealer
	 * @param shoe
	 *            Current shoe being used
	 */
	public BlackJack(Player p, Player d, Shoe shoe, boolean hit) {

		if (d.blackjack()) {
			if (p.blackjack()) {
				push(p, d);
			} else {
				playerLose(p, d);
			}

		}

		while (p.sumCards() < 21 && hit) {
			Scanner input = new Scanner(System.in);
			if (hit)
				p.hit(shoe.draw());
			System.out.println(p.showCards());
			if (p.canHit()) {
				System.out.println("h to hit again");
				hit = input.next().equals("h");
			}
			else
				hit = false;
		}

		if (p.sumCards() == 21) {
			if (d.sumCards() == 21) {
				push(p, d);
			} else {
				playerWin(p, d);
			}
		}

		if (p.sumCards() > 21)
			playerLose(p, d);

		while (d.sumCards() < 17)
			d.hit(shoe.draw());

		if (d.sumCards() > 21)
			playerWin(p, d);

		if (d.sumCards() > p.sumCards())
			playerLose(p, d);

		else
			playerWin(p, d);
	}

	/**
	 * Code when player wins
	 * 
	 * @param player
	 *            Player of current game
	 * @param dealer
	 *            Dealer of current game
	 */
	public void playerWin(Player player, Player dealer) {
		player.endTurn(true, !PUSH);
		dealer.endTurn(false, !PUSH);
	}

	/**
	 * Code when player loses
	 * 
	 * @param player
	 *            Player of current game
	 * @param dealer
	 *            Dealer of current game
	 */
	public void playerLose(Player player, Player dealer) {
		player.endTurn(false, !PUSH);
		dealer.endTurn(true, !PUSH);
	}

	/**
	 * Code when push
	 * 
	 * @param player
	 *            Player of current game
	 * @param dealer
	 *            Dealer of current game
	 */
	public void push(Player player, Player dealer) {
		player.endTurn(false, PUSH);
		dealer.endTurn(false, PUSH);
	}

}
