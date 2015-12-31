package p7_4;

public class Cannonball 
{
	private final double GRAVITY = 9.81;
	private final double DELTA_T = 0.001;
	private double positionH = 0, positionV = 0;
	private double time = 0;
	private double xVelocity, yVelocity;
	
	Cannonball(double velocity, double angle)
	{
		this.xVelocity = velocity * Math.cos(Math.toRadians(angle));
		this.yVelocity = velocity * Math.sin(Math.toRadians(angle));
	}
	
	public void updatePositionH()
	{
		positionH += (xVelocity * DELTA_T);
		this.time += DELTA_T;
	}

	public void updatePositionV()
	{
		positionV += (yVelocity * DELTA_T);
	}
	public void updateVelocity()
	{
		yVelocity = yVelocity - (GRAVITY * DELTA_T);
	}
	
	public double actualPositionH()
	{
		return this.positionH;
	}
	
	public double actualPositionV()
	{
		return this.positionV;
	}
	
	public double getTime()
	{
		return this.time;
	}
}
