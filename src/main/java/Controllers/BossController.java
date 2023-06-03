package Controllers;

import Chambers.Boss;
import Chambers.Chamber;
import Game.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class BossController extends ChamberController{
    Boss currentChamber;
    @Override
    public void setChamber(Chamber chamber) {
        super.setChamber(chamber);
        currentChamber = (Boss)chamber;
        FightAction();
    }


    @FXML
    private Button buttonFinish;

    @FXML
    private Text infoFight;

    public void FightAction(){
        String result = currentChamber.fightBoss();
        infoFight.setText(result);
    }

    public void finish(){
        if( currentChamber.getHero().getCurrentHealth() > 0 ){
            currentChamber.selectOption1();
        }
        else {
            currentChamber.selectOption2();
        }
    }
}
