package Chambers;

import Game.Game;


public class HealthChamber extends Chamber {

    public HealthChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadHealthChamber(game, this);
    }
}
