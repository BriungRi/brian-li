package p7_2;

public class p2 
{
	public static void main(String[]args)
	{
		Drunkard dude = new Drunkard();
		int times = 0;
		for(int count = 0; count < 10000; count++)
		{
			dude.move();
			times++;
			System.out.println(dude.getLocation());
		}
		
		System.out.println("Number of moves: " + times);
		System.out.println("Distance from start: " + dude.getDistance());
	}
}
