package htl;

import java.util.concurrent.ThreadLocalRandom;

public class Gnome extends CharackterTyps{
	
	private int attackValue;
	

	public Gnome(String name) {
		super(name);
		this.attackValue = calculateAttackValue();
		
	}
	

	public int getAttackValue() {
		return attackValue;
	}


	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}

	
	@Override
	public String toString() {
		return "Gnome [attackValue=" + attackValue + ", name=" + this.getName() + ", healthPoints=" 
				+ this.getHealthPoints() + ", specialAbilityActive=" + this.isSpecialAbilityActive()
				+ "]";
	}


	/**
	 * Calculates and sets the attack value for the gnome character. 
	 * The attack value is determined by generating a random integer 
	 * between 15 and 25 (inclusive).
	 */
	public int calculateAttackValue() {
		return ThreadLocalRandom.current().nextInt(15, 25 + 1);
	}
	
	
	public void activateSpecialSkill() {
	    if (this.getHealthPoints() < 50) {
	        super.activateSpecialSkill();
	    } else {
	        System.out.println("Die Spezialf�higkeit des Gnoms kann nicht aktiviert werden, da die Lebenspunkte 50 oder mehr betragen.");
	        this.setSpecialAbilityActive(false);
	    }
	}
	
	
	
	/**
	 * Executes the DwarfHeadNutt special ability. If active and successful, 
	 * doubles the gnome's attack value for this attack, otherwise, halves it for this round.
	 * Prints the outcome message.
	 * 
	 * @return true if the ability was successfully activated, false otherwise.
	 */
	public boolean dwarfHeadNut() {
		
		if (this.getHealthPoints() > 50) {
	        System.out.println("Du hast zu viele Lebenspunkte, um die Zwergenkopfnuss zu aktivieren!");
	        return false;
	    }
		
		if (!this.isSpecialAbilityActive()) {
			
	        return false;
	    }
		
		
		
		if(this.isSpecialAbilitySuccessful()) {
			
			System.out.println("Die Zwergenkopfnuss war erfolgreich, du machst jetzt in dieser Runde doppelt so viel schaden!");
			return true;
		}else {
			
			System.out.println("Die Zwergenkopfnuss hat nicht Funktioniert du machst diese Runde nur halb soviel Schaden");
			return false;
		}
	}
	
	
	/**
	 * Determines if the special ability activation is successful based on the gnome's current health and a percentage.
	 * Success criteria vary by health: below 10 HP has the highest chance, below 20 HP has a moderate chance,
	 * and below 50 HP has the lowest chance of activation success.
	 *
	 * @return true if the special ability activation is successful, false otherwise.
	 */
	 private boolean isSpecialAbilitySuccessful() {
	    int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(0, 10 + 1);
	    
	    if (this.getHealthPoints() <= 50 && numberOfRandomNumber <= 3) {
	       return true;
	    } else if (this.getHealthPoints() <= 20 && numberOfRandomNumber <= 5) {
	        return true;
	    } else if (this.getHealthPoints() <= 10 && numberOfRandomNumber <= 7) {
	        return true;
	    }
	    return false;
	    }
	 

	public void attack(CharackterTyps enemy) {
		
		if (enemy.getHealthPoints() <= 0) {
	        System.out.println(enemy.getName() + " ist bereits gestorben und kann nicht angegriffen werden.");
	        return;
	    }
		
		int temporaryAttackValue = this.getAttackValue();
		
		if(this.isSpecialAbilityActive()) {
			boolean success = dwarfHeadNut();
			temporaryAttackValue = success ? temporaryAttackValue *2 : temporaryAttackValue /2;
			System.out.println("Du hast in dieser Runde mit der Spezialf�higkeit " + temporaryAttackValue + " Schaden gemacht!");
		}
		
		enemy.getDamage(temporaryAttackValue);
			
		if (enemy.getHealthPoints() <= 0) {
	        System.out.println("Spieler: " + enemy.getName() + " ist gestorben!");
	        this.setWinnerOfTheGame(true);
	    }
				
	}
	
	
	
	public void outputOfTheAbilities() {
		System.out.println("1. Angreifen \n"
						 + "2. Zergenkopfnuss aktivieren \n"
						 + "3. Zwergenkopfnuss deaktivieren");
	}
	
	
	
	
}
 