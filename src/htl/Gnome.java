package htl;

import java.util.concurrent.ThreadLocalRandom;

public class Gnome extends CharackterTyps{
	
	private int attackValue;
	

	public Gnome(String name) {
		super(name);
		
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
	public void calculateAttackValue() {
		this.setAttackValue(ThreadLocalRandom.current().nextInt(15, 25 + 1));
	}
	
	
	
	/**
	 * Executes the DwarfHeadNutt special ability. If active and successful, 
	 * doubles the gnome's attack value for this attack, otherwise, halves it for this round.
	 * Prints the outcome message.
	 * 
	 * @return true if the ability was successfully activated, false otherwise.
	 */
	public boolean dwarfHeadNut() {
		
		if (!this.isSpecialAbilityActive()) {
			
	        return false;
	    }
		
		if(this.isSpecialAbilitySuccessful()) {
			this.attackValue *= 2;
			System.out.println("Die Zwergenkopfnuss war erfolgreich, du machst jetzt in dieser Runde doppelt so viel schaden!");
			return true;
		}else {
			this.attackValue /= 2;
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
	    System.out.println(numberOfRandomNumber);
	        
	    if (this.getHealthPoints() <= 50 && numberOfRandomNumber <= 3) {
	       return true;
	    } else if (this.getHealthPoints() <= 20 && numberOfRandomNumber <= 5) {
	        return true;
	    } else if (this.getHealthPoints() <= 10 && numberOfRandomNumber <= 7) {
	        return true;
	    }
	    return false;
	    }
	 //dvduq

	public void attack(CharackterTyps enemy) {
		
		
		
	}
	public void getDamage(int points) {
		
		
	}
	
}
