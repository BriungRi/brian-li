package standardAlgorithms;

import java.util.ArrayList;

public class StandardAlgorithms {

	public static void main(String[] args) {
//		int[] newArray = new int[10];
//		
//		for(int count = 0; count < newArray.length; count++)
//			newArray[count] = (int)(Math.random() * 101);
//		
//		System.out.println(toString(newArray));
//		System.out.println(findMin(newArray));
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(0);
		nums.add(5);
		nums.add(2);
		nums.add(3);
		nums.add(3);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		
		System.out.println(nums);
		removeDuplicates(nums);
		System.out.println(nums);
	}
	
	public static int findMin(int[] nums)
	{
		int index = 0;
		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] < nums[index])
			{
				index = i;
			}
		}
		return index;
	}
	
	public static void removeFrom(ArrayList<Integer> nums, int toRemove)
	{
		for(int i = 0; i < nums.size(); i++)
		{
			if(nums.get(i) == toRemove)
			{
				nums.remove(i);
				i--;
			}
		}
	}
	
	public static void removeDuplicates(ArrayList<Integer> nums)
	{
		for(int i = 0; i < nums.size() - 1; i++)
		{
			if(nums.get(i) == nums.get(i + 1))
			{
				nums.remove(i + 1);
				i--;
			}
		}
	}
	
	public static int[][] traverse(int[] nums)
	{
		int[][] newArray = new int[5][5];
		int count = 0;
		for(int i = 0; i < newArray.length; i++)
		{
			for(int j = 0; j < newArray[i].length; j++)
			{
				newArray[i][j] = nums[count];
			}
		}
		return newArray;
	}
	
	public static void insert(ArrayList<Integer> nums, int toInsert)
	{
		int i = 0;
		while(toInsert > nums.get(i))
		{
			i++;
		}
		nums.add(i, toInsert);
	}
	
//	public static int[] consolidate(int[] nums)
//	{
//		int[] newArray = new int[nums.length];
//		int count = 0;
//		for(int i = 0; i < nums.length; i++)
//		{
//			if(nums[i] != 0)
//			{
//				newArray[count] = nums[i];
//				count++;
//			}
//		}
//		return newArray;
//	}
	
	public static void consolidate(int[] nums)
	{
		int count = 0;
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] != 0)
			{
				nums[count] = nums[i];
				count++;
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

}
