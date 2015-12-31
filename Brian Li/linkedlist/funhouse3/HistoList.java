package funhouse3;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.*;

import funhouse.ListNode;
import static java.lang.System.*;

public class HistoList {
	private HistoNode front;
	private HistoNode theList;

	public HistoList() {
		theList = new HistoNode();
	}

	// addLetter will add a new node to the front for let if let does not exist
	// addLetter will bump up the count if let already exists
	public void addLetter(char let) {
		if (front == null) {
			front = new HistoNode(let, 1, theList);
			theList = new HistoNode(front.getLetter(), 1, front);
		} else {
			HistoNode toAdd = theList;
			while (toAdd.getNext() != front) {
				toAdd = toAdd.getNext();
			}
			if (toAdd.getLetter() == let) {
				toAdd.setLetterCount(toAdd.getLetterCount() + 1);
			} else
				toAdd.setNext(new HistoNode(let, 1, front));
		}
	}

	// returns the index pos of let in the list if let exists
	public int indexOf(char let) {
		int count = 0;
		HistoNode toCopy = theList;
		if (toCopy.getLetter() == let)
			return 0;
		else
			count += toCopy.getLetterCount();
		toCopy = toCopy.getNext();
		while (toCopy.getNext() != front.getNext()) {
			if(toCopy.getLetter() == let)
				return count;
			count += toCopy.getLetterCount();
			toCopy = toCopy.getNext();
		}
		return count;
	}

	// returns a reference to the node at spot
	private HistoNode nodeAt(int spot) {
		int count = 0;
		HistoNode toCopy = theList;
		if(spot == count){
			return toCopy;
		}
		count++;
		toCopy = toCopy.getNext();
		while(toCopy.getNext() != front.getNext()){
			if(spot == count){
				return toCopy;
			}
			count++;
		}
		return null;
	}

	// returns a string will all values from list
	public String toString() {
		String output = "";
		HistoNode toCopy = theList;
		for (int i = 0; i < toCopy.getLetterCount(); i++)
			output += toCopy.getLetter() + " ";
		toCopy = toCopy.getNext();
		while (toCopy.getNext() != front.getNext()) {
			for (int i = 0; i < toCopy.getLetterCount(); i++)
				output += toCopy.getLetter() + " ";
			toCopy = toCopy.getNext();
		}

		return output;
	}
}