package Models.Character;
import Models.Character.Profession;
public class CharacterClass {

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

    public CharacterClass(){}

    public Profession getProf(){
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

    public String getMainStatName(){
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
    public void setSpecialAbility(String ability){
        this.specialAbility = ability;
     }

     public void setMainStatName(String statName){
        this.mainStatName = statName;
     }

     public void setDefenseModifier(int modifier){
         this.defenseModifier = modifier;
     }

     public void setMainStat(int mainStat){
        this.mainStat = mainStat;
     }

     public void setVitalityModifier(int modifier){
         this.vitalityModifier = modifier;
     }

     public void setAttackModifier(int modifier){
            this.attackModifier = modifier;
     }

     public void setProf(Profession prof){
         this.Prof = prof;
     }

    protected String mainStatName;
    protected String specialAbility;


}
