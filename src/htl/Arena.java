package htl;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Arena{
	
	
	CharackterTyps p1;
	CharackterTyps p2;
	
	public static int pickBeginner() {
		int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if(numberOfRandomNumber == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public void playerSelection() {
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welche Charakter mˆchten sie spielen bitte geben sie den namen in die Komandozeile Player1:");
		String p1InputCharakter = sc.nextLine();
		System.out.println("Wie soll der " + p1InputCharakter + " heiﬂen?");
		String p1InputName = sc.nextLine();
		if(p1InputCharakter.equals("Gnome")) {
			p1 = new Gnome(p1InputName);
			System.out.println("Player1 ist der Gnome names: " + p1InputName);
			temp = 1;
		}else if(p1InputCharakter.equals("Dragon")) {
			p1 = new Dragon(p1InputName);
			System.out.println("Player1 ist der Dragon names: " + p1InputName);
			temp = 2;
		}else {
			System.out.println("Falsche Eingabe!");
		}
		
		if(temp == 1) {
			System.out.println("Player2 du bist der Drache, wie soll er heiﬂen?");
			String p2Inputname = sc.nextLine();
			p2 = new Dragon(p2Inputname);
			System.out.println("Player2 dein Drache heiﬂt: " + p2Inputname);
		}else if(temp == 2) {
			System.out.println("Player2 du bist der Gnome, wie soll er heiﬂen?");
			String p2Inputname = sc.nextLine();
			p2 = new Gnome(p2Inputname);
			System.out.println("Player2 dein Gnome heiﬂt: " + p2Inputname);
		}
		
		
		sc.close();
	}
	
	
	
	
	public static void main(String[] args) {
		 Arena arena = new Arena();
		 arena.playerSelection();   
		
		
	}
	
	

}
