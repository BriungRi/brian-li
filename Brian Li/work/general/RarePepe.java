package general;

public class RarePepe {
	public static void main(String[] args) {
		String[][] map = new String[10][10];
		makeMaze(map);
		display(map);
	}

	public static void makeMaze(String[][] maze) {
		fill(maze, maze.length - 1, maze[0].length - 1);
	}

	private static void fill(String[][] maze, int length, int width) {
		if (width < 0) {
			return;
		} else {
			fill(maze, length, width - 1);
			if (length < 0)
				return;
			else {
				fill(maze, length - 1, width);
				maze[length][width] = "*";
			}
		}
	}

	public static void display(String[][] a) {
		for (String[] r : a) {
			for (String c : r) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
