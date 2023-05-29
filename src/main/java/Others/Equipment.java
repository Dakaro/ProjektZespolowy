package Others;

import Models.Character.Profession;

import static Others.ItemType.*;

public class Equipment
{
    public Equipment(int lvl, Profession prof){
        fac = new ItemFactory();
        weapon_slot = fac.createItem(lvl, WEAPON, prof);
        armor_slot = fac.createItem(lvl, ARMOR, prof);
        talisman_slot = fac.createItem(lvl, TALISMAN, prof);
        headgear_slot = fac.createItem(lvl, HEADGEAR, prof);
        if (prof == Profession.WARRIOR)
        {
            shield_slot = fac.createItem(lvl, SHIELD, prof);
        }
        else
        {
            shield_slot = null;
        }
    }
    public boolean ChangeItem( Item i){
        if (i.getType() == WEAPON)
        {
            this.weapon_slot = i;
        }
        else if (i.getType() == ItemType.ARMOR)
        {
            this.armor_slot = i;
        }
        else if (i.getType() == ItemType.TALISMAN)
        {
            this.talisman_slot = i;
        }
        else if (i.getType() == ItemType.HEADGEAR)
        {
            this.headgear_slot = i;
        }
        else if (i.getType() == ItemType.SHIELD)
        {
            this.shield_slot = i;
        }
        return true;
    }
    public Item weapon_slot;
    public Item armor_slot;
    public Item shield_slot;
    public Item headgear_slot;
    public Item talisman_slot;

    private ItemFactory fac;
};
