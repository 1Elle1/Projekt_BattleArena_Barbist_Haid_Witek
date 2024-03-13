package htl;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Arena{
	
	CharackterTyps p1;
	CharackterTyps p2;
	
	private int beginner;
	
	public int getBeginner() {
		return beginner;
	}

	public void setBeginner(int beginner) {
		this.beginner = beginner;
	}

	public void pickBeginner() {
		int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if(numberOfRandomNumber == 0) {
			System.out.println("Player 1, du f�ngst an!");
			this.setBeginner(1);;
		}else {
			System.out.println("Player 2, du f�ngst an!");
			this.setBeginner(2);
		}
	}
	
	public void playerSelection() {
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		boolean validInput = false;
		
		while(!validInput) {
		System.out.println("Zurzeit stehen 'Gnome' und 'Dragon' als Charaktere zur Verf�gung!");
		System.out.println();
		System.out.println("Welche Charakter m�chten sie spielen Player1:");
		String p1InputCharakter = sc.nextLine();
		
		if((!p1InputCharakter.equalsIgnoreCase("Gnome")) && (!p1InputCharakter.equalsIgnoreCase("Dragon"))) {
			System.out.println("Falsche Eingabe, bitte Dragon oder Gnome eingeben!");
		}else {
			System.out.println("Wie soll der " + p1InputCharakter + " hei�en?");
			String p1InputName = sc.nextLine();
			if(p1InputCharakter.equalsIgnoreCase("Gnome")) {
				p1 = new Gnome(p1InputName);
				System.out.println("Player1 ist der Gnome names: " + p1InputName);
				temp = 1;
			}else if(p1InputCharakter.equalsIgnoreCase("Dragon")) {
				p1 = new Dragon(p1InputName);
				System.out.println("Player1 ist der Dragon names: " + p1InputName);
				temp = 2;
			}else {
				System.out.println("Falsche Eingabe!");
			}
			validInput = true;
		}
		
	}
		
		if(temp == 1) {
			System.out.println("Player2 du bist der Drache, wie soll er hei�en?");
			String p2Inputname = sc.nextLine();
			p2 = new Dragon(p2Inputname);
			System.out.println("Player2 dein Drache hei�t: " + p2Inputname);
		}else if(temp == 2) {
			System.out.println("Player2 du bist der Gnome, wie soll er hei�en?");
			String p2Inputname = sc.nextLine();
			p2 = new Gnome(p2Inputname);
			System.out.println("Player2 dein Gnome hei�t: " + p2Inputname);
		}
		
		
		sc.close();
	}
	
	
	public void simulateCombat(CharackterTyps attacker, CharackterTyps victim) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Du bist am zug " + attacker.getName() + ", was m�chtest du machen? W�hle 1 oder 2");
		attacker.outputOfTheAbilities();
		int attackerInput = sc.nextInt();
		
		
		
		
	}
	
	public void fight() {
		int roundNumber = 0;
		boolean winnerOfTheGame = false;
		 pickBeginner();
		 while(!winnerOfTheGame) {
			 
		 }
	}
	
	
	
	
	
	public static void main(String[] args) {
		 Arena arena = new Arena();
		 arena.playerSelection();
		 
		 
		
		
	}
	
	

}
