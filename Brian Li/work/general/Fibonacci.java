package general;

public class Fibonacci {
	public static void main(String[]args){
		int num = 9;
		System.out.println(fibonacci(num));
		
	}
	
	public static int fibonacci(int num){
		if(num == 1 || num == 2){
			return 1;
		}
		else
			return fibonacci(num - 1) + fibonacci(num - 2);
	}
}