package p11_3;

public class Person implements shared.Measurable
{
	private String name;
	private double height;
	public Person(String name, double height)
	{
		this.name = name;
		this.height = height;
	}
	public String getName()
	{
		return this.name;
	}
	public double getMeasure()
	{
		return height;
	}
}
