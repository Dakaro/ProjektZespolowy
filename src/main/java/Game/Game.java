package Game;

import Chambers.*;
import Models.Character.CharacterClass;
import Models.Character.Profession;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game implements ButtonClickedObserver, ChamberMediator{

    CharacterClass hero = new CharacterClass();
    View view = null;
    public Game(){
    }

    public View getView(){
        return view;
    }


    @Override
    public void onPlayButtonClicked() {
        System.out.println("Kliknieto!");
        heroSetClassAndName();
    }

    @Override
    public void onSelectButton(Profession prof, String name){
        hero.setProf(prof);
        hero.setMainStatName(name);
        System.out.println(hero.getProf() );
        System.out.println(hero.getMainStatName() );
        prepareMap();

    }

    public void play(Stage stage){
        view = new View(stage);
        view.loadStartRoom(this);
    }

    public void heroSetClassAndName(){
        view.loadSelectClassRoom(this);
    }


    void  prepareMap(){
        WinChamber win = new WinChamber(this);
        DiedChamber died = new DiedChamber(this);
        FoodFountainChamber food = new FoodFountainChamber(this);
        FightChamber fight = new FightChamber(this);
        DungeonChamber dungeon = new DungeonChamber(this);
        EmptyRoom empty = new EmptyRoom(this);
        LeftRight leftRight = new LeftRight(this);
        CheckStats checkStats = new CheckStats(this); //one exit road
        BreakTime breakTime = new BreakTime(this); // one exit road
        ChestCheck chestCheck = new ChestCheck(this); //one exit road
        HealthChamber healthChamber = new HealthChamber(this);
        MonsterChamber monsterChamber = new MonsterChamber(this);
        TraderChamber traderChamber = new TraderChamber(this);
        TrapChamber trapChamber = new TrapChamber(this); //one exit road
        ChestAfterOpen chestAfterOpen = new ChestAfterOpen(this); // one exit road
        Boss boss = new Boss(this);

        Chamber n1 = monsterChamber;
        Chamber n2 = food;
        Chamber n3 = traderChamber;
        Chamber n4 = empty;
        Chamber n5 = chestCheck;
        Chamber n6 = healthChamber;
        Chamber n7 = chestCheck;
        Chamber n8 = monsterChamber;
        Chamber n9 = monsterChamber;
        Chamber n10 = trapChamber;
        Chamber n11 = traderChamber;
        Chamber n12 = food;
        Chamber n13 = healthChamber;
        Chamber n14 = traderChamber;
        Chamber n15 = boss;

        n1.option1 = n3;
        n1.option2 = n2;
        n2.option1 = n3;
        n2.option2 = n4;
        n3.option1 = n4;
        n3.option2 = n5;
        n4.option1 = n6;
        n5.option1 = n7;
        n5.option2 = n8;
        n6.option1 = n9;
        n7.option1 = n10;
        n8.option1 = n10;
        n9.option1 = n11;
        n10.option1 = n11;
        n10.option2 = n12;
        n11.option1 = n13;
        n12.option1 = n13;
        n12.option2 = n13;
        n13.option1 = n14;
        n14.option1 = n15;
        n15.option1 = n15;

        n1.loadChamber();


    }


    @Override
    public void selectOption1() {

    }

    @Override
    public void selectOption2() {

    }
}
