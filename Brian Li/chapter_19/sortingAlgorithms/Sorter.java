package sortingAlgorithms;

public class Sorter 
{
	public static void sort(int sortChoice, int[] x)
	{
		switch(sortChoice)
		{
		case 0: selectionSort(x);
		break;
		case 1: insertionSort(x);
		break;
		case 2: mergeSort(x);
		break;
		}
	}
	public static void selectionSort(int[] x)
	{
		for(int i = 0; i < x.length - 1; i++)
		  {
		    int minIndex = i;

		    for(int j = i + 1; j < x.length; j++)
		      if(x[j] < x[minIndex])
		        minIndex = j;

		    swap(x, i, minIndex);
		  }
	}
	
	public static void insertionSort(int[] x)
	{
		for (int i = 1; i < x.length; i++)
		  {
		    int element = x[i];
		    int j = i;
		    while (j > 0 && element < x[j - 1])
		    {
		      x[j] = x[j - 1];
		      j--;
		    }

		    x[j] = element;
		  }
	}
	
	public static void mergeSort(int[] x)
	{
		mergeSort(x, 0, x.length - 1);
	}
	
	private static void selectionSort(int[] x, int start)
	{
	  if(start == x.length - 1)
	    return;

	  int minIndex = indexOfMin(x, start);
	  swap(x, start, minIndex);
	  selectionSort(x, start + 1);
	}

	private static int indexOfMin(int[] x, int start)
	{
	  if(start == x.length - 1)
	    return start;

	  int minIndexOfRest = indexOfMin(x, start + 1);

	  if(x[start] < x[minIndexOfRest])
	    return start;
	  else
	    return minIndexOfRest;
	}
	
	private static void swap(int[] x, int i, int j)
	{
	  int temp = x[i];
	  x[i] = x[j];
	  x[j] = temp;
	}
	
	private static void insertionSort(int[] x, int start)
	{
	  if (start == x.length)
	    return;

	  insert(x, x[start], start);
	  insertionSort(x, start + 1);
	}

	// inserts value into correct position in x[0]...x[start]
	private static void insert(int[] x, int value, int start)
	{
	  if (start == 0 || value >= x[start - 1])
	  {
	    x[start] = value;
	    return;
	  }

	  x[start] = x[start - 1];
	  insert(x, value, start - 1);
	}

	private static void mergeSort(int[] a, int low, int high)
	{
	  if (low < high)
	  {
	    int mid = (low + high) / 2;
	    mergeSort(a, low, mid);
	    mergeSort(a, mid + 1, high);
	    merge(a, low, mid, high);
	  }
	}
	
	private static void merge(int[] a, int low, int mid, int high)
	{
	  int[] b = new int[mid + 1 - low];
	  System.arraycopy(a, low, b, 0, b.length);

	  int aLowerIndex = low, bIndex = 0, aHigherIndex = mid + 1;
	  while (aLowerIndex < aHigherIndex && aHigherIndex <= high)
	  {
	    if (a[aHigherIndex] < b[bIndex])
	      a[aLowerIndex++] = a[aHigherIndex++];
	    else
	      a[aLowerIndex++] = b[bIndex++];
	  }

	  while (aLowerIndex < aHigherIndex)
	    a[aLowerIndex++] = b[bIndex++];
	}
}
