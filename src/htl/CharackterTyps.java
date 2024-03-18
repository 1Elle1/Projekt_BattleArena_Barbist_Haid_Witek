package htl;


public abstract class CharackterTyps extends Arena {


    private String name;
   
    private int healthPoints;
 
    private boolean specialAbilityActive;
    
    private boolean winnerOfTheGame;
    
 
   
    public CharackterTyps(String name) {
        super();
        this.name = name;
        this.healthPoints = 100;
        this.specialAbilityActive = false;
        this.winnerOfTheGame = false;
    }

   
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public abstract int calculateAttackValue();
   
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
    

    public boolean isWinnerOfTheGame() {
		return winnerOfTheGame;
	}


	public void setWinnerOfTheGame(boolean winnerOfTheGame) {
		this.winnerOfTheGame = winnerOfTheGame;
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
    public  void getDamage(int points) {
    	 this.healthPoints -= points;
    	 if (this.healthPoints < 0) {
    	        this.healthPoints = 0;
    	}
    	
    }
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
    
    public abstract void outputOfTheAbilities();
    

}
