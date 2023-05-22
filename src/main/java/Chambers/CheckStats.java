package Chambers;

import Game.Game;

import Game.Game;

public class CheckStats extends Chamber {

    public CheckStats(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadCheckStats(game, this);
    }
}