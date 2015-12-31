package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SudokuGen {
	public static void main(String[]args){
		int[][] sudoku = new int[9][9];
		int[] toCheck = {1,2,3,4,5,6,7,8,9};
	    Collections.shuffle(Arrays.asList(toCheck));
	    sudoku[0] = toCheck;
		fill(sudoku, sudoku.length - 1, sudoku[0].length - 1);
		display(sudoku);
	}
	
	private static void fill(int[][] s, int length, int width) {
		if (width < 1) {
			return;
		} else {
			fill(s, length, width - 1);
			if (length < 0)
				return;
			else {
				fill(s, length - 1, width);
				s[width][length] = numberToPlace(s, length, width);
			}
		}
	}
	
	public static int numberToPlace(int[][] s, int x, int y){
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=1;i<10;i++)			
			al.add(i);
			
		for(int i=0;i<al.size();i++){
			
			if(!canPlace(s,x,y,al.get(i))){
				al.remove(i);
			}
			
		}
		Random r = new Random();
		
		int num = r.nextInt(al.size());
		return al.get(num);
	}
	
	public static boolean canPlace(int[][] board, int x, int y, int current){
		for(int i=0;i<9;i++) {
	        if(current == board[x][i])
	            return false;
	    }
	    for(int i=0;i<9;i++) {
	        if(current == board[i][y])
	            return false;
	    }
	    int cX = 0;
	    int cY = 0;
	    if(x > 2)
	        if(x > 5)
	            cX = 6;
	        else
	            cX = 3;
	    if(y > 2)
	        if(y > 5)
	            cY = 6;
	        else
	            cY = 3;
	    for(int i=cX;i<10 && i<cX+3;i++)
	        for(int j=cY;j<10 && j<cY+3;j++)
	            if(current == board[i][j])
	                return false;
	    return true;
	}
	
	public static int numberOf(int[][] array, int i){
		int num = 0;
		for(int j = 0; j < array.length; j++){
			for(int k = 0; k < array[0].length; k++){
				if(array[j][k] == i){
					num++;
				}
			}
		}
		return num;
	}
	
	public static void display(int[][] a) {
		for (int[] r : a) {
			for (int c : r) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}

