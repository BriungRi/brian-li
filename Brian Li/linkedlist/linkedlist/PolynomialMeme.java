package linkedlist;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class PolynomialMeme {
	private LinkedList<Term> list = new LinkedList<Term>();

	public void add(Term p) {
		list.addLast(p);
		sort();
		simplify();
	}

	public void add(LinkedList<Term> p) {
		ListIterator<Term> iter = p.listIterator();
		while (iter.hasNext()) {
			this.add(iter.next());
		}
	}

	public void multiply(LinkedList<Term> t) {
		ListIterator<Term> iter2 = t.listIterator();
		LinkedList<Term> newList = new LinkedList<Term>();

		while (iter2.hasNext()) {
			Term k = iter2.next();
			ListIterator<Term> iter = list.listIterator();
			while (iter.hasNext()) {
				Term j = iter.next();
				Term newT = new Term(j.getX() * k.getX(), j.getY() + k.getY());
				newList.addLast(newT);
			}
		}
		list = newList;
		simplify();
	}

	public void multiply(Term p) {
		ListIterator<Term> iter = list.listIterator();
		LinkedList<Term> newList = new LinkedList<Term>();
		while (iter.hasNext()) {
			Term j = iter.next();
			j.setX(j.getX() * p.getX());
			j.setY(j.getY() + p.getY());
			newList.addLast(j);
		}
		list = newList;
	}

	public void sort() {
		Collections.sort(list);
	}

	public void simplify() {
		LinkedList<Term> newList = new LinkedList<Term>();
		while (!list.isEmpty()) {
			ListIterator<Term> iter = list.listIterator();
			Term j = iter.next();
			iter.remove();
			int y = j.getY();
			int x = j.getX();
			while (iter.hasNext()) {
				Term p = iter.next();
				if (p.getY() == y) {
					x += p.getX();
					iter.remove();
				}
			}
			newList.addLast(new Term(x, y));
		}
		ListIterator<Term> iter = newList.listIterator();
		while(iter.hasNext()){
			if(iter.next().getX() == 0){
				iter.remove();
			}
		}
		list = newList;
	}

	public void findDerivative() {
		ListIterator<Term> iter = list.listIterator();
		while (iter.hasNext()) {
			Term p = iter.next();
			if (p.getY() > 0) {
				p = new Term((int) (p.getX() * p.getY()), (int) p.getY() - 1);
				iter.remove();
				iter.add(p);
			} else {
				iter.remove();
			}
		}

	}

	public String toString() {
		String s = "";
		ListIterator<Term> iter = list.listIterator();
		while (iter.hasNext()) {
			Term p = iter.next();
			if (p.getY() == 0)
				s += p.getX();
			else if (p.getX() == 1)
				s += "x^" + p.getY();
			else if (p.getY() == 1)
				s += p.getX() + "x";
			else
				s += p.getX() + "x^" + p.getY();
			if (iter.hasNext())
				s += " + ";
		}
		return s;
	}
}
