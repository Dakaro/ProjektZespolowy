package Models.Character;

import javafx.beans.property.*;

import java.util.concurrent.ThreadLocalRandom;

import static Others.Names.chance;
import static Others.Names.dodge;

public  abstract class Character {
    int defaultHealth = 50;
    double defaultCriticalChance = 3.;
    int defaultAttackMin = 2;
    int defaultAttackMax = 5;
    int counterAttackMin = 2;
    int counterAttackMax = 3;
    int defaultMonsterDefense = 3;
    double defaultMonsterCriticalChance = 15.;
    int defaultHealthMonster = 80;
    int defaultAttackMonsterMin = 20;
    int defaultAttackMonsterMax = 50;

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

    public IntegerProperty minimalAttackProp = new SimpleIntegerProperty();
    public IntegerProperty maximalAttackProp = new SimpleIntegerProperty();
    public IntegerProperty levelProp = new SimpleIntegerProperty();
    public IntegerProperty currentHealthProp = new SimpleIntegerProperty();
    public IntegerProperty maxHealthProp = new SimpleIntegerProperty();
    public IntegerProperty defenseProp = new SimpleIntegerProperty();
    public DoubleProperty blockChanceProp = new SimpleDoubleProperty();
    public DoubleProperty criticalChanceProp = new SimpleDoubleProperty();
    public StringProperty nameProp = new SimpleStringProperty();
    public StringProperty profProp = new SimpleStringProperty();

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

    public void setCurrentHealth(double health){
        if( health > this.getMaxHealth() ){
            health = this.getMaxHealth();
        }
        this.currentHealth = (int) health;
        this.currentHealthProp.setValue(this.currentHealth);
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

    abstract void setMaxHealth(int i);

    abstract void setDefense(int i);

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

   public int useSpecialAttack(){
       if (chance() <= this.getCriticalChance())
       {
           return 2;
       }
       return 1;
    }

    public Profession getProf(){
        return this.character.getProf();
    }

    String useSpecialEffect(Character opponent){
       String fightStatus = "";
        if (this.character.getProf() == Profession.MAGE || opponent.character.getProf() == Profession.MAGE)
        {
            return  " ";
        }
        if (opponent.character.getProf() == Profession.SCOUT)
        {
            if ( ThreadLocalRandom.current().nextInt(1, 100) <= dodge)
            {
                fightStatus = fightStatus + "\n" + opponent.getName() + " dodged the hit from " + this.getName();
                return  fightStatus;
            }
            return " ";
        }
        if (opponent.character.getProf() == Profession.WARRIOR)
        {
            if ( ThreadLocalRandom.current().nextInt(1, 100) <= opponent.getBlockChance())
            {
                fightStatus =  "\n" + opponent.getName() + " blocked the hit from " + this.getName();
                return fightStatus;
            }
            return " ";
        }
        return " ";
    }


    String attackOpponent(Character opponent, String status){
       String fightStatus = "";
       fightStatus =  this.useSpecialEffect(opponent);
        if ( !fightStatus.equals(" ") )
        {
            return fightStatus;
        }
        int damage = ThreadLocalRandom.current().nextInt(this.getMinimalAttack(), this.getMaximalAttack());
        damage = damage * this.useSpecialAttack() - opponent.getDefence();
        if (damage < 1)
            damage = 1;

        opponent.getDamage(damage);

        fightStatus = "\n" + this.getName() + " dealt " + damage + " damage to " + opponent.getName();

        return fightStatus;
    }

}
