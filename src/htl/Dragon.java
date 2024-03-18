
package htl;

import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends CharackterTyps {

    private int attackValue; 
    private int specialAbilityProbability; 
    private boolean onceAttack = true;
    private boolean wasSpecialAbilityActive = false;
 

    
    public Dragon(String name) {
        super(name);
        this.attackValue = calculateAttackValue();
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
        return "Dragon [attackValue=" + attackValue + ", specialAbilityProbability=" + specialAbilityProbability
                + ", name=" + this.getName() + ", healthPoints=" + this.getHealthPoints() + ", specialAbilityActive="
                + this.isSpecialAbilityActive() + "]";
    }

    /**
     * Calculates the attack value of the dragon.
     * @return 
     */
    public int calculateAttackValue() {
        return ThreadLocalRandom.current().nextInt(20, 25 + 1);
    }

    /**
     * Represents the dragon's ability to fly.
     * 
     * @return True if the dragon successfully flies, otherwise false.
     */
    public boolean fly() {
        if (!this.isSpecialAbilityActive()) {
            this.attackValue = ThreadLocalRandom.current().nextInt(5, 10 + 1);
            return false;
        }
        return true;
    }
       

    
  
    /**
     * Overrides the attack method to implement the dragon's attack behavior.
     * 
     * @param enemy The enemy character to attack.
     */
    @Override
    public void attack(CharackterTyps enemy) {
    	
    	
    	if (enemy.getHealthPoints() <= 0) {
	        System.out.println(enemy.getName() + " ist bereits gestorben und kann nicht angegriffen werden.");
	        return;
	    }
    	
    	int temporaryAttackValue = this.getAttackValue();
    	

		if(this.isSpecialAbilityActive()) {
			boolean success = fly(); 
			
			if(success) {
				int tmp = ThreadLocalRandom.current().nextInt(5, 10 + 1);
				
				if(!wasSpecialAbilityActive) {
					this.setHealthPoints(this.getHealthPoints()+10);
					onceAttack = false;
				}
				
					
					temporaryAttackValue -= tmp;
					
			       
			        System.out.println("Du hast in dieser Runde mit der Spezialfaehigkeit 10 Leben hinzubekommen und machst nun " + tmp + " schaden weniger ");
			        System.out.println("In dieser Runde hast du " + temporaryAttackValue + " Schaden gemacht");
			    }  else {
			      System.out.println("Der Drache ist nicht abgehoben");
			    }
			
		}else {
			onceAttack = true;
		}
		
		wasSpecialAbilityActive = this.isSpecialAbilityActive();
		
		enemy.getDamage(temporaryAttackValue);
		
		if (enemy.getHealthPoints() <= 0) { 
	        System.out.println("Spieler: " + enemy.getName() + " ist gestorben!");
	        this.setWinnerOfTheGame(true);
	    }
    	}
    
    
    public void outputOfTheAbilities() {
		System.out.println("1. Angreifen \n"
						 + "2. Fliegen aktivieren \n"
						 + "3. Fliegen deaktivieren");
	}
	
    
    
}