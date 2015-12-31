package histolist;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -   
//Lab  -

public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
	}
	
	public ThingCount(Object thang, int cnt)
	{
		thing = thang;
		count = cnt;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int cnt)
	{
		count = cnt;
	}

	public void setThing(Object obj)
	{
		thing = obj;
	}	
	
	public Object getThing()
	{
		return thing;
	}
	
	public boolean equals(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		return other.equals(this);
	}
	
	public int compareTo(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		return other.compareTo(this);
	}
	
	public String toString()
	{
		return ""+ getThing() + " - " + getCount();
	}
}