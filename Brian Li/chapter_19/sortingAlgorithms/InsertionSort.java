package sortingAlgorithms;

public class InsertionSort
{
    public static void sort(int[] x)
    {
        for(int i = 1; i < x.length; i++)
        {
        	int j = i;
        	int temp = x[j];
        	while(temp < x[j - 1] && j > 0)
        	{
        		x[j] = x[j - 1];
        		x[j - 1] = temp;
        		temp = x[j - 1];
        		j--;
        		System.out.println(toString(x));
        	}
        }
        
    }
    
	public static String toString(int[] nums)
	{
		String numbas = "[";
		
		for(int count = 0; count < nums.length - 1; count++)
		{
			numbas += nums[count] + ", ";
		}
		
		return numbas += nums[nums.length - 1] + "]";
	}
	
    public static void recursiveSort(int[] x)
    {
    	for(int count = 1; count < x.length; count++)
    		insert(x, x[count], count);
    }

    public static void sortWithBinarySearch(int[] x)
    {
        
    }

    public static int binarySearch(int[] x, int key)
    {
        return binarySearch(x, key, 0, x.length - 1);
    }

    private static int binarySearch(int[] x, int key, int start, int end)
    {
    	int mid = (start + end) / 2;
        if(x[mid] == key)
        	return mid;
        if(x[mid] < key)
        	return binarySearch(x, key, start + mid, end);
        if(x[mid] > key)
        	return binarySearch(x, key, start, end - mid);
        return 
        	
    }

    // recursive variant sorts x[start] ... x[x.length - 1]
    private static void sort(int[] x, int start)
    {
        
    }

    // inserts value into correct position in x[0]...x[start]
    private static void insert(int[] x, int value, int start)
    {
    	
        	
    }
}
