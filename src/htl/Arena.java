package htl;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Arena{
	
	static CharackterTyps p1;
	static CharackterTyps p2;
	
	Scanner sc = new Scanner(System.in);
	
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
			System.out.println("Player 1, du f‰ngst an!");
			this.setBeginner(1);;
		}else {
			System.out.println("Player 2, du f‰ngst an!");
			this.setBeginner(2);
		}
	}
	
	public void playerSelection() {
		int temp = 0;
		boolean validInput = false;
		
		while(!validInput) {
		System.out.println("Zurzeit stehen 'Gnome' und 'Dragon' als Charaktere zur Verf¸gung!");
		System.out.println();
		System.out.println("Welche Charakter mˆchten sie spielen Player1:");
		String p1InputCharakter = sc.nextLine();
		
		if((!p1InputCharakter.equalsIgnoreCase("Gnome")) && (!p1InputCharakter.equalsIgnoreCase("Dragon"))) {
			System.out.println("Falsche Eingabe, bitte Dragon oder Gnome eingeben!");
		}else {
			System.out.println("Wie soll der " + p1InputCharakter + " heiﬂen?");
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
		
		
	}
	
	
	
	
	public void simulateCombat(CharackterTyps attacker, CharackterTyps victim) {
		if(p1.isWinnerOfTheGame() || p2.isWinnerOfTheGame() || attacker.getHealthPoints() <= 0 || victim.getHealthPoints() <= 0) {
			return;
		}
		System.out.println();
		System.out.println("Du bist am zug " + attacker.getName() + " du hast noch " + attacker.getHealthPoints() +  " Leben, was mˆchtest du machen? Tippe 1,2 oder 3");
		System.out.println("Dein Gegner hat noch " + victim.getHealthPoints() + " Leben");
		attacker.outputOfTheAbilities();
		int attackerInput = sc.nextInt();
		
		
		switch (attackerInput) {
			case 1: 
				if(victim.getHealthPoints() > attacker.calculateAttackValue()) {
					attacker.attack(victim);
					System.out.println("Du hast " + victim.getName() + " angegriffen! Er hat noch " + victim.getHealthPoints() + " Leben");
				}else {
					System.out.println(victim.getName() +" Du hast Verloren " + "\n"
							+ attacker.getName() + " du hast Gewonnen!");
					attacker.setWinnerOfTheGame(true);
					System.out.println(
						    "       __________\n" +
						    "      '._==_==_=_.'\n" +
						    "      .-\\:      /-.\n" +
						    "     | (|:     |) |\n" +
						    "      '-|:     |-'\n" +
						    "        \\:.    /\n" +
						    "         \\:  . /\n" +
						    "          \\:  /\n" +
						    "           \\/\n" +
						    "         _.' '._\n" +
						    "        `\"\"\"\"\"\"\"`\n"+
						    "          "+ attacker.getName()
						    
						);


				}
				break;
			case 2:
				if(!attacker.isSpecialAbilityActive()) {
					attacker.activateSpecialSkill();
					if(attacker.isSpecialAbilityActive()) {
						System.out.println(attacker.getName()+ " hat die Spezialf‰higkeit aktiviert!");
					}
					
				}else {
					System.out.println("Die Spezialf‰higkeit wurde wurde schon aktiviert!");
					simulateCombat(attacker, victim);
				}
				
				break;
			case 3: 
				if(attacker.isSpecialAbilityActive()) {
					attacker.deactivateSpecialSkill();
					System.out.println(attacker.getName() + " deine Spezialf‰higkeit wurde deaktiviert!");
				}else {
					System.out.println("Die Spezialf‰higkeit ist nicht aktiviert!");
					simulateCombat(attacker, victim);
				}
				break;
			
			
		}
		
	}
	
	public void fight() {
		
		 playerSelection();
		 pickBeginner();
		 
		 switch (this.getBeginner()) {
		 case 1:
			 while(!p1.isWinnerOfTheGame() || !p2.isWinnerOfTheGame()) {
				 simulateCombat(p1, p2);
				 simulateCombat(p2, p1);
			 }
			 
			 break;
		 case 2: 
			 while(!p1.isWinnerOfTheGame() || !p2.isWinnerOfTheGame()) {
				 simulateCombat(p2, p1);
				 simulateCombat(p1, p2);
			 }
		     break;
		 }
		 
	}
		
			 
			 
			
	
	
	

}
