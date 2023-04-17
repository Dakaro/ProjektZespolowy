package Chambers;

import Game.Game;
import Game.View;

public class DiedChamber extends Chamber {

    public DiedChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadDied(game, this);
    }

}
