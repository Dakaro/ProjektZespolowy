package Chambers;

import Game.Game;

public class TraderChamber extends Chamber {

    public TraderChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadTraderChamber(game, this);
    }
}