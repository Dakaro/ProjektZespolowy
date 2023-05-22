package Chambers;

import Game.Game;



public class BreakTime extends Chamber {

    public BreakTime(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadBreak(game, this);
    }
}