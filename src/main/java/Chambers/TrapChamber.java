package Chambers;

import Game.Game;
import Models.Character.Hero;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class TrapChamber extends Chamber  {

    public TrapChamber(Game game){
        super(game);
    }

    @Override
    public void loadChamber() {
        game.getView().loadTrapChamber(game, (TrapChamber)this);
    }


    public int changeHealth() {
        super.action();
        Hero myHero = this.game.getHero();
        myHero.getDamage( (int)(myHero.getMaxHealth() * 0.2));
        return myHero.getCurrentHealth();
    }
}