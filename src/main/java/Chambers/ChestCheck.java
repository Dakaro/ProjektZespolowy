package Chambers;

import Game.Game;

public class ChestCheck extends Chamber {

    public ChestCheck(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadChestCheck(game, this);
    }
}
