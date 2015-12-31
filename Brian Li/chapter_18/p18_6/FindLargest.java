package p18_6;

public class FindLargest
{
	public static void main(String[] args)
	{
		int[] array = {4,1,7,1,0,9,7};
		System.out.println(findLargest(array));
	}
	
	public static int findLargest(int[] a)
	{
		return findLargest(a, 0);
	}
	
	private static int findLargest(int[] a, int start)
	{
		if(a.length == 1)
			return a[0];
		
		int next = findLargest(a, start + 1);
			return Math.max(a[start], next);
					
		
	}
}
