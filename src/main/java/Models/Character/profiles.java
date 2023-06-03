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