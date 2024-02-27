package htl;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends CharackterTyps{
	
	private int attackValue;
	private int specialAbilityProbability;
	

	public Dragon(String name) {
		super(name);
		
	}
	
	public int getAttackValue() {
		return attackValue;
	}


	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}


	public int getSpecialAbilityProbability() {
		return specialAbilityProbability;
	}


	public void setSpecialAbilityProbability(int specialAbilityProbability) {
		this.specialAbilityProbability = specialAbilityProbability;
	}


	
	
	@Override
	public String toString() {
		return "Gnome [attackValue=" + attackValue + ", specialAbilityProbability=" + specialAbilityProbability
				+ ", name=" + this.getName() + ", healthPoints=" + this.getHealthPoints() + ", specialAbilityActive=" + this.isSpecialAbilityActive()
				+ "]";
	}

	
	

	
	
	public void DragonFlyOn() {
		activateSpecialSkill();
			}
	public void DragonFlyOff() {
		deactivateSpecialSkill();
			}
	
	public void calculateAttackValue() {
		this.attackValue = ThreadLocalRandom.current().nextInt(20, 25 + 1);
	}	
		
		
		public boolean fly() {
			
			if (!this.isSpecialAbilityActive()) {
				this.attackValue = ThreadLocalRandom.current().nextInt(5, 10 + 1);
				
		       
		    }
			 return false;
	
		
		if(this.isSpecialAbilitySuccessful()) {
			System.out.println("Die Zwergenkopfnuss war erfolgreich, du machst jetzt in dieser Runde doppelt so viel schaden!");
			return true;
		}else {
			return false;
		}
		
}
		private boolean isSpecialAbilitySuccessful() {
		    int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(5, 10 + 1);
		    System.out.println(numberOfRandomNumber);
		}
public  void attack(CharackterTyps enemy) {

}
	public  void getDamage(int points) {
	}
	}