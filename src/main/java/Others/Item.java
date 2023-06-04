package Others;

import Models.Character.Profession;

import java.util.concurrent.ThreadLocalRandom;

import static Others.Names.*;


public class Item {
    protected int item_ID;
    protected int value;
    protected String name;
    protected ItemType type;

    public Item(int level) {
        item_ID = ThreadLocalRandom.current().nextInt(0, 999);
    }
    public int getValue()  { return value; }
    public int getItemID()  { return item_ID; }
    public String getName()  { return name; }
    public ItemType getType()  { return type; }
    public int getMainStat()  { return 0; }
    public  String getMainStatName()  { return ""; }
    public  int getDefense()  { return 0; }
    public  int getHealth()  { return 0; }
    public  double getCriticalChance()  { return 0; }
    public  double getBlockChance()  { return 0; }
    public  int getMinDamage()  { return 0; }
    public  int getMaxDamage()  { return 0; }

    public static void showItemDetails(Item item, Profession prof){
        //cout << "Item details: type=" << to_string(item->getType()) << ", prof=" << to_string(prof) << endl;

        String type;
        String proff;

        if (item.getType() == ItemType.WEAPON)
            type = "weapon";
        else if (item.getType() == ItemType.ARMOR)
            type = "armor";
        else if (item.getType() == ItemType.HEADGEAR)
            type = "headgear";
        else if (item.getType() == ItemType.TALISMAN)
            type = "talisman";
        else if (item.getType() == ItemType.SHIELD)
            type = "shield";

        if (prof == Profession.WARRIOR)
            proff = "Warrior";
        else if (prof == Profession.SCOUT)
            proff = "Scout";
        else if (prof == Profession.MAGE)
            proff = "Mage";


       // view->ShowOneItem(type, proff, item->getValue(), item->getName(), item->getMinDamage(), item->getMaxDamage(), item->getMainStat(), item->getMainStatName());
    }

    public static ItemType getRandomItemType(Profession prof){

        ItemType[] myArray;
        if( prof == Profession.WARRIOR  ){
            myArray = new ItemType[] {ItemType.WEAPON, ItemType.ARMOR, ItemType.SHIELD, ItemType.HEADGEAR, ItemType.TALISMAN};
            return myArray[ ThreadLocalRandom.current().nextInt( myArray.length ) ];
        } else if ( prof == Profession.SCOUT ){
            myArray = new ItemType[] { ItemType.WEAPON, ItemType.ARMOR, ItemType.HEADGEAR, ItemType.TALISMAN };
            return myArray[ ThreadLocalRandom.current().nextInt( myArray.length ) ];
        } else if (prof == Profession.MAGE) {
            myArray = new ItemType[]{ItemType.WEAPON, ItemType.ARMOR, ItemType.HEADGEAR, ItemType.TALISMAN};
            return myArray[ThreadLocalRandom.current().nextInt(myArray.length)];
        }

        return ItemType.ARMOR;
    }

    public String showItem(Item item, Profession p) {
        ItemType it = item.getType();
        int val1 = 0, val2 = 0, val3 = 0;
        String mainStat = "";
        String name = "";
        String type = "";
        int value = 0;


        if (it == ItemType.WEAPON) {
            type = "weapon";
            name = item.getName();
            val1 = item.getMinDamage();
            val2 = item.getMaxDamage();
            val3 = item.getMainStat();
            mainStat = item.getMainStatName();
            value = item.getValue();
            String weaponInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "minDamage: " + val1 + "\n" +
                    "maxDamage: " + val2 + "\n" +
                    "mainStat: " + val3 + "\n" +
                    "mainStatName: " + mainStat + "\n" );
            return weaponInfo;
        } else if (it == ItemType.TALISMAN) {
            type = "talisman";
            name = item.getName();
            val1 = item.getMainStat();
            val2 = (int) item.getCriticalChance();
            mainStat = item.getMainStatName();
            value = item.getValue();

            String talismanInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "mainStat: " + val1 + "\n" +
                    "criticalChance: " + val2 + "\n" +
                    "mainStatName: " + mainStat + "\n" );
            return talismanInfo;
        } else if (it == ItemType.SHIELD) {
            type = "shield";
            name = item.getName();
            val1 = item.getDefense();
            val2 = (int) item.getBlockChance();
            value = item.getValue();

            String shieldInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "defence: " + val1 + "\n" +
                    "blockChance: " + val2 + "\n" );
            return shieldInfo;
        } else if (it == ItemType.ARMOR) {
            type = "armor";
            name = item.getName();
            val1 = item.getDefense();
            val2 = item.getHealth();
            value = item.getValue();

            String armorInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "defence: " + val1 + "\n" +
                    "health: " + val2 + "\n" );
            return armorInfo;

        } else if (it == ItemType.HEADGEAR) {
            type = "headgear";
            name = item.getName();
            val1 = item.getDefense();

            if (p == Profession.MAGE) {
                val2 = item.getMainStat();
                mainStat = item.getMainStatName();
            } else
                val2 = item.getHealth();

            value = item.getValue();

            String headgearInfo = ( "type: " + type + "\n" +
                    "name: " + name + "\n" +
                    "value: " + value + "\n" +
                    "defence: " + val1 + "\n");
            return headgearInfo;
        }

        return "error";
    }

};
class Weapon extends Item {
    protected int min_damage;
    protected int max_damage;
    protected double critical_chance;

    public Weapon(int level){
        super(level);
        type = ItemType.WEAPON;

        int min = 1 + (level - 1) * 2;
        int max = min + 9;

        min_damage =  ThreadLocalRandom.current().nextInt(min, min+9);
        max_damage =  ThreadLocalRandom.current().nextInt(min_damage, max);
        critical_chance =  ThreadLocalRandom.current().nextInt(1, 15);

        value = level * 100;
    }
    public int getMinDamage()  { return min_damage; }
    public int getMaxDamage()  { return max_damage; }
    public double getCriticalChance()  { return critical_chance; }
};

class Sword extends Weapon {
    protected int main_stat;

    public Sword(int level){
        super(level);
        int x = ThreadLocalRandom.current().nextInt(1,10);
        // 30% chance for bonus
        if (x > 3)
            main_stat = 0;
        else
            main_stat = ThreadLocalRandom.current().nextInt(level, 2*level);

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize-1);
        name = namesForSwords[r];
    }
    public int getMainStat()  { return main_stat; }
    public String getMainStatName()  { return "strength"; }
};

class MagicStick extends Weapon {
        protected int main_stat;

    public MagicStick(int level){
        super(level);
        int x = ThreadLocalRandom.current().nextInt(1, 10);

        // 30% chance for bonus
        if (x > 3)
            main_stat = 0;
        else
            main_stat = ThreadLocalRandom.current().nextInt(level, 2 * level);

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForMagicSticks[r];
    }
    public int getMainStat() { return main_stat; }
    public String getMainStatName() { return "intelligence"; }
};

class Bow extends Weapon {
        protected int main_stat;

    public Bow(int level){
        super(level);
        int x = ThreadLocalRandom.current().nextInt(1, 10);

        // 30% chance for bonus
        if (x > 3)
            main_stat = 0;
        else
            main_stat = ThreadLocalRandom.current().nextInt(level, 2 * level);

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForBows[r];
    }
    public int getMainStat()  { return main_stat; }
    public String getMainStatName()  { return "agility"; }
};

class Armor extends Item {

        protected int defense;
        protected int health;

    public Armor(int level){
        super(level);
        type = ItemType.ARMOR;

        int min = 1 + (level - 1) * 2;
        int x = ThreadLocalRandom.current().nextInt(1, 10);

        defense = ThreadLocalRandom.current().nextInt(min, min+5);
        // 40% chance for bonus
        if (x > 4)
            health = 0;
        else
            health = ThreadLocalRandom.current().nextInt(level*50, level*50+500);

        value = level * 120;

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForArmors[r];
    }
    public int getDefense()  { return defense; }
    public int getHealth() { return health; }
};

class Headgear extends Item {
        protected int defense;

    public Headgear(int level){
        super(level);
        type = ItemType.HEADGEAR;

        int min = level;
        defense = ThreadLocalRandom.current().nextInt(min, min+2);

        value = level * 70;
    }
    public int getDefense()  { return defense; }
};

class Helmet extends Headgear {
        protected int health;

    public Helmet(int level){
        super(level);
        health = ThreadLocalRandom.current().nextInt(level*10, level * 10+200);

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForHelmets[r];
    }
    public int getHealth() { return health; }
    public String getMainStatName() { return "strength"; }
};

class MagicHat extends Headgear {
protected int intelligence;

    public MagicHat(int level){
        super(level);
        intelligence = ThreadLocalRandom.current().nextInt(level, level+1);
        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForMagicHats[r];
    }
    public int getMainStat() { return intelligence; }
    public String getMainStatName() { return "intelligence"; }
};

class Talisman extends Item {
protected double critical_chance;

    public Talisman(int level) {
        super(level);
        type = ItemType.TALISMAN;

        critical_chance = ThreadLocalRandom.current().nextDouble(1.0, 10.0);

        value = level * 60;
    }

    public double getCriticalChance() { return critical_chance; }
};

class ScoutTalisman extends Talisman {
protected int agility;

    public ScoutTalisman(int level){
        super(level);
        agility = ThreadLocalRandom.current().nextInt(level, level+1);

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForTalismans[r];

    }
    public int getMainStat() { return agility; }
    public String getMainStatName() { return "agility"; }
        };

class WarriorTalisman extends Talisman {
protected int strength;

    public WarriorTalisman(int level){
        super(level);
        strength = ThreadLocalRandom.current().nextInt(level, level+1);

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForTalismans[r];
    }
    public int getMainStat() { return strength; }
    public String getMainStatName() { return "strength"; }
};

class MageTalisman extends Talisman {
protected int intelligence;

    public MageTalisman(int level){
        super(level);
        intelligence = ThreadLocalRandom.current().nextInt(level, level+1);

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForTalismans[r];
    }
    public int getMainStat()  { return intelligence; }
    public String getMainStatName() { return "intelligence"; }
};

class Shield extends Item {
protected int  defense;
protected double block_chance;

    public Shield(int level){
        super(level);
        type = ItemType.SHIELD;

        defense = ThreadLocalRandom.current().nextInt(level, level+5);
        block_chance = ThreadLocalRandom.current().nextDouble(1.0, 20.0);
        value = level * 90;

        int r = ThreadLocalRandom.current().nextInt(0, namesTableSize - 1);
        name = namesForShields[r];
    }
    public int getDefense() { return defense; }
    public double getBlockChance() { return block_chance; }
};

;

