package p7_4;

public class p4 
{
	public static void main(String[]args)
	{
		Cannonball newBall = new Cannonball(10, 45);
		newBall.updateVelocity();
		newBall.updatePositionH();
		newBall.updatePositionV();
		System.out.println("Time: " + newBall.getTime());
		System.out.println("Horizontal: " + newBall.actualPositionH());
		System.out.println("Vertical: " + newBall.actualPositionV());
		
		while(newBall.actualPositionV() > 0)
		{
			if(newBall.actualPositionV() > 0)
			{
				newBall.updateVelocity();
				newBall.updatePositionH();
				newBall.updatePositionV();
				System.out.println("Time: " + newBall.getTime());
				System.out.println("Horizontal: " + newBall.actualPositionH());
				System.out.println("Vertical: " + newBall.actualPositionV());
			}
			else
			{
				System.out.println("Time: " + newBall.getTime());
				System.out.println("Horizontal: " + newBall.actualPositionH());
				System.out.println("Vertical: 0");
			}
		}
	}
}
