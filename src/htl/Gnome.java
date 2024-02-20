package htl;

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
	
	
	
	

}
