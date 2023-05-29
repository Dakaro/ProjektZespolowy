package Models.Character;


import Others.Equipment;
import Others.Item;
import Others.ItemType;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static Others.Names.*;

class Scout extends  CharacterClass {

    public Scout(){
        this.setAttackModifier(2);
        this.setDefenseModifier(2);
        this.setVitalityModifier(2);
        this.setProf(Profession.SCOUT );
        this.setMainStat(10);
        this.setSpecialAbility("You have 33 percent chance to dodge your opponent's attack");
        this.setMainStatName("Agility");
    }

}

class Mage extends CharacterClass {
    public Mage(){
        this.setAttackModifier(4);
        this.setDefenseModifier(1);
        this.setVitalityModifier(1);
        this.setProf(Profession.MAGE);
        this.setMainStat(20);
        this.setSpecialAbility("Opponent is not able to block your attack's attack");
        this.setMainStatName("Intelligence");
    }
}

class Warrior extends CharacterClass {
    public Warrior() {
        this.setAttackModifier(1);
        this.setDefenseModifier(4);
        this.setVitalityModifier(4);
        this.setProf(Profession.WARRIOR);
        this.setMainStat(5);
        this.setSpecialAbility("You have shield, which is able to block your opponent's attacks");
        this.setMainStatName("Strength");
    }
}

class Monster extends Character {
 public Monster(int level, boolean p){
     setALL(level);
     this.setName(p);
 }

 public void chooseClass(){
     int p = ThreadLocalRandom.current().nextInt(1, 4);

     switch (p) {
         case 1 -> this.character = new Warrior();
         case 2 -> this.character = new Scout();
         case 3 -> this.character = new Mage();
     }
 }

    @Override
    void setName() {

    }

    public void setMaxHealth(){
     this.defense = defaultHealthMonster * this.getLevel() * this.character.getVitalityModifier();
     this.setCurrentHealth(this.maxHealth);
 }

 public void setDefense(){
     this.defense = defaultMonsterDefense * this.getLevel() * this.character.getDefenseModifier();
 }

 public void setLevel(int level){
     this.level = level;
 }

 public void setMinimalAttack(){
     this.minimalAttack = defaultAttackMonsterMin * this.getLevel() * this.character.getAttackModifier();
 }

 public void setMaximalAttack(){
     this.maximalAttack = defaultAttackMonsterMax * this.getLevel() * this.character.getAttackModifier();
 }

 public void setName(boolean p){
     if (!p)
     {
         int r = ThreadLocalRandom.current().nextInt(1, sizeNamesForMonsters);
         this.name = namesForMonsters[r];
     }
     else
     {
         int r =ThreadLocalRandom.current().nextInt(1, sizeNamesForBosses);
         this.name = namesForBosses[r];
     }
 }
 public void setBlockChance(){
     if (this.character.getProf() == Profession.WARRIOR)
     {
         this.blockChance = 15.;
     }
	else
     {
         this.blockChance = 0.;
     }
 }

    @Override
    void setMaxHealth(int i) {
    }

    @Override
    void setDefense(int i) {
    }

    public void setALL(int level){
     this.chooseClass();
     this.setLevel(level);
     this.setMaxHealth();
     this.setDefense();
     this.setMinimalAttack();
     this.setMaximalAttack();
     this.setCriticalChance(defaultMonsterCriticalChance);
 }
}

;

class Observer {
    public void setTrue(){
        this.endik = true;
    }
    public boolean check(){
        if (this.getEndik())
        {
            //view.EndGameMessage();
            return true;
        }
	else
        return false;
    }

    public Observer(Hero hero){    }
    public void removeFromObserver(){
        this.h.DeleteObserver(this);
    }
    public void addToObserver(){
        this.h.AddObserver(this);
    }
    private boolean endik = false;
    private boolean getEndik(){
        return this.endik;
    }
    private Hero h;
};