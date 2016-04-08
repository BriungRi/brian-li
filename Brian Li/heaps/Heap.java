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
		while(bot > 0){
			int child = bot + 1;
			int parent = child / 2;
			if(list.get(child - 1) > list.get(parent - 1))
				swap(child - 1, parent - 1);
			bot = parent - 1;
		}
	}

	public void remove( )
	{
		list.set(0,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(list.size());
	}

	public void swapDown(int top)
	{
		int curr = 1;
		int lchild = 2;
		int rchild = 3;
		while(rchild <= top){
			boolean flag = list.get(lchild - 1) > list.get(rchild - 1);
			if(flag && list.get(curr - 1) < list.get(lchild - 1)){
				swap(curr - 1, lchild - 1);
				curr = lchild;
			}
			else if(list.get(curr - 1) < list.get(rchild - 1)){
				swap(curr - 1, rchild - 1);
				curr = rchild;
			}
			else
				break;
			lchild = curr * 2;
			rchild = lchild + 1;
		}
		if(lchild <= list.size() && list.get(curr - 1) < list.get(lchild - 1)){
			swap(curr - 1, lchild - 1);
		}
	}

	private void swap(int start, int finish)
	{
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
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
