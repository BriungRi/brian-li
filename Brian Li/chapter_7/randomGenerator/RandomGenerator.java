package randomGenerator;

public class RandomGenerator 
{
	public static void main(String[]args)
	{
		for(int count = 1; count <= 50; count++)
		{
			Generator newGenerator = new Generator(-5, 10);
			System.out.println(newGenerator.getNum());
		}
	}
}
