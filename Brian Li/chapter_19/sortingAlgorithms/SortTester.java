package sortingAlgorithms;

public class SortTester {

	public static void main(String[] args) 
	{
		int[] newArray = new int[10];
		
		for(int count = 0; count < newArray.length; count++)
			newArray[count] = (int)(Math.random() * 101);
		
		System.out.println(toString(newArray));
		MergeSort sorter = new MergeSort();
		sorter.sort(newArray);
		System.out.println(toString(newArray));
	}
	
//	// recursive variant sorts x[start] ... x[x.length - 1]
//    private static void selectionSort(int[] x, int start)
//    {
//		if(start == x.length - 1)
//			return;
//		int minIndex = indexOfMin(x, start);
//		swap(x, start, minINdex);
//		sort(x, start + 1);
//}

//    public static int indexOfMin(int[] x, int start)
//    {
//        if(start == x.length - 1 || x[start] < x[indexOfMin(x, start + 1)])
//        	return start;
//        
//        return indexOfMin(x, start + 1);        
//    }
	
    //iterative
//	public static int[] selectionSort(int[] nums)
//	{
//		for(int i = 0; i < nums.length - 1; i++)
//		{
//			int min = i;
//			for(int j = i; j < nums.length; j++)
//			{
//				if(nums[j] < nums[min])
//					min = j;
//			}
//			int temp = nums[min];
//			nums[min] = nums[i];
//			nums[i] = temp;
//		}
//		
//		return nums;
//	}
	
	public static void swap(int[]nums)
	{
		int temp = nums[min];
		nums[min] = nums[i];
		nums[i] = temp;
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

}
