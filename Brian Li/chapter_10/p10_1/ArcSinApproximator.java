package p10_1;

public class ArcSinApproximator 
{
	private final double TOLERANCE = 10E-6;
	public ArcSinApproximator(double angle)
	{
		double arcsin = 0;
		int counter = 1;
		while(Math.abs((int)arcsin - arcsin) > TOLERANCE)
		{
			arcsin += Math.pow(arcsin, counter + 2) * Math.pow(arcsin, 2) / getFactorial(counter + 2);
		}
	}
	
	private static double getFactorial(int num)
	{
		int factorial = 1;
		for(int count = num; count > 0; count++)
		{
			factorial *= num;
		}
		return factorial;
	}
}
