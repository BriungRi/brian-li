package p7_3;

public class p3 
{
	public static void main(String[]args)
	{
		Cannonball simulation = new Cannonball(75);
		System.out.println("Time: " + simulation.getTime());
		System.out.println("Actual Position: " + simulation.actualPosition());
		System.out.println("Predicted Position " + simulation.predictedPosition());
		simulation.updatePosition();
		simulation.updateVelocity();
		
		while(simulation.actualPosition() > 0)
		{
			simulation.updatePosition();
			simulation.updateVelocity();
			if(simulation.actualPosition() > 0)
			{
				System.out.println("Time: " + simulation.getTime());
				System.out.println("Actual Position: " + simulation.actualPosition());
				System.out.println("Predicted Position " + simulation.predictedPosition());
			}
			else
			{
				System.out.println("Time: " + simulation.getTime());
				System.out.println("Actual Position: 0");
				System.out.println("Predicted Position " + simulation.predictedPosition());
			}
		}
		
		
	}
}
