package Game;

import Chambers.*;
import Models.Character.CharacterClass;
import Models.Character.Profession;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game implements ButtonClickedObserver, ChamberObserver{

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

        dungeon.option1 = fight;
        dungeon.option2 = food;
        food.option1 = died;
        food.option2 = fight;
        fight.option1 = win;
        fight.option2 = died;

        dungeon.loadChamber();
    }


    @Override
    public void selectOption1() {

    }

    @Override
    public void selectOption2() {

    }
}
