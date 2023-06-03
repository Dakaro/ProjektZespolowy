package Controllers;

import Chambers.Chamber;
import Chambers.MonsterChamber;
import Game.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MonsterChamberController extends ChamberController{

    MonsterChamber currentChamber;
    @Override
    public void setChamber(Chamber chamber) {
        super.setChamber(chamber);
        currentChamber = (MonsterChamber)chamber;
    }

    @Override
    public void onOption1Clicked() {
        super.onOption1Clicked();
    }

    @Override
    public void onOption2Clicked() {
        super.onOption2Clicked();
    }

    @Override
    public void onOption3Clicked() {
        super.onOption3Clicked();
    }

    @Override
    public void setMediator(Game mediator) {
        super.setMediator(mediator);
    }

    @FXML
    private Text info_fight;

    @FXML
    private Button buttonFight;

    @FXML
    private Button buttonFinish;

    @FXML
    private Button buttonRun;

    public void FightAction(){
        buttonFight.setDisable(true);
        buttonRun.setDisable(true);

        String result = currentChamber.fight();
        info_fight.setText(result);
        buttonFinish.setDisable( false );
    }

    public void finish(){
        if( currentChamber.getHero().getCurrentHealth() > 0 ){
            buttonRun.setDisable(false);
            buttonFinish.setDisable(true);
        }
        else {
            currentChamber.selectOption2();
        }
    }
}
