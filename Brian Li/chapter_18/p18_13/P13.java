package p18_13;

public class P13 {

	public static void main(String[]args)
	{
		move(3, 1, 3);
	}
	public static void move(int disks, int source, int target)
	{
		if(disks == 0)
			System.out.println("You're finished!");
		if(disks == 1)
			System.out.println("You're finished!");
		if(disks >= 2)
		{
			int aux = 6 - source - target;

			System.out.println("Move a disk from peg " + source + " to peg " + target);
			move(disks - 1, aux, target);
		}
		
		
	}
}
