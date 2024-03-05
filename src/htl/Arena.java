package htl;

import java.util.concurrent.ThreadLocalRandom;

public class Arena{
	
	CharackterTyps p1 = new Gnome("Gnome");
	CharackterTyps p2 = new Dragon("Dragon");
	
	public static int pickBeginner() {
		int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if(numberOfRandomNumber == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(pickBeginner());
	}
	
	

}
