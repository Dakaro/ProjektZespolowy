package Chambers;

import Game.Game;

public class MonsterChamber extends Chamber {

    public MonsterChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadMonsterChamber(game, this);
    }
}