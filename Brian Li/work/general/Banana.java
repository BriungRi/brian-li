package general;

public class Banana {
	public static void main(String[]args){
		System.out.println(reverse("what"));
	}
	
	public static String reverse(String str){
		if(str.length() == 0 || str.length() == 1){
			return str;
		}
		else{
			return str.substring(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
		}
	}
}
