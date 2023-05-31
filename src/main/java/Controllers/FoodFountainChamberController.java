package Controllers;

import Chambers.Chamber;
import Chambers.FoodFountainChamber;
import Game.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FoodFountainChamberController extends ChamberController {

    FoodFountainChamber currentChamber;

    @Override
    public void setChamber(Chamber chamber) {
        super.setChamber(chamber);
        currentChamber = (FoodFountainChamber) chamber;
    }

    @Override
    public void onOption1Clicked() {
        super.onOption1Clicked();
    }

    @Override
    public void onOption2Clicked() {
        super.onOption2Clicked();
    }

    @FXML
    private Text infoAfterFood;

    @FXML
    private Button buttonEat;

    @Override
    public void onOption3Clicked() {
        super.onOption3Clicked();
        buttonEat.setDisable( true );
        int currHealth = currentChamber.changeHealth();
        infoAfterFood.setText("You ate food, your current health is: " + Integer.toString(currHealth) );
    }

    @Override
    public void setMediator(Game mediator) {
        super.setMediator(mediator);
    }
}
