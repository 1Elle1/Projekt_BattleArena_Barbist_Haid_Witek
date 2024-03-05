package htl;

import java.util.Scanner;

/**
 * This abstract class represents a character type in an arena game.
 * It defines common attributes and methods for different character types.
 */
public abstract class CharackterTyps extends Arena {

    /**
     * The name of the character.
     */
    private String name;

    /**
     * The current health points of the character.
     */
    private int healthPoints;

    /**
     * Whether the character's special ability is currently active.
     */
    private boolean specialAbilityActive;

    /**
     * Creates a new character type with the given name.
     *
     * @param name The name of the character.
     */
    public CharackterTyps(String name) {
        super();
        this.name = name;
        this.healthPoints = 100;
        this.specialAbilityActive = false;
    }

    /**
     * Gets the name of the character.
     *
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the character.
     *
     * @param name The new name of the character.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current health points of the character.
     *
     * @return The current health points of the character.
     */
    public int getHealthPoints() {
        return healthPoints;
    }


    /**
     * Sets the current health points of the character.
     *
     * @param healthPoints The new health points of the character.
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Checks if the character's special ability is currently active.
     *
     * @return True if the special ability is active, false otherwise.
     */
    public boolean isSpecialAbilityActive() {
        return specialAbilityActive;
    }

    /**
     * Sets the active state of the character's special ability.
     *
     * @param specialAbilityActive True to activate the ability, false to deactivate.
     */
    public void setSpecialAbilityActive(boolean specialAbilityActive) {
        this.specialAbilityActive = specialAbilityActive;
    }

    /**
     * This method defines the attack behavior of the character on an enemy.
     * Specific implementation of attack functionality belongs to subclasses.
     *
     * @param enemy The target character to attack.
     */
    public abstract void attack(CharackterTyps enemy);

    /**
     * This method defines how the character takes damage.
     * Specific implementation of damage handling belongs to subclasses.
     *
     * @param points The amount of damage points to be taken.
     */
    public abstract void getDamage(int points);

    /**
     * Activates the character's special ability, if not already active.
     */
    public void activateSpecialSkill() {
        if (!this.specialAbilityActive) {
            this.specialAbilityActive = true;
        }
    }

    /**
     * Deactivates the character's special ability, if currently active.
     */
    public void deactivateSpecialSkill() {
        if (this.specialAbilityActive) {
            this.specialAbilityActive = false;
        }
    }

}
