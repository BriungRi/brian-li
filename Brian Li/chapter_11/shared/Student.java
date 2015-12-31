package shared;

public class Student implements Measurable
{
	private String theName;
	private double theGPA;
	
	public Student(String name, double gpa)
	{
		theName = name;
		theGPA = gpa;
	}
	
	public String getName()
	{
		return theName;
	}
	
	public double getMeasure()
	{
		return theGPA;
	}
}
