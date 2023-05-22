package Chambers;

import Game.Game;

import Game.Game;

public class LeftRight extends Chamber {

    public LeftRight(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadLeftRight(game, this);
    }
}