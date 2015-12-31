package general;

//Aaron and Brian
public class Queens {

	private static int count = 0;

	public static void main(String[] args) {
		fill(8);
		System.out.println("Count: " + count);
	}

	public static void fill(int n) {
		int[] a = new int[n];
		fill(a, 0);
	}

	public static void fill(int[] a, int n) {
		int N = a.length;
		if (n == N)
			display(a);
		else {
			for (int i = 0; i < N; i++) {
				a[n] = i;
				if (canPlace(a, n))
					fill(a, n + 1);
			}
		}
	}

	public static boolean canPlace(int[] q, int n) {
		for (int i = 0; i < n; i++) {
			if (q[i] == q[n])
				return false;
			if ((q[i] - q[n]) == (n - i))
				return false;
			if ((q[n] - q[i]) == (n - i))
				return false;
		}
		return true;
	}

	public static void display(int[] q) {
		count++;
		int N = q.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (q[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}


