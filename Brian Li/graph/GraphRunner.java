//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("H:\\graph1.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();
		for(int x=0; x<howManyTimes; x++)
		{
			Graph g = new Graph(file.nextLine());
			String check = file.nextLine();
			String first = check.substring(0,1);
			String second = check.substring(1,2);
			g.check(first, second, "");
			System.out.println(first + " connects to " + second + " == " + (g.connects() ? "yes" : "no"));
			System.out.println(g);
		}
	}
}