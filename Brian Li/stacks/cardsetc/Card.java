package cardsetc;

public class Card implements Comparable<Card>{
	private int suit;
	private int value;
	
	public Card(){
		value = 3;
		suit = 1;
		
	}
	public Card(int s, int v){
		suit = s;
		value = v;
	}
	
	public String getValue(){
		if(value == 14){
			return "A";
		}
		else if(value == 11){
			return "J";
		}
		else if(value == 12){
			return "Q";
		}
		else if(value == 13){
			return "K";
		}
		else{
			return "" + value;
		}
	}
	
	public String getSuit(){
		switch(suit){
		case 1:
			return "Clubs";
		case 2:
			return "Diamonds";
		case 3:
			return "Hearts";
		case 4:
			return "Spades";
		}
		return "you're trash";
	}
	
	public String toString(){
		return getValue() + " of " + getSuit();
		
	}
	@Override
	public int compareTo(Card c) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
