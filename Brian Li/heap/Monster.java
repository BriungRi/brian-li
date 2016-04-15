

public class Monster implements Comparable{
	
	private int height;
	private int weight;
	private int age;
	public Monster(){
		height = 0;
		weight = 0;
		age = 0;
	}
	public Monster(int ht, int wt, int age){
		this.height = ht;
		this.weight = wt;
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return height + " " + weight + " " + age;
	}
	@Override
	public int compareTo(Object obj) {
		int diff1 = this.getHeight() - ((Monster)obj).getHeight();
		int diff2 = this.getWeight() - ((Monster)obj).getWeight();
		int diff3 = this.getAge() - ((Monster)obj).getAge();
		if(diff1 > 0)
			return 1;
		else if(diff1 == 0 && diff2 > 0)
			return 1;
		else if(diff2 == 0 && diff3 > 0)
			return 1;
		else if(diff1 == 0 && diff2 == 0 && diff3 == 0)
			return 0;
		else
			return -1;
	}
	
	
}
