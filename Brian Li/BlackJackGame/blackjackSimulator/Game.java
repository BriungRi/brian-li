package blackjackSimulator;

import java.util.Scanner;

public class Game 
{
	public static void main(String[]args)
	{
		Shoe shoe = new Shoe();

		Scanner input = new Scanner(System.in);
		
		Player d = new Dealer();
		Player p = new Player();
		
		boolean over = false;
		
		while(!over)
		{
			System.out.println(p.getBalance());
			
			System.out.println(">> Enter bet amount: ");
			p.bet(input.nextInt());
			
			System.out.println(p.getBalance());
			Scanner keyboard1 = new Scanner(System.in);
			p.newHand(shoe.draw(), shoe.draw());
			d.newHand(shoe.draw(), shoe.draw());
			System.out.println(p.showCards());
			System.out.println(d.showCards());

			System.out.println(">> Press \"h\" to hit. Otherwise, press any other key to stand");
			boolean hit = keyboard1.next().equals("h");
			BlackJack game = new BlackJack(p, d, shoe, hit);
			
			System.out.println(p.showCards());
			System.out.println(((Dealer)d).endTurn());
			
			System.out.println(p.getBalance());
			
			Scanner keyboard2 = new Scanner(System.in);
			System.out.println(">> Press \"q\" to quit. Otherwise, press any other key");
			over = keyboard2.nextLine().equals("q");
		}
		
	}
}
