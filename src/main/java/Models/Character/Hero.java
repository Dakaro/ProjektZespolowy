package Models.Character;

import Others.Equipment;
import Others.Item;
import Others.ItemType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class Hero extends Character {

    public Hero getInstance() {
        return this;
    }

    public StringProperty weaponProp = new SimpleStringProperty();
    public StringProperty talismanProp = new SimpleStringProperty();
    public StringProperty shieldProp = new SimpleStringProperty();
    public StringProperty armorProp = new SimpleStringProperty();
    public StringProperty headgearProp = new SimpleStringProperty();

    String weaponInfo;
    String talismanInfo;
    String shieldInfo;
    String armorInfo;
    String headgearInfo;


    public String showOneItem(ItemType it, Profession p) {
        int val1 = 0, val2 = 0, val3 = 0;
        String mainStat = "";
        String name = "";
        String type = "";
        int value = 0;


        if (it == ItemType.WEAPON) {
            type = "weapon";
            name = this.EQ.weapon_slot.getName();
            val1 = this.EQ.weapon_slot.getMinDamage();
            val2 = this.EQ.weapon_slot.getMaxDamage();
            val3 = this.EQ.weapon_slot.getMainStat();
            mainStat = this.EQ.weapon_slot.getMainStatName();
            value = this.EQ.weapon_slot.getValue();
            weaponInfo = ( "type: " + type + "\n" +
                            "name: " + name + "\n" +
                            "value: " + value + "\n" +
                            "minDamage: " + val1 + "\n" +
                            "maxDamage: " + val2 + "\n" +
                            "mainStat: " + val3 + "\n" +
                            "mainStatName: " + mainStat + "\n" );
            return weaponInfo;
        } else if (it == ItemType.TALISMAN) {
            type = "talisman";
            name = this.EQ.talisman_slot.getName();
            val1 = this.EQ.talisman_slot.getMainStat();
            val2 = (int) this.EQ.talisman_slot.getCriticalChance();
            mainStat = this.EQ.talisman_slot.getMainStatName();
            value = this.EQ.talisman_slot.getValue();

            talismanInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "mainStat: " + val1 + "\n" +
                    "criticalChance: " + val2 + "\n" +
                    "mainStatName: " + mainStat + "\n" );
            return talismanInfo;
        } else if (it == ItemType.SHIELD) {
            type = "shield";
            name = this.EQ.shield_slot.getName();
            val1 = this.EQ.shield_slot.getDefense();
            val2 = (int) this.EQ.shield_slot.getBlockChance();
            value = this.EQ.shield_slot.getValue();

            shieldInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "defence: " + val1 + "\n" +
                    "blockChance: " + val2 + "\n" );
            return shieldInfo;
        } else if (it == ItemType.ARMOR) {
            type = "armor";
            name = this.EQ.armor_slot.getName();
            val1 = this.EQ.armor_slot.getDefense();
            val2 = this.EQ.armor_slot.getHealth();
            value = this.EQ.armor_slot.getValue();

            armorInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "defence: " + val1 + "\n" +
                    "health: " + val2 + "\n" );
            return armorInfo;

        } else if (it == ItemType.HEADGEAR) {
            type = "headgear";
            name = this.EQ.headgear_slot.getName();
            val1 = this.EQ.headgear_slot.getDefense();

            if (p == Profession.MAGE) {
                val2 = this.EQ.headgear_slot.getMainStat();
                mainStat = this.EQ.headgear_slot.getMainStatName();
            } else
                val2 = this.EQ.headgear_slot.getHealth();

            value = this.EQ.headgear_slot.getValue();

            headgearInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "defence: " + val1 + "\n");
            return headgearInfo;
        }

        return "error";
    }

    void setAllStats() {
        this.setMaxHealth(this.EQ.headgear_slot.getHealth() + this.EQ.armor_slot.getHealth());
        if (this.getCurrentHealth() > this.getMaxHealth()) {
            this.setCurrentHealth(this.getMaxHealth());
        }
        this.setCriticalChance(this.EQ.talisman_slot.getCriticalChance() + this.EQ.weapon_slot.getCriticalChance() + defaultCriticalChance * this.getLevel());
        this.setDefense(this.EQ.armor_slot.getDefense() + this.EQ.headgear_slot.getDefense());
        this.setAttack(this.EQ.weapon_slot.getMainStat() + this.EQ.headgear_slot.getMainStat() + this.character.getMainStat() + this.EQ.talisman_slot.getMainStat(), this.EQ.weapon_slot.getMinDamage(), this.EQ.weapon_slot.getMaxDamage());
        this.setBlockChance();
    }

    public void chooseClass(Profession ch) {
        if (ch == Profession.WARRIOR)
            this.character = new Warrior();
        else if (ch == Profession.SCOUT)
            this.character = new Scout();
        else
            this.character = new Mage();

        profProp.set( this.character.getProf().name() );
    }

    public void setMaxHealth(int h) {
        this.maxHealth = (this.getLevel() * defaultHealth + h) * this.character.getVitalityModifier();
        maxHealthProp.setValue(this.maxHealth);
    }

    public void setDefense(int d) {
        if (this.character.getProf() == Profession.WARRIOR) {
            d += this.EQ.shield_slot.getDefense();
        }
        this.defense = d * this.character.getDefenseModifier();
        defenseProp.setValue(this.defense);
    }

    @Override
    void chooseClass() {

    }

    @Override
    void setName() {

    }

    public void setCurrentHealth(int h, int maxHealth) {
        setCurrentHealth(h);
        if (this.getCurrentHealth() == 0) {
            this.Notify();
        }
        currentHealthProp.setValue(this.currentHealth);
    }

    public void setLevel(int s) {
        this.level = s;
        levelProp.setValue(s);
    }

    public void setMinimalAttack(int s) {
        this.minimalAttack = (s + defaultAttackMin * this.getLevel()) * this.character.getAttackModifier();
        minimalAttackProp.setValue(this.minimalAttack);
    }

    public void setMaximalAttack(int s) {
        this.maximalAttack = (s + defaultAttackMax * this.getLevel()) * this.character.getAttackModifier();
        maximalAttackProp.setValue(this.maximalAttack);
    }

    public void setAttack(int ms, int weaponMin, int weaponMax) {
        this.setMinimalAttack(ms + weaponMin * counterAttackMin);
        this.setMaximalAttack(ms + weaponMax * counterAttackMax);
    }

    public void setName(String n) {
        this.name = n;
        nameProp.set(this.name);
    }

    public void levelup() {
        setLevel(this.level + 1);
        this.setAllStats();
        this.setCurrentHealth(this.getCurrentHealth() + this.getMaxHealth() * 0.3);
    }

    public void setBlockChance() {
        if (this.character.getProf() == Profession.WARRIOR) {
            this.blockChance = this.EQ.shield_slot.getBlockChance();
        } else {
            this.blockChance = 0;
        }
        blockChanceProp.setValue(this.blockChance);
    }

    public void setMoney(int m) {
        this.money = m;
        moneyProp.setValue(this.money);
    }

    public int getMoney() {
        return this.money;
    }

    public void changeEQ(Item it) {
        this.EQ.ChangeItem(it);
        this.setAllStats();
        weaponProp.set( this.showOneItem(ItemType.WEAPON, this.getProf() ) );
        talismanProp.set( this.showOneItem(ItemType.TALISMAN, this.getProf() ) );
        shieldProp.set( this.showOneItem(ItemType.SHIELD, this.getProf() ) );
        headgearProp.set( this.showOneItem(ItemType.HEADGEAR, this.getProf() ) );
        armorProp.set( this.showOneItem(ItemType.ARMOR, this.getProf() ) );

    }

    public String fight(Character opponent, String status) {
        String fightStatus = status;
        boolean whoIsAttacking = true;

        while (this.getCurrentHealth() != 0 && opponent.getCurrentHealth() != 0) {
            if (whoIsAttacking) {

                String temp = this.attackOpponent(opponent, fightStatus);
                fightStatus = fightStatus + "\n" + temp ;
            } else {
                Character h = this.getInstance();
                String temp = opponent.attackOpponent(h, fightStatus);
                fightStatus = fightStatus + "\n" + temp ;
            }
            whoIsAttacking = !whoIsAttacking;
        }
        return fightStatus;
    }

    public void AddObserver(Observer o) {
        this.obs.add(o);
    }

    public void DeleteObserver(Observer o) {
        this.obs.remove(o);
    }


    public Hero() {
        this.chooseClass(Profession.WARRIOR);
        this.setLevel(1);
        this.setMoney(100);
        EQ = new Equipment(this.getLevel(), this.character.getProf());
        this.setAllStats();
        this.setCurrentHealth(this.getMaxHealth());

        weaponProp.set( this.showOneItem(ItemType.WEAPON, this.getProf() ) );
        talismanProp.set( this.showOneItem(ItemType.TALISMAN, this.getProf() ) );
        shieldProp.set( this.showOneItem(ItemType.SHIELD, this.getProf() ) );
        headgearProp.set( this.showOneItem(ItemType.HEADGEAR, this.getProf() ) );
        armorProp.set( this.showOneItem(ItemType.ARMOR, this.getProf() ) );

    }

    @Override
    void setMinimalAttack() {

    }

    @Override
    void setMaximalAttack() {

    }

    private void Notify() {
        obs.forEach(Observer::setTrue);
    }

    private List<Observer> obs;
    private static Hero hero;
    private int money;
    public IntegerProperty moneyProp = new SimpleIntegerProperty();
    public Equipment EQ;
}
