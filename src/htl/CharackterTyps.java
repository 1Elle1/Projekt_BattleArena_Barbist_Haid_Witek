package htl;

public abstract class CharackterTyps {

	public String name;
	public int healthPoints;
	public boolean specialAbilityActive;
	
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
	
	
	public boolean activateSpecialSkill(boolean specialAbilityActive) {
		
	}
	
	public boolean deactivateSpecialSkill(boolean specialAbilityActive) {
		
	}
	
	
	
	

}
