package Models.Character;

public  abstract class Character {


    protected int minimalAttack;
    protected int maximalAttack;
    protected int level;
    protected int currentHealth;
    protected int maxHealth;
    protected int defense;
    protected double blockChance;
    protected String name;
    protected double criticalChance;
    protected CharacterClass character;

    public  Character(){};

    public int getMinimalAttack(){
        return this.minimalAttack;
    }

    abstract void setMinimalAttack();

    public int getMaximalAttack(){
        return this.maximalAttack;
    }

    abstract  void setMaximalAttack();

    public int getLevel(){
        return this.level;
    }

    abstract void setLevel(int level);

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public void setCurrentHealth(int health){
        if( health > this.getMaxHealth() ){
            health = this.getMaxHealth();
        }
        this.currentHealth = health;
    }

    public double getCriticalChance(){
        return this.criticalChance;
    }

    public void setCriticalChance(double criticalChance){
        this.criticalChance = criticalChance;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    abstract void setBlockChance();

    public double getBlockChance(){
        return this.blockChance;
    }

    abstract void setMaxHealth();

    abstract void setDefense();

    public int getDefence(){
        return this.defense;
    }

    public int getDamage(int damage){
        if( damage >= this.getCurrentHealth() ){
            this.setCurrentHealth( 0 );
        }
        else{
            this.setCurrentHealth( this.getCurrentHealth() - damage );
        }
        return this.getCurrentHealth();

    }

    abstract void chooseClass();

    public String getName(){
        return this.name;
    }

    abstract void setName();

  /*  public int useSpecialAttack(){
        //later
    } */

    public Profession getProf(){
        return this.character.getProf();
    }


}
