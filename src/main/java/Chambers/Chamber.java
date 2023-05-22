package Chambers;

import Game.ChamberMediator;
import Game.Game;
import Game.View;

public abstract class Chamber implements ChamberMediator {

    public Chamber option1;
    public Chamber option2;

    Game game;

    public Chamber(Game game){
        this.game = game;
    }

    public void loadChamber(){}

    @Override
    public void selectOption1(){
        option1.loadChamber();
    }

    @Override public void selectOption2(){
        option2.loadChamber();
    }

}

