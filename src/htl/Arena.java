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

	
	/**
	 * Randomly selects which player (1 or 2) will begin the game.
	 * This is determined by generating a random number (0 or 1).
	 * If the random number is 0, Player 1 begins; otherwise, Player 2 begins.
	 * The selected player is then set as the beginner using the {@code setBeginner} method.
	 */
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
	
	
	/**
	 * Initiates character selection for two players. Player1 chooses between 'Gnome' and 'Dragon'. 
	 * Player2 is automatically assigned the other character. Both players name their characters.
	 * The method ensures valid input and prompts for re-entry if necessary.
	 */
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
	
	
	
	/**
	 * Simulates a combat round between two characters.
	 * The method checks if either player has won or if either character is already defeated.
	 * If not, it displays current health and options for the attacking player: attack, activate special ability, or deactivate special ability.
	 * The attack option deals damage to the victim, and the game may end if the victim's health drops to 0 or below.
	 * Special ability options can only be activated or deactivated if not already in that state.
	 * This method manages combat logic and displays outcomes including a victory message for the winner.
	 *
	 * @param attacker The character initiating the attack this round.
	 * @param victim The character receiving the attack this round.
	 */

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
	
	
	/**
	 * Initiates the fighting sequence between two characters after selecting them and determining the first attacker.
	 * The fight continues in rounds, where each player gets a turn to attack, until one becomes the winner.
	 * The sequence alternates between the two players, starting with the determined beginner.
	 * The combat loop checks for a winner after each round to potentially end the fight.
	 */
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
