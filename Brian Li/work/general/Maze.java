package general;

public class Maze {
	private char[][] corn;
	private int x, y;
	private int a = 64;
	public Maze(char[][] corn, int x, int y){
		this.corn = corn;
		this.x = x;
		this.y = y;
		findExit(x, y);
	}
	
	public String display(){
		String s = "";
		for(int i = 0; i < corn.length; i++){
			for(int j = 0; j < corn[0].length; j++){
				if(i == x && j == y){
					s += ". ";
				}
				else
					s += corn[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}
	
	public boolean findExit(int x, int y) {
		System.out.println(display());
		System.out.println("Step Number: " + (a - 64));
		boolean done = false;
		if(valid (x, y)) {
			corn[x][y] = (char)a;
			a++;
			if(x == corn.length - 1 || y == corn[0].length-1
					|| x == 0 || y == 0)
				done = true;
			else {
				done = findExit(x + 1, y);
				if(!done)
					done = findExit(x - 1, y);
				if(!done)
					done = findExit(x, y + 1);
				if(!done)
					done = findExit(x, y - 1);
			}
			if(done) {
				corn[x][y] = '!'; 
				return true;
			}
		}
		return done;
	}
	
	private boolean valid(int x, int y) {
		boolean result = false;
		if(x >= 0 && x < corn.length &&
				y >= 0 && y < corn[0].length) {
			if(corn[x][y] == ' ')
				result = true;
		}
		return result;
	}
	
	public int getIExit() {
		return x;
	}
	
	public int getJExit() {
		return y;
	}

}
