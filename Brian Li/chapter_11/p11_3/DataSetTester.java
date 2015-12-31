package p11_3;

import shared.Measurable;

public class DataSetTester {

	public static void main(String[] args) 
	{
			Measurable p1 = new Person("Brian", 160);
			Measurable p2 = new Person("Kevin", 170);
			Measurable p3 = new Person("Justin", 180);
			
			DataSet compSci = new DataSet();
			compSci.add(p1);
			compSci.add(p2);
			compSci.add(p3);
			
			System.out.println("Average Height: " + compSci.getAverage());
			System.out.println("Maximum Height: " + ((Person)compSci.getMaximum()).getName());
	}

}
