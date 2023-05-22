package Chambers;


import Game.Game;

public class TrapChamber extends Chamber {

    public TrapChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadTrapChamber(game, this);
    }
}