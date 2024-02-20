package htl;

public abstract class CharackterTyps {

	public String name;
	public int healthPoints;
	public boolean specialAbilityActive;
	
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
	
	public CharackterTyps(String name, int healthPoints, boolean specialAbilityActive) {
		super();
		this.name = name;
		this.healthPoints = healthPoints;
		this.specialAbilityActive = specialAbilityActive;
	}
	
	public void attackEnemy(Enemy) { }
	
	
	

}
