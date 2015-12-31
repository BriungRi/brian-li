package p18_4;

public class Finder
{
	public static void main(String[] args)
	{
	    String toSearch = "it's cat";
	    String toFind = "cat";
	    System.out.println(find(toSearch, toFind));
	}
	
	public static boolean find(String toSearch, String toFind)
	{
	    if(toSearch.substring(0, toFind.length()).equals(toFind))
	    	return true;
	    
	    boolean newSearch = find(toSearch.substring(1), toFind);
	    
	    return newSearch;
	    
	}
}
