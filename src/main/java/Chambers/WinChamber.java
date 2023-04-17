package Chambers;

import Game.Game;

public class WinChamber extends Chamber {

    public WinChamber(Game game){
        super(game);
    }

    @Override
    void loadChamber() {
        game.getView().loadWin(game, this);
    }
}