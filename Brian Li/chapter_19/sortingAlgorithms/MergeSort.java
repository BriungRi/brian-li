package sortingAlgorithms;

public class MergeSort
{
	
	public static void sort(int[] a)
	{
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(int[] a, int low, int high)
	{
		if(low >= high)
			return;
		int mid = (low + high) / 2;
		sort(a, low, mid);
		sort(a, mid + 1, high);
		merge(a, low, mid, high);
	}

	private static void merge(int[] a, int low, int mid, int high)
	{
		int i = low;
		int j = mid;
	    while(i < mid && j < high)
	    {
	    	if(a[i] > a[j])
	    	{
	    		int temp = a[j];
	    		a[j] = a[i];
	    		a[i] = temp;
	    		i++;
	    	}
	    	else
	    	{
	    			j++;
	    	}
	    }
		
	}
}
