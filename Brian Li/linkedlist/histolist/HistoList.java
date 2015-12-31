package histolist;

import funhouse3Trial2.HistoNode;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -

public class HistoList
{
	private ListNode front;

	public HistoList( )
	{
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{
		ThingCount tobj = new ThingCount(obj, 1);
		if (front == null) {
			front = new ListNode(tobj, null);
		} else {
			int location = this.indexOf(tobj);
			if (indexOf(tobj) < 0) {
				ListNode temp = new ListNode(tobj, front);
				front = temp;
			} else {
				ListNode temp = front;
				for(int i = 0; i < location; i++)
					temp=temp.getNext();
				ThingCount tc = (ThingCount) temp.getValue();
				tc.setCount(tc.getCount() + 1);
			}
		}
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		int spot=-1;
		return -1;
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private ListNode nodeAt(int spot)
	{
		ListNode current=front;
		return current;
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		String output = "";
		return output;
	}
}