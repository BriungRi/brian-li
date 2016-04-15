package binarytree;

public class Morse implements Comparable{
	private int val;
	private String let;
	
	public Morse(int val, String let){
		this.val = val;
		this.let = let;
	}
	
	public int getValue(){
		return val;
	}
	
	public String getLetter(){
		return let;
	}
	
	public int compareTo(Object arg0){
		return this.getValue() - ((Morse)arg0).getValue();
	}
	
	public String toString(){
		return val + " - " + let;
	}
}
