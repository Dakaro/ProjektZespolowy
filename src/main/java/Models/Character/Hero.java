package Models.Character;

import Others.Equipment;
import Others.Item;
import Others.ItemType;

import java.util.List;

public class Hero extends Character {
    public Hero getInstance() {
        return this;
    }

    void showStatistics() {
        int mainStat = this.EQ.weapon_slot.getMainStat() + this.EQ.headgear_slot.getMainStat() + this.character.getMainStat() + this.EQ.talisman_slot.getMainStat();
        if (this.getProf() != null) {
            /// do wyswietlenia
            // TODO
                /*view.ShowStatistics(this.getName(), this.Class.getProfName(), this.Class.getmainStatName(),
                    this.character.getspecialAbility(), this.getlevel(), mainStat, this.getmaxHealth(),
                    this.getcurrentHealth(), this.getminimalAttack(), this.getmaximalAttack(),
                    this.getcriticalChance(), this.getdefense(), this.getMoney(), this.getBlockChance());

                 */
        } else {

        }

    }

    void showEQ() {
        // show eq
    }

    void showOneItem(ItemType it, Profession p) {
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
        } else if (it == ItemType.TALISMAN) {
            type = "talisman";
            name = this.EQ.talisman_slot.getName();
            val1 = this.EQ.talisman_slot.getMainStat();
            val2 = (int) this.EQ.talisman_slot.getCriticalChance();
            mainStat = this.EQ.talisman_slot.getMainStatName();
            value = this.EQ.talisman_slot.getValue();
        } else if (it == ItemType.SHIELD) {
            type = "shield";
            name = this.EQ.shield_slot.getName();
            val1 = this.EQ.shield_slot.getDefense();
            val2 = (int) this.EQ.shield_slot.getBlockChance();
            value = this.EQ.shield_slot.getValue();
        } else if (it == ItemType.ARMOR) {
            type = "armor";
            name = this.EQ.armor_slot.getName();
            val1 = this.EQ.armor_slot.getDefense();
            val2 = this.EQ.armor_slot.getHealth();
            value = this.EQ.armor_slot.getValue();
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
        }

        String proff;
        if (p == Profession.WARRIOR)
            proff = "Warrior";
        else if (p == Profession.SCOUT)
            proff = "Scout";
        else if (p == Profession.MAGE)
            proff = "Mage";
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
    }

    public void setMaxHealth(int h) {
        this.maxHealth = (this.getLevel() * defaultHealth + h) * this.character.getVitalityModifier();
    }

    public void setDefense(int d) {
        if (this.character.getProf() == Profession.WARRIOR) {
            d += this.EQ.shield_slot.getDefense();
        }
        this.defense = d * this.character.getDefenseModifier();
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
    }

    public void setLevel(int s) {
        this.level = s;
    }

    public void setMinimalAttack(int s) {
        this.minimalAttack = (s + defaultAttackMin * this.getLevel()) * this.character.getAttackModifier();
    }

    public void setMaximalAttack(int s) {
        this.maximalAttack = (s + defaultAttackMax * this.getLevel()) * this.character.getAttackModifier();
    }

    public void setAttack(int ms, int weaponMin, int weaponMax) {
        this.setMinimalAttack(ms + weaponMin * counterAttackMin);
        this.setMaximalAttack(ms + weaponMax * counterAttackMax);
    }

    public void setName(String n) {
        this.name = n;
    }

    public void levelup() {
        this.level += 1;
        this.setAllStats();
        this.setCurrentHealth(this.getCurrentHealth() + this.getMaxHealth() * 0.3);
    }

    public void setBlockChance() {
        if (this.character.getProf() == Profession.WARRIOR) {
            this.blockChance = this.EQ.shield_slot.getBlockChance();
        } else {
            this.blockChance = 0;
        }
    }

    public void setMoney(int m) {
        this.money = m;
    }

    public int getMoney() {
        return this.money;
    }

    public void ChangeEQ(Item i) {
        this.EQ.ChangeItem(i);
        this.setAllStats();
    }

    public boolean fight(Character opponent, boolean boss) {
        boolean whoIsAttacking = true;

        while (this.getCurrentHealth() != 0 && opponent.getCurrentHealth() != 0) {
            //view.BreakLine();
            if (whoIsAttacking) {
                this.attackOpponent(opponent);
            } else {
                Character h = this.getInstance();
                opponent.attackOpponent(h);
            }
            whoIsAttacking = !whoIsAttacking;
        }
        //view.BreakLine();
        return this.getCurrentHealth() != 0;
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
    public Equipment EQ;
}
