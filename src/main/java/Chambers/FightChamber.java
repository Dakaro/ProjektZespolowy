package Chambers;

import Game.Game;

public class FightChamber extends Chamber {

    public FightChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadFight(game, this);
    }
}

