package Models.Character;

import java.util.concurrent.ThreadLocalRandom;

import static Others.Names.*;

public class Monster extends Character {
    public Monster(int level, boolean p) {
        setALL(level);
        this.setName(p);
    }

    public void chooseClass() {
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

    public void setMaxHealth() {
        this.maxHealth = defaultHealthMonster * this.getLevel() * this.character.getVitalityModifier();
        this.setCurrentHealth(this.maxHealth);
    }

    public void setDefense() {
        this.defense = defaultMonsterDefense * this.getLevel() * this.character.getDefenseModifier();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMinimalAttack() {
        this.minimalAttack = defaultAttackMonsterMin * this.getLevel() * this.character.getAttackModifier();
    }

    public void setMaximalAttack() {
        this.maximalAttack = defaultAttackMonsterMax * this.getLevel() * this.character.getAttackModifier();
    }

    public void setName(boolean p) {
        if (!p) {
            int r = ThreadLocalRandom.current().nextInt(1, sizeNamesForMonsters);
            this.name = namesForMonsters[r];
        } else {
            int r = ThreadLocalRandom.current().nextInt(1, sizeNamesForBosses);
            this.name = namesForBosses[r];
        }
    }

    public void setBlockChance() {
        if (this.character.getProf() == Profession.WARRIOR) {
            this.blockChance = 15.;
        } else {
            this.blockChance = 0.;
        }
    }

    @Override
    void setMaxHealth(int i) {
    }

    @Override
    void setDefense(int i) {
    }

    public void setALL(int level) {
        this.chooseClass();
        this.setLevel(level);
        this.setMaxHealth();
        this.setDefense();
        this.setMinimalAttack();
        this.setMaximalAttack();
        this.setCriticalChance(defaultMonsterCriticalChance);
    }
}
