package shared;

import p11_3.DataSet;

public class DataSetTester
{
	public static void main(String[] args)
	{
		Measurable esha = new Student("esha", 3.6);
		//Measurable nikhil = new Student("nikhil", 2.0);
		Measurable babe = new Pig();
		
		DataSet ds = new DataSet();
		ds.add(babe);
		ds.add(esha);
		
		//Student theBest = (Student) ds.getMaximum();
		//System.out.println(theBest.getName());
		
		Measurable theBest = ds.getMaximum();
		System.out.println(theBest.getMeasure());
		
	}
}
