package Chambers;

import Game.Game;
import Models.Character.Hero;

import java.util.concurrent.ThreadLocalRandom;

public class FoodFountainChamber extends Chamber {

    public FoodFountainChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadFood(game, this);
    }

    public int changeHealth(){
        Hero myHero = this.game.getHero();

        int drawn_num = ThreadLocalRandom.current().nextInt(0, 2);
        if(drawn_num == 0){
            myHero.setCurrentHealth(myHero.getMaxHealth());
        }
        else{
            myHero.setCurrentHealth(myHero.getMaxHealth() * 0.3 );
        }

        return myHero.getCurrentHealth();
    }

}
