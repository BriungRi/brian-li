package yahtzeeGame;

import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Player 1 name: ");
		String n1 = input.nextLine();
		Player a = new Player(n1);
		System.out.println("Enter Player 2 name: ");
		String n2 = input.nextLine();
		Player b = new Player(n2);

		Yahtzee game = new Yahtzee(a, b);
		int i = 0;
		
		while (game.getTurnsLeft() > 0) {
			Player currentPlayer;
			if (i % 2 == 0)
				currentPlayer = a;
			else
				currentPlayer = b;
			
			System.out.println(currentPlayer.getName() + "'s turn");                             //print name
			System.out.println("\n" + currentPlayer.showActions());                              //show available actions
//			System.out.println(currentPlayer.getName() + "'s score: "
//					+ currentPlayer.getScore());
			
			System.out.println("Dice: ");
			System.out.println(game.display(currentPlayer));                                    //display dice
			
			boolean reroll = true;
			
			while(reroll && game.getNumRerolls() > 0)                                           //logic sequence for rerolling (empty string automatically goes to action)
			{
				System.out.println("Enter letters to keep: ");
				game.reroll(currentPlayer, input.nextLine());
				System.out.println(game.display(currentPlayer));
			}
			
			boolean flag = false;
			String action = "";
			while(!flag)
			{	
				System.out.println("Enter action: ");
				action = input.nextLine();
				flag = game.allowedAction(currentPlayer, action);
			}
				
			game.act(currentPlayer, action);
			
			System.out.println("\n" + currentPlayer.showActions());
			System.out.println("Total score: "
					+ currentPlayer.getScore() + "\n");
			System.out.println("Press ENTER to continue");
			input.nextLine();
			i++;
		}
		
		System.out.println(game.winner());

	}
}
