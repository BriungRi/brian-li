package funhouse3Trial2;

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

	// addLetter will add a new node to the front for let if let does not exist
	// addLetter will bump up the count if let already exists
	public void addLetter(char let) {
		if (front == null) {
			front = new HistoNode(let, 1, null);
		} else {
			if (indexOf(let) < 0) {
				HistoNode temp = new HistoNode(let, 1, front);
				front = temp;
			} else {
				HistoNode temp = front;
				temp = nodeAt(indexOf(let));
				temp.setLetterCount(temp.getLetterCount() + 1);
			}
		}
	}

	// returns the index pos of let in the list if let exists
	public int indexOf(char let) {
		int count = 0;
		HistoNode copy = front;
		while (copy != null) {
			if (copy.getLetter() == let) {
				return count;
			} else {
				copy = copy.getNext();
				count++;
			}
		}
		return -1;
	}

	// returns a reference to the node at spot
	private HistoNode nodeAt(int spot) {
		int count = 0;
		HistoNode copy = front;
		while (copy != null) {
			if (count == spot)
				return copy;
			count++;
			copy = copy.getNext();
		}
		return copy;
	}

	// returns a string will all values from list
	public String toString() {
		String output = "";
		HistoNode toCopy = front;
		while (toCopy.getNext() != null) {
			output += toCopy.getLetter() + " - " + toCopy.getLetterCount()
					+ " ";
			toCopy = toCopy.getNext();
		}

		return output;
	}
}