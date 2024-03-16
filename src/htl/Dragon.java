/**
 * The Dragon class represents a type of character in the game. 
 * It extends the CharackterTyps class and provides specific functionalities and attributes for dragons.
 */
package htl;

import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends CharackterTyps {

    private int attackValue; // Stores the attack value of the dragon.
    private int specialAbilityProbability; // Stores the probability of the dragon's special ability being activated.
    private int healthpointsDragon; // Stores the health points of the dragon.

    /**
     * Constructor for the Dragon class.
     * 
     * @param name The name of the dragon.
     */
    public Dragon(String name) {
        super(name);
    }

    /**
     * Retrieves the health points of the dragon.
     * 
     * @return The health points of the dragon.
     */
    public int getHealthpointsDragon() {
        return healthpointsDragon;
    }

    /**
     * Sets the health points of the dragon.
     * 
     * @param healthpointsDragon The health points to set.
     */
    public void setHealthpointsDragon(int healthpointsDragon) {
        this.healthpointsDragon = healthpointsDragon;
    }

    /**
     * Retrieves the attack value of the dragon.
     * 
     * @return The attack value of the dragon.
     */
    public int getAttackValue() {
        return attackValue;
    }

    /**
     * Sets the attack value of the dragon.
     * 
     * @param attackValue The attack value to set.
     */
    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    /**
     * Retrieves the probability of the dragon's special ability being activated.
     * 
     * @return The probability of the dragon's special ability being activated.
     */
    public int getSpecialAbilityProbability() {
        return specialAbilityProbability;
    }

    /**
     * Sets the probability of the dragon's special ability being activated.
     * 
     * @param specialAbilityProbability The probability to set.
     */
    public void setSpecialAbilityProbability(int specialAbilityProbability) {
        this.specialAbilityProbability = specialAbilityProbability;
    }

    /**
     * Overrides the toString method to provide a string representation of the Dragon object.
     * 
     * @return A string representation of the Dragon object.
     */
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
        if (enemy.getHealthPoints() > 0) {
            enemy.getDamage(attackValue);
        } else {
            System.out.println("Spieler: " + enemy.getName() + " ist gestorben!");
        }
    }
    
    public void outputOfTheAbilities() {
		System.out.println("1. Angreifen \n"
						 + "2. Fliegen aktivieren \n"
						 + "3. Fliegen deaktivieren");
	}
	
    
    
}