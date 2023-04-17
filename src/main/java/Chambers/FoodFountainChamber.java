package Chambers;

import Game.Game;

public class FoodFountainChamber extends Chamber {

    public FoodFountainChamber(Game game){
        super(game);
    }

    @Override
    void loadChamber() {
        game.getView().loadFood(game, this);
    }
}
