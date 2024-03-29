package htl;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Arena{
	
	CharackterTyps p1;
	CharackterTyps p2;
	
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
			System.out.println("Player 1, du fängst an!");
			this.setBeginner(1);;
		}else {
			System.out.println("Player 2, du fängst an!");
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
		System.out.println("Zurzeit stehen 'Gnome' und 'Dragon' als Charaktere zur Verfügung!");
		System.out.println();
		System.out.println("Welche Charakter möchten sie spielen Player1:");
		String p1InputCharakter = sc.nextLine();
		
		if((!p1InputCharakter.equalsIgnoreCase("Gnome")) && (!p1InputCharakter.equalsIgnoreCase("Dragon"))) {
			System.out.println("Falsche Eingabe, bitte Dragon oder Gnome eingeben!");
		}else {
			System.out.println("Wie soll der " + p1InputCharakter + " heißen?");
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
			System.out.println("Player2 du bist der Drache, wie soll er heißen?");
			String p2Inputname = sc.nextLine();
			p2 = new Dragon(p2Inputname);
			System.out.println("Player2 dein Drache heißt: " + p2Inputname);
		}else if(temp == 2) {
			System.out.println("Player2 du bist der Gnome, wie soll er heißen?");
			String p2Inputname = sc.nextLine();
			p2 = new Gnome(p2Inputname);
			System.out.println("Player2 dein Gnome heißt: " + p2Inputname);
		}
		
		
	}
	
	
	
	/**
	 * Prints the current stats for the attacker and the victim, including health points and the status of the attacker's special ability.
	 * It also prompts the user for their next action.
	 *
	 * @param attacker The character currently taking action.
	 * @param victim The target character.
	 */
	public void printStats(CharackterTyps attacker, CharackterTyps victim) {
		System.out.println("Du bist am Zug " + attacker.getName() +"\n"
						+ "Du hast " + attacker.getHealthPoints() +  " Leben");
		if(attacker.isSpecialAbilityActive()) {
			System.out.println("Deine Spezielfähigkeit ist Aktiv");
		}else {
			System.out.println("Deine Spezielfähigkeit ist nicht Aktiv");
		}
		System.out.println("Dein Gegner hat noch " + victim.getHealthPoints() + " Leben \n");
		System.out.println("Wie möchtest du fortfahren? Tippe 1,2 oder 3");
	
	}
	
	
	
	/**
	 * Announces the game's outcome by declaring the winner and the loser, and marks the attacker as the winner.
	 * It prints a congratulatory message and a simple ASCII trophy graphic with the winner's name.
	 *
	 * @param attacker The character who won the game.
	 * @param victim The character who lost the game.
	 */
	public void printWinnerAndLooser(CharackterTyps attacker, CharackterTyps victim) {
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
		printStats(attacker, victim);
		attacker.outputOfTheAbilities();
		int attackerInput = sc.nextInt();
		
		
		switch (attackerInput) {
			case 1: 
				if(victim.getHealthPoints() > attacker.calculateAttackValue()) {
					attacker.attack(victim);
					System.out.println("Du hast " + victim.getName() + " angegriffen! Er hat noch " + victim.getHealthPoints() + " Leben");
				}else {
					printWinnerAndLooser(attacker, victim);


				}
				break;
			case 2:
				if(!attacker.isSpecialAbilityActive()) {
					attacker.activateSpecialSkill();
					if(attacker.isSpecialAbilityActive()) {
						System.out.println(attacker.getName()+ " hat die Spezialfähigkeit aktiviert!");
					}
					
				}else {
					System.out.println("Die Spezialfähigkeit wurde wurde schon aktiviert!");
					simulateCombat(attacker, victim);
				}
				
				break;
			case 3: 
				if(attacker.isSpecialAbilityActive()) {
					attacker.deactivateSpecialSkill();
					System.out.println(attacker.getName() + " deine Spezialfähigkeit wurde deaktiviert!");
				}else {
					System.out.println("Die Spezialfähigkeit ist nicht aktiviert!");
					simulateCombat(attacker, victim);
				}
				break;
				
				default:
				System.out.println("Fehlerhafte eingabe, nochmal eingeben!");
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
