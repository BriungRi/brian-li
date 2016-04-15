package binarytree;

class PhoneEntry implements Comparable{

	private String name;

	private String number;

	// constructor

	public PhoneEntry(String myName, String myNumber) {

		name = myName;

		number = myNumber;

	}
	
	public String getName(){
		return name;
	}
	
	public String getNumber(){
		return number;
	}

	public String toString() {

		return "Name: " + name + " Number: " + number;
	}

	@Override
	public int compareTo(Object arg0) {
		return name.compareTo(((PhoneEntry)arg0).getName());
	}
}