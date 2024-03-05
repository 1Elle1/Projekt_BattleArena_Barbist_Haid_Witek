package htl;

import java.util.Scanner;
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
	
	public static void playerSelection() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welche Charakter möchten sie spielen bitte geben sie den namen in die Komandozeile Player1:");
		String p1Input = sc.next();
		if(p1Input == "Gnome") {
			System.out.println("Player1 ist der Gnome");
		}else if(p1Input == "Dragon"){
			System.out.println("Player1 ist der Dragon");
		}else {
			System.err.print("Falsche Eingabe");
		}
		sc.close();
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println();
		
	}
	
	

}
