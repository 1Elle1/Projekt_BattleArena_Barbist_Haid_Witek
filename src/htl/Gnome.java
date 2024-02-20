package htl;

import java.util.concurrent.ThreadLocalRandom;

public class Gnome extends CharackterTyps{
	
	private int attackValue;
	private int specialAbilityProbability;
	

	public Gnome(String name, boolean specialAbilityActive) {
		super(name, specialAbilityActive);
		
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


	
	
	public boolean dwarfHeadNut() {
		if(this.isSpecialAbilityActive() && this.getHealthPoints() <= 50 && this.calculateChanceOfSpecialAbility() == 3) {
			return true;
		}else if(this.isSpecialAbilityActive() && this.getHealthPoints() <= 20 && this.calculateChanceOfSpecialAbility() == 5) {
			return true;
		}else if(this.isSpecialAbilityActive() && this.getHealthPoints() <= 10 && this.calculateChanceOfSpecialAbility() == 7) {
			return true;
		}
		return false;
	}
	
	public void calculateAttackValue() {
		this.attackValue = ThreadLocalRandom.current().nextInt(15, 25 + 1);
	}
	
	
	public int calculateChanceOfSpecialAbility() {
		int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(0, 10 + 1);
		if(numberOfRandomNumber >= 1 && numberOfRandomNumber <=3) {
			return 3;
		}else if(numberOfRandomNumber >= 3 && numberOfRandomNumber <=5) {
			return 5;
		}else if(numberOfRandomNumber >= 5 && numberOfRandomNumber <=7){
			return 7;
		}
		return 10;
	}

}
