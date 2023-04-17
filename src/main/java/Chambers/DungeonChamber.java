package Chambers;

import Game.Game;

public class DungeonChamber extends Chamber {

    public DungeonChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadDungeon(game, this);
    }
}