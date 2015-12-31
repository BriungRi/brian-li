package randomGenerator;

public class Generator 
{
	private int a, b;
	int r;
	public Generator(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public int getNum()
	{
		return (int)(Math.random() * Math.abs(this.a-this.b) + 1) + a;
	}
}
