package Chambers;

import Game.Game;

public class Boss extends Chamber {

    public Boss(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadBoss(game, this);
    }
}