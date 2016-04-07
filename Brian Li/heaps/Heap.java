import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap
{
	private List<Integer> list;

	public Heap()
	{
		list = new ArrayList<Integer>();
	}

	public void add(int value)
	{
		list.add(value);
		swapUp(list.size()-1);
	}

   public void swapUp(int bot)
   {
	}

	public void remove( )
	{
		list.set(0,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(list.size());
	}

	public void swapDown(int top)
	{
	}

	private void swap(int start, int finish)
	{
	}

	public void print()
	{
		out.println("\n\nPRINTING THE HEAP!\n\n");
		int level = 0;
		int upTo = (int)Math.pow(2, level);
		int count = 0;
		makeSpace(level);
		for(int i : list){
			if(count >= upTo){
				out.println();
				level++;
				upTo = (int)Math.pow(2, level);
				count = 0;
			}
			makeSpace(level);
			out.print(i + "  ");
			count++;
		}
		out.println();
	}

	private void makeSpace(int level){
		int numSpaces = 0;
		switch(level){
			case 0:
			numSpaces = 6;
			break;
			case 1:
			numSpaces = 7;
			break;
			case 2:
			numSpaces = 3;
			break;
		}

		for(int i = 0; i < numSpaces; i++){
			out.print(" ");
		}
	}

	public String toString()
	{
		return list.toString();
	}
}
