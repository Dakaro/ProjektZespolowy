package Game;

import Chambers.*;
import Maps.MapGenerator;
import Models.Character.CharacterClass;
import Models.Character.Hero;
import Models.Character.Profession;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class Game implements ButtonClickedObserver, ChamberMediator{

    Hero hero = new Hero();
    MapGenerator mapGenerator;
    View view = null;
    Stage stage;

    public Hero getHero(){
        return hero;
    }

    public Game(){
        mapGenerator = new MapGenerator(this);
        mapGenerator.prepareMap();
    }

    public View getView(){
        return view;
    }


    @Override
    public void onPlayButtonClicked() {
        heroSetClassAndName();
    }

    @Override
    public void onSelectButton(Profession prof, String name){
        hero.chooseClass(prof);
        hero.setName(name);


        prepareMap();

    }

    public void play(Stage stage){
        view = new View(stage);
        this.stage = stage;
        view.loadStartRoom(this, stage);
    }

    public void heroSetClassAndName(){
        view.loadSelectClassRoom(this);
    }


    void  prepareMap(){
        int version = ThreadLocalRandom.current().nextInt(5);
        Chamber myMap = mapGenerator.getMap(version);
        view.loadMainScene(this, stage);
        myMap.loadChamber();

    }


    @Override
    public void selectOption1() {

    }

    @Override
    public void selectOption2() {

    }
}
