package Chambers;

import Game.Game;
import Models.Character.Character;
import Models.Character.Hero;
import Models.Character.Monster;

public class Boss extends Chamber {

    Hero myHero;
    public Boss(Game game){
        super(game);
        myHero = game.getHero();
    }

    @Override
    public void selectOption1() {
        option1 = new WinChamber(game);
        option1.loadChamber();
    }

    @Override
    public void selectOption2() {
        option2 = new DiedChamber(game);
        option2.loadChamber();
    }

    @Override
    public void loadChamber() {
        game.getView().loadBoss(game, this);
    }

    public String fightBoss(){
            String fightStatus = "";
            Monster normal_monster = new Monster(myHero.getLevel(), true);
            Character character = (Character)normal_monster;
            fightStatus = fightStatus + myHero.fight(normal_monster, fightStatus);
            if (myHero.getCurrentHealth() > 0)
            {
                myHero.levelup();
            }
            return fightStatus;
        }

        public Hero getHero(){
            return myHero;
        }
}