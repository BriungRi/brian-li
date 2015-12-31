package linkedlist;

public class Term implements Comparable<Term>{
	private int x, y;
	
	public Term(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(Term arg0) {
		return  arg0.getY() - this.getY();
	}
}
