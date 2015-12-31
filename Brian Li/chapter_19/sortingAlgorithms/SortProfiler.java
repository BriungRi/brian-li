package sortingAlgorithms;

public class SortProfiler {

	public static void main(String[] args) {
		for (int arrayLength = 100000; arrayLength < 10000000; arrayLength += 10000) {
			System.out.println("Array Length: " + arrayLength);
			for (int count = 0; count < 3; count++) {
				int[] newArray = new int[arrayLength];

				for (int j = 0; j < newArray.length; j++)
					newArray[j] = (int) (Math.random() * 101);

				Sorter newSorter = new Sorter();

				System.out.println("\n" + whichStringBoi(count));

				long startTime = System.currentTimeMillis();

//				System.out.println("Start Time: " + (startTime - startTime)
//						+ " ms");

				newSorter.sort(count, newArray);

				long endTime = System.currentTimeMillis();

				System.out.println("Time Elapsed: " + (endTime - startTime)
						+ " ms");
			}
			System.out.println("\n");

		}
	}

	public static String whichStringBoi(int x) {
		if (x == 0)
			return "Selection Sort";
		if (x == 1)
			return "Insertion Sort";
		else
			return "Merge Sort";
	}
}
