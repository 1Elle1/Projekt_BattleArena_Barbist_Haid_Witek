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


	public void calculateAttackValue() {
		this.attackValue = ThreadLocalRandom.current().nextInt(15, 25 + 1);
	}
	
	public boolean dwarfHeadNut() {
		
		if (!this.isSpecialAbilityActive()) {
	        return false;
	    }
		
		int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(0, 10 + 1);
		System.out.println(numberOfRandomNumber);
		
		if(this.getHealthPoints() <= 10 && numberOfRandomNumber <= 7) {
			return true;
		}else if(this.getHealthPoints() <= 20 && numberOfRandomNumber <= 5){
			return true;
		}else if(this.getHealthPoints() <= 50 && numberOfRandomNumber <= 3){
			return true;
		}
		return false;
		
		
	}
	
	public void doubleTheDamage() {
		if(this.isSpecialAbilityActive() == true && this.dwarfHeadNut() == true) {
			this.attackValue *= 2;
		}
	}
	
	public void halveTheDamage() {
		if(this.isSpecialAbilityActive() == true && this.dwarfHeadNut() == true) {
			this.attackValue *= 2;
		}
	}
	
	
	
	

	
	
}
