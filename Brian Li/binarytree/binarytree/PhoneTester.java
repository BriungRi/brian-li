package binarytree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class PhoneTester {

	public static void main(String[] args) {
		try{
			PhoneBook pb = new PhoneBook();
			BufferedReader br = new BufferedReader(new FileReader(new File("H:\\phone.txt")));
			String line;
			while((line = br.readLine()) != null){
				Scanner reader = new Scanner(line);
				PhoneEntry entry = new PhoneEntry(reader.next(), reader.next());
				pb.add(entry);
			}
			System.out.println("Display:\n" + pb.display());
			
			System.out.print("Lookup Solis: ");
			pb.lookupNumber("Solis");
			System.out.println();
			System.out.print("Reverse Lookup 9810521: ");
			pb.reverseLookup("9810521");
			
			System.out.println("\nDeleting Calder\n");
			pb.delete("Calder");
			System.out.println(pb.display());
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
