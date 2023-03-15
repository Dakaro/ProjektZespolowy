package Models.Character;

enum Profession {
    WARRIOR,
    SCOUT ,
    MAGE,
    UNDEFINED
}

class CharacterClass {

static int defaultHealth = 50;
static double defaultCriticalChance = 3.;
static int defaultAttackMin = 2;
static int defaultAttackMax = 5;
static int counterAttackMin = 2;
static int counterAttackMax = 3;
static int defaultMonsterDefense = 3;
static double defaultMonsterCriticalChance = 15.;
static int defaultHealthMonster = 80;
static int defaultAttackMonsterMin = 20;
static int defaultAttackMonsterMax = 50;

    CharacterClass(){}

    Profession getProf(){
        return this.Prof;
    }

    int getMainStat(){
        return this.mainStat;
    }

    int getAttackModifier(){
        return this.attackModifier;
    }

    int getVitalityModifier(){
        return this.vitalityModifier;
    }

    int getDefenseModifier(){
        return this.defenseModifier;
    }

    String getMainStatName(){
        return this.mainStatName;
    }

    String getProfName(){

        return switch ( this.getProf() ) {
            case WARRIOR -> "Warrior";
            case SCOUT -> "Scout";
            case MAGE -> "Mage";
            default -> "undefined";
        };

    }

    String getSpecialAbility(){
        return this.specialAbility;
    }

    protected Profession Prof;
    protected int mainStat;
    protected int attackModifier;
    protected int vitalityModifier;
    protected int defenseModifier;
     void setSpecialAbility(String ability){
        this.specialAbility = ability;
     }

     void setMainStatName(String statName){
        this.mainStatName = statName;
     }

     void setDefenseModifier(int modifier){
         this.defenseModifier = modifier;
     }

     void setMainStat(int mainStat){
        this.mainStat = mainStat;
     }

     void setVitalityModifier(int modifier){
         this.vitalityModifier = modifier;
     }

     void setAttackModifier(int modifier){
            this.attackModifier = modifier;
     }

     void setProf(Profession prof){
         this.Prof = prof;
     }

    protected String mainStatName;
    protected String specialAbility;


}
