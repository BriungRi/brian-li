package queues;

public class CircularArrayQueue

{
	private int head;

	private int tail;

	private int theSize;

	private Object[] elements;

	public CircularArrayQueue(int capacity) {
		elements = new Object[capacity];
	}

	public void add(Object x) {
		if (head == tail && theSize != 0) {
			Object[] temp = new Object[elements.length * 2];
			int count = 0;
			for (int i = head; i < elements.length; i++) {
				temp[count] = elements[i];
				count++;
			}
			for (int i = 0; i < head; i++) {
				temp[count] = elements[i];
				count++;
			}
			elements = temp;
			head = 0;
			tail = count;
		}

		elements[tail] = x;
		if (tail + 1 < elements.length)
			tail++;
		else
			tail = 0;
		theSize++;
	}

	public Object remove() {
		Object toRemove = elements[head];
		elements[head] = null;
		if (head + 2 < elements.length) {
			head++;
		} else
			head = 0;
		theSize--;
		return toRemove;
	}

	public int size() {
		return theSize;
	}

	public String toString() {
		String s = "";
		for (Object o : elements) {
			s += o + " ";
		}
//		s += "\n";
//		s += "Head: " + head + "\n";
//		s += "Tail: " + tail;
		return s;
	}

	public static void main(String[] args) {

		CircularArrayQueue a = new CircularArrayQueue(10);

		a.add(1);

		a.add(2);

		a.add(3);

		a.add(4);

		a.add(5);

		a.add(6);

		a.add(7);

		a.add(8);

		a.add(9);

		System.out.println(a);

		System.out.println("NEXT: " + a.remove());

		System.out.println("NEXT: " + a.remove());

		System.out.println("NEXT: " + a.remove());

		System.out.println(a);

		a.add(10);

		System.out.println(a);

		a.add(11);

		System.out.println(a);

		a.add(12);

		System.out.println(a);

		System.out.println("NEXT: " + a.remove());

		System.out.println(a);

		a.add(13);

		System.out.println(a);

		a.add(14);

		System.out.println(a);

		a.add(15);

		System.out.println(a);

		System.out.println("NEXT: " + a.remove());

		System.out.println(a);

	}
}