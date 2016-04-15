import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class YourPQ {
	private List<Monster> list;

	public YourPQ() {
		list = new LinkedList<Monster>();
	}

	public void add(Object obj) {
		list.add((Monster) obj);
		swapUp(list.size() - 1);
	}

	public void swapUp(int bot) {
		while (bot > 0) {
			int child = bot + 1;
			int parent = child / 2;
			if (list.get(child - 1).compareTo(list.get(parent - 1)) < 0)
				swap(child - 1, parent - 1);
			bot = parent - 1;
		}
	}

	private void swap(int start, int finish) {
		Monster temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}

	public Object getMin() {
		return list.get(0);
	}

	public Object removeMin() {
		Monster toReturn = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		swapDown(list.size());
		return toReturn;
	}

	public void swapDown(int top) {
		int curr = 1;
		int lchild = 2;
		int rchild = 3;
		while (rchild <= top) {
			boolean flag = list.get(lchild - 1).compareTo(list.get(rchild - 1)) < 0;
			if (flag && list.get(curr - 1).compareTo(list.get(lchild - 1)) > 0) {
				swap(curr - 1, lchild - 1);
				curr = lchild;
			} else if (list.get(curr - 1).compareTo(list.get(rchild - 1)) > 0) {
				swap(curr - 1, rchild - 1);
				curr = rchild;
			} else
				break;
			lchild = curr * 2;
			rchild = lchild + 1;
		}
		if (lchild <= list.size() && list.get(curr - 1).compareTo(list.get(lchild - 1)) > 0) {
			swap(curr - 1, lchild - 1);
		}
	}

	public String getNaturalOrder() {
		String output = "";

		return output;
	}

	public String toString() {
		return list.toString();
	}

}