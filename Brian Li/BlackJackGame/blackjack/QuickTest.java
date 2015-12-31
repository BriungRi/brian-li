package blackjack;

import java.util.ArrayList;
import java.util.List;

import blackjack.players.SmartPlayer;

public class QuickTest 
{
	public static void main(String[] args)
	{
		String[][] hardSet = {{"H", "H", "H", "H", "H", "H", "H", "H", "H", "H"},
				{"H", "H", "H", "H", "H", "H", "H", "H", "H", "H"},
				{"H", "H", "H", "H", "H", "H", "H", "H", "H", "H"},
				{"H", "H", "H", "H", "H", "H", "H", "H", "H", "H"},
				{"H", "H", "H", "H", "H", "H", "H", "H", "H", "H"},
				{"H", "H", "Dh", "Dh", "Dh", "Dh", "H", "H", "H", "H"},
				{"H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "H"},
				{"H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh"},
				{"H", "H", "H", "S", "S", "S", "H", "H", "H", "H"},
				{"H", "S", "S", "S", "S", "S", "H", "H", "H", "H"},
				{"H", "S", "S", "S", "S", "S", "H", "H", "H", "H"},
				{"H", "S", "S", "S", "S", "S", "H", "H", "H", "Rh"},
				{"Rh", "S", "S", "S", "S", "S", "H", "H", "Rh", "Rh"},
				{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"},
				{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"},
				{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"},
				{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"}};
		
		String[][] softSet = {{"H", "H", "H", "H", "Dh", "Dh", "H", "H", "H", "H"},
				{"H", "H", "H", "H", "Dh", "Dh", "H", "H", "H", "H"},
				{"H", "H", "H", "Dh", "Dh", "Dh", "H", "H", "H", "H"},
				{"H", "H", "H", "Dh", "Dh", "Dh", "H", "H", "H", "H"},
				{"H", "H", "Dh", "Dh", "Dh", "Dh", "H", "H", "H", "H"},
				{"H", "S", "Ds", "Ds", "Ds", "Ds", "S", "S", "H", "H"},
				{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"},
				{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"}};
		
		String[][] splitSet = {{"P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
				{"H", "Ph", "Ph", "P", "P", "P", "P", "H", "H", "H"},
				{"H", "Ph", "Ph", "P", "P", "P", "P", "H", "H", "H"},
				{"H", "H", "H", "H", "Ph", "Ph", "H", "H", "H", "H"},
				{"H", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "Dh", "H"},
				{"H", "Ph", "P", "P", "P", "P", "H", "H", "H", "H"},
				{"H", "P", "P", "P", "P", "P", "H", "H", "H", "H"},
				{"P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
				{"S", "P", "P", "P", "P", "P", "S", "P", "P", "S"},
				{"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"}};
		
		for(int i = 0; i < splitSet.length; i++)
		{
			for(int j = 0; j < splitSet[0].length; j++)
				System.out.print(splitSet[i][j] + " ");
			System.out.println();
		}
		
	}
}
