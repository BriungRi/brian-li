package general;

import java.util.Scanner;
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number");
		int num = input.nextInt();
		System.out.println("Recursively: " + recursiveFactorial(num));
		System.out.println("Iteratively: " + iterativeFactorial(num));
	}
	
	public static int recursiveFactorial(int num){
		if(num == 1){
			return num;
		}
		else{
			return num * recursiveFactorial(num - 1);
		}
	}
	
	public static int iterativeFactorial(int num){
		int fact = 1;
		for(int i = num; i > 0; i--){
			fact *= i;
		}
		return fact;
	}
	
	

}
