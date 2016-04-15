//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Graph {
	private TreeMap<String, String> map;
	private boolean yayOrNay;

	public Graph(String line) {
		Scanner read = new Scanner(line);
		map = new TreeMap<String, String>();
		while (read.hasNext()) {
			String connection = read.next();
			String first = connection.substring(0, 1);
			String second = connection.substring(1, 2);
			if (map.containsKey(first))
				map.put(first, map.get(first) + second);
			else
				map.put(first, second);
			if(map.containsKey(second))
				map.put(second, map.get(second) + first);
			else
				map.put(second, first);
		}
	}

	public boolean connects() {
		return yayOrNay;
	}

	public void check(String first, String second, String placesUsed) {
		if(map.get(first).contains(second))
			yayOrNay = true;
		else{
			String connections = map.get(first);
			for(int i = 0; i < connections.length(); i++){
				String let = connections.substring(i, i + 1);
				if(!placesUsed.contains(let)){
					placesUsed += let;
					check(let, second, placesUsed);
				}
			}
		}
	}

	public String toString() {
		return map.toString();
	}
}