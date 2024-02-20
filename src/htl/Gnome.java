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
				+ ", name=" + name + ", healthPoints=" + healthPoints + ", specialAbilityActive=" + specialAbilityActive
				+ "]";
	}


	
	
	public boolean dwarfHeadNut() {
		if(this.specialAbilityActive && this.healthPoints < 50) {
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
			return 30;
		}else if(numberOfRandomNumber >= 1 && numberOfRandomNumber <=5) {
			return 50;
		}else if(numberOfRandomNumber >= 1 && numberOfRandomNumber <=7){
			return 70;
		}
		return 0;
	}

}
