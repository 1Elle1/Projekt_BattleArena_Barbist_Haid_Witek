package htl;

import java.util.Scanner;

public abstract class CharackterTyps {

	private String name;
	private int healthPoints;
	private boolean specialAbilityActive;
	
	public CharackterTyps(String name, boolean specialAbilityActive) {
		super();
		this.name = name;
		this.healthPoints = 100;
		this.specialAbilityActive = specialAbilityActive;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public boolean isSpecialAbilityActive() {
		return specialAbilityActive;
	}
	public void setSpecialAbilityActive(boolean specialAbilityActive) {
		this.specialAbilityActive = specialAbilityActive;
	}
	
	
	
	public void attackEnemy(CharackterTyps enemy) { 
		
	}
	
	public void getDamage(int points) {
		
	}
	
	Scanner sc= new Scanner (System.in);
	
	int eingabe = sc.nextInt();
	
	
	public void activateSpecialSkill() {
		if(!this.specialAbilityActive) {
			this.specialAbilityActive = true;
		}
	}
	
	public void deactivateSpecialSkill() {
		if(this.specialAbilityActive) {
			this.specialAbilityActive = false;
		}
	}
	
	
	


}
