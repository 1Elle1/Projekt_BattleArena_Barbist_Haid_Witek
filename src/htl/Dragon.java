package htl;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends CharackterTyps{
	
	private int attackValue;
	private int specialAbilityProbability;
	

	public Dragon(String name, boolean specialAbilityActive) {
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

	
	

	
	
	public void DragonFlyOn() {
		activateSpecialSkill();
			}
	public void DragonFlyOff() {
		deactivateSpecialSkill();
			}
	
	public void calculateAttackValue() {
		this.attackValue = ThreadLocalRandom.current().nextInt(20, 25 + 1);
		
	
	}

}
