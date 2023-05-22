package Chambers;

import Game.Game;

public class EmptyRoom extends Chamber {

    public EmptyRoom(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadEmpty(game, this);
    }
}