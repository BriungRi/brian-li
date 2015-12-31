package general;

public class RecursionExam {
	public static void main(String[] args) {
		String[][] array = new String[10][10];
		makeArray(array);
		display(array);
		System.out.println("Sum: " + findSum(array));
	//	test();
	}
	
	public static void test(){
		double sum = 0;
		int numberTimes = 10000;
		System.out.print("Loading: ");
		for(int i = 0; i < numberTimes; i++){
			String[][] array = new String[10][10];
			makeArray(array);
			sum += numStars(array);
			if(i % (numberTimes / 20) == 0)
				System.out.print("|");
		}
		System.out.println();
		System.out.println("Average Number of Stars: " + (sum / numberTimes));
		
	}

	public static void makeArray(String[][] s) {
		fill(s, s.length - 1, s[0].length - 1);
	}

	private static void fill(String[][] s, int length, int width) {
		if (width < 0) {
			return;
		} else {
			fill(s, length, width - 1);
			if (length < 0)
				return;
			else {
				fill(s, length - 1, width);
				if (chance(100) > 70)
					s[length][width] = "*";
				else
					s[length][width] = "" + (int) (Math.random() * 10);
			}
		}
	}

	private static int chance(int num) {
		return (int) (Math.random() * num) + 1;
	}

	public static int findSum(String[][] a) {
		int sum = 0;
		for (String[] r : a) {
			for (String c : r) {
				if (!c.equals("*")) {
					sum += Integer.parseInt(c);
				}
			}
		}
		return sum;
	}

	public static int numStars(String[][] a) {
		int sum = 0;
		for (String[] r : a) {
			for (String c : r) {
				if(c.equals("*"))
					sum++;
			}
		}
		return sum;
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
