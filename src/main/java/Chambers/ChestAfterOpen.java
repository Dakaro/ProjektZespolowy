package Chambers;


import Game.Game;

public class ChestAfterOpen extends Chamber {

    public ChestAfterOpen(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadChestAfterOpen(game, this);
    }
}