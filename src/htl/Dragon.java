
package htl;

import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends CharackterTyps {

    private int attackValue; 
    private int specialAbilityProbability; 
    private int healthpointsDragon; 

    
    public Dragon(String name) {
        super(name);
        this.attackValue = calculateAttackValue();
    }

   
    public int getHealthpointsDragon() {
        return healthpointsDragon;
    }

   
    public void setHealthpointsDragon(int healthpointsDragon) {
        this.healthpointsDragon = healthpointsDragon;
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

        if (this.isSpecialAbilitySuccessful()) {
            this.healthpointsDragon += 10;
            System.out.println("Der Drache ist erfolgreich abgehoben und hat 10 zusätzliche Lebenspunkte.");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the dragon's special ability is successful.
     * 
     * @return True if the special ability is successful, otherwise false.
     */
    private boolean isSpecialAbilitySuccessful() {
        int numberOfRandomNumber = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        System.out.println(numberOfRandomNumber);

        return false;
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
			temporaryAttackValue = success ? getHealthPoints() + 10 :0;
			System.out.println("Du hast in dieser Runde mit der Spezialfaehigkeit " + temporaryAttackValue + " Schaden gemacht!");
		}
		
		enemy.getDamage(temporaryAttackValue);
		
		if (enemy.getHealthPoints() <= 0) { 
	        System.out.println("Spieler: " + enemy.getName() + " ist gestorben!");
	        
	    }
    	}
    
    
    public void outputOfTheAbilities() {
		System.out.println("1. Angreifen \n"
						 + "2. Fliegen aktivieren \n"
						 + "3. Fliegen deaktivieren");
	}
	
    
    
}