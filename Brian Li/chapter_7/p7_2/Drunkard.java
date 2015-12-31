package p7_2;

import java.util.Random;

import java.awt.geom.Point2D;

public class Drunkard 
{
	int x;
	int y;
	public Drunkard()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public void move()
	{
		int moveCode = (int)(Math.random() * 5); //0 north, 1 east, 2 south, 3 west
		Random r = new Random();
		moveCode = r.nextInt(4); //0 north, 1 east, 2 south, 3 west
		switch(moveCode)
		{
		case 0:
			this.y++;
			break;
		case 1:
			this.x++;
			break;
		case 2:
			this.y--;
			break;
		case 3:
			this.x--;
			break;
		}
	}
	
	public String getLocation()
	{
		return "(" + this.x + ", " + this.y + ")";
	}
	
	public double getDistance()
	{
		Point2D.Double start = new Point2D.Double(0, 0);
		Point2D.Double end = new Point2D.Double(this.x, this.y);
		return start.distance(end);
	}
}
