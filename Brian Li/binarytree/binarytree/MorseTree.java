package binarytree;

import java.util.Scanner;

public class MorseTree extends BalancedTree {
	public MorseTree(Morse[] data) {
		super(data);
		inOrder();
	}

	public String toEng(String morse) {
		String output = "";
		TreeNode curr = root;
		for (int i = 0; i < morse.length(); i++) {
			if(morse.charAt(i) == '-')
				curr = curr.getLeft();
			else if (morse.charAt(i) == '.')
				curr = curr.getRight();
			else if(morse.charAt(i) == '/'){
				output += ((Morse)curr.getValue()).getLetter() + " ";
				curr = root;
			}
			else if(morse.charAt(i) == ' '){
				output += ((Morse)curr.getValue()).getLetter();
				curr = root;
			}
		}

		return output;
	}
	
	public String toMorse(String phrase){
		String output = "";
		TreeNode curr = root;
		phrase = phrase.toUpperCase();
		for(int i = 0; i < phrase.length(); i++){
			if(phrase.substring(i, i+1).equals(" ")){
				output += "/";
				i++;
			}
			int val = code.indexOf(phrase.substring(i, i+1));
			while(val != ((Morse)curr.getValue()).getValue()){
				int currval = ((Morse)curr.getValue()).getValue();
				if(val > currval){
					output += ".";
					curr = curr.getRight();
				}
				else if(val < currval){
					output += "-";
					curr = curr.getLeft();
				}
			}
			output += " ";
			curr = root;
		}
		return output;
	}
	
	public void setCode(String c){
		this.code = c;
	}

	public static void main(String[] args) {
		String code = "0-9O. 8M Q G Z7T Y K C N X D B6/1J W P A   R L E2- U F I3V S4H5";
		String morse = "-- -.--/..-. . . -/... -- . .-.. .-../.- -. -../-- -.--/-. --- ... ./.-. ..- -. ... ";
		String english = "MY FEET SMELL AND MY NOSE RUNS";
		Morse[] m = new Morse[63];
		for (int i = 0; i < code.length(); i++) {
			m[i] = new Morse(i, code.substring(i, i + 1));
		}
		MorseTree mt = new MorseTree(m);
		mt.setCode(code);
		System.out.println(mt.toEng(morse));
		System.out.println(mt.toMorse(english));

	}
}
