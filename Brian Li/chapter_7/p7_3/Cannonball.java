package p7_3;

public class Cannonball 
{
	private final double gravity = 9.81;
	private final double deltaT = 0.01;
	private double position = 0;
	private double time = 0;
	private double aVelocity, pVelocity;
	
	Cannonball(double velocity)
	{
		this.aVelocity = velocity;
		this.pVelocity = velocity;
	}
	
	public void updatePosition()
	{
		position = position  + (aVelocity * deltaT);
		this.time += deltaT;
	}
	
	public void updateVelocity()
	{
		aVelocity = aVelocity - (gravity * deltaT);
	}
	
	public double actualPosition()
	{
		return this.position;
	}
	
	public double predictedPosition()
	{
		return ((-0.5) * 9.81 * Math.pow(this.time, 2)) + (this.pVelocity * this.time);
	}
	
	public double getTime()
	{
		return this.time;
	}
}
