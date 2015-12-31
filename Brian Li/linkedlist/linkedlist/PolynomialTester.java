package linkedlist;

import java.awt.Point;
import java.util.LinkedList;
import java.util.ListIterator;

public class PolynomialTester {

	public static void main(String[] args) {
		PolynomialMeme first = new PolynomialMeme();
		first.add(new Term(5, 2));
		first.add(new Term(-2, 0));
		first.add(new Term(2, 2)); //first polynomial
		System.out.println(first);
		LinkedList<Term> second = new LinkedList<Term>();
		second.add(new Term(3, 2));
		second.add(new Term(2, 0)); //second polynomial
		first.add(second); //operation of first nomial and second nomial
		System.out.println(first);
		first.findDerivative();
		System.out.println(first);
		
	}

}
