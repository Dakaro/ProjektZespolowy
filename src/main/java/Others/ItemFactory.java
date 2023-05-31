package Others;

import Models.Character.Profession;

public class ItemFactory {
    public static Item createItem(int level, ItemType type, Profession profession) {
        Item item = null;

        if (type == ItemType.WEAPON) {
            if (profession == Profession.WARRIOR) {
                item = new Sword(level);
            } else if (profession == Profession.SCOUT) {
                item = new Bow(level);
            } else if (profession == Profession.MAGE) {
                item = new MagicStick(level);
            }
        } else if (type == ItemType.ARMOR) {
            item = new Armor(level);
        } else if (type == ItemType.HEADGEAR) {
            if (profession == Profession.WARRIOR) {
                item = new Helmet(level);
            } else if (profession == Profession.SCOUT) {
                item = new Helmet(level);
            } else if (profession == Profession.MAGE) {
                item = new MagicHat(level);
            }
        } else if (type == ItemType.TALISMAN) {
            if (profession == Profession.WARRIOR) {
                item = new WarriorTalisman(level);
            } else if (profession == Profession.SCOUT) {
                item = new ScoutTalisman(level);
            } else if (profession == Profession.MAGE) {
                item = new MageTalisman(level);
            }
        } else if (type == ItemType.SHIELD) {
            if (profession == Profession.WARRIOR)
                item = new Shield(level);
        }


        return item;
    }
}
