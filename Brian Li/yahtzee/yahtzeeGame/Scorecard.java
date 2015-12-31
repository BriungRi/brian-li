package yahtzeeGame;

import java.util.ArrayList;

public class Scorecard 

{
	private ArrayList<String> actions = new ArrayList<String>(); //total actions
	private ArrayList<String> allowedActions = new ArrayList<String>();
	private int upperSection = 0; //sum of the uppersection
	
	/**
	 * constructor, enters actions
	 */
	public Scorecard()
	{
		actions.add("ACES");
		actions.add("TWOS");
		actions.add("THREES");
		actions.add("FOURS");
		actions.add("FIVES");
		actions.add("SIXES");
		actions.add("FH");
		actions.add("TOK");
		actions.add("FOK");
		actions.add("SS");
		actions.add("LS");
		actions.add("Y");
		actions.add("C");
		for(int i = 0; i < actions.size(); i++)
		{
			allowedActions.add(actions.get(i));
		}
	}
	
	/**
	 * Returns a string of scorecard
	 */
	public String toString()
	{
		String output = "Scorecard: \n";
		for(int i = 0; i < actions.size(); i++)
			output += actions.get(i) + "\n";
		return output;
	}
	
	/**
	 * Checks if actions contains input
	 * @param s
	 * @return whether or not actions contains s
	 */
	public boolean contains(String s)
	{
		return allowedActions.contains(s.toUpperCase());
	}
	
	/**
	 * Acts and updates scorecard
	 * @param s
	 * @param d
	 * @return score of action
	 */
	public int act(String s, FiveDie d)
	{
		s = s.toUpperCase();
		if(actions.contains(s))
		{
			if(s.equals("ACES"))
			{
				actions.set(0, "ACES -- " + d.sum(1));
				allowedActions.remove(allowedActions.indexOf(new String("ACES")));
				upperSection += d.sum(1);
				return d.sum(1);
			}
			else if(s.equals("TWOS"))
			{
				actions.set(1, "TWOS -- " + d.sum(2));
				allowedActions.remove(allowedActions.indexOf(new String("TWOS")));
				upperSection += d.sum(2);
				return d.sum(2);
			}
			else if(s.equals("THREES"))
			{
				actions.set(2, "THREES -- " + d.sum(3));
				allowedActions.remove(allowedActions.indexOf(new String("THREES")));
				upperSection += d.sum(3);
				return d.sum(3);
			}
			else if(s.equals("FOURS"))
			{
				actions.set(3, "FOURS -- " + d.sum(4));
				allowedActions.remove(allowedActions.indexOf(new String("FOURS")));
				upperSection += d.sum(4);
				return d.sum(4);
			}
			else if(s.equals("FIVES"))
			{
				actions.set(4, "FIVES -- " + d.sum(5));
				allowedActions.remove(allowedActions.indexOf(new String("FIVES")));
				upperSection += d.sum(5);
				return d.sum(5);
			}
			else if(s.equals("SIXES"))
			{
				actions.set(5, "SIXES -- " + d.sum(6));
				allowedActions.remove(allowedActions.indexOf(new String("SIXES")));
				upperSection += d.sum(6);
				return d.sum(6);
			}
			else if(s.equals("FH"))
			{	
				if (d.fullHouse())
				{
					actions.set(6, "FH -- 25");
					allowedActions.remove(allowedActions.indexOf(new String("FH")));
					return 25;
				}
				return 0;
			}
			else if(s.equals("TOK") && (d.tok() || d.fok()))
			{
				actions.set(7, "TOK -- " + d.sum(-1));
				allowedActions.remove(allowedActions.indexOf(new String("TOK")));
				return d.sum(-1);
			}
			else if(s.equals("FOK") && d.fok())
			{
				actions.set(8, "FOK -- " + d.sum(-1));
				allowedActions.remove(allowedActions.indexOf(new String("FOK")));
				return d.sum(-1);
			}
			else if(s.equals("SS"))
			{
				if (d.SS())
				{	actions.set(9, "SS -- 30");
				allowedActions.remove(allowedActions.indexOf(new String("SS")));
					return 30;
				}
				return 0;
			}
			else if(s.equals("LS"))
			{	
				if (d.LS())
				{
					actions.set(10, "LS -- 40");
					allowedActions.remove(allowedActions.indexOf(new String("LS")));
					return 40;
				}
				return 0;
			}
			else if(s.equals("Y"))
			{
				if (d.Y())
				{
					actions.set(11, "Y -- 50");
					allowedActions.remove(allowedActions.indexOf(new String("Y")));
					return 50;
				}
				return 0;
			}
			else if(s.equals("C"))
			{
				actions.set(12, "C -- " + d.sum(-1));
				allowedActions.remove(allowedActions.indexOf(new String("C")));
				return d.sum(-1);
			}
		}
		try{ 
			actions.set(actions.indexOf(s), actions.get(actions.indexOf(s)) + " -- 0"); 
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("out of bounds error");
		}
		return 0;
	}
	
	/**
	 * Calculates bonus for uppersection
	 * @return bonus
	 */
	public int bonus()
	{
		if(upperSection >= 63)
		{
			return 35;
		}
		return 0;
	}
	
}
