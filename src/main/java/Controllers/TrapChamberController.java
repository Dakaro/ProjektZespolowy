package Controllers;

import Chambers.Chamber;
import Chambers.TrapChamber;
import Game.Game;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TrapChamberController extends ChamberController implements Initializable {

    TrapChamber currentChamber;

    private StringProperty myText = new SimpleStringProperty();


    @Override
    public void setChamber(Chamber chamber) {
        super.setChamber(chamber);
        currentChamber = (TrapChamber)chamber;
        updateHealthText(Integer.toString(currentChamber.changeHealth() ));
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


    public void setObserver(Game observer) {
        super.setObserver(observer);
    }

    @FXML
    private Text current_health;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myText.addListener((observable, oldValue, newValue) -> {
            current_health.setText(newValue);
        });
    }

    private void updateHealthText(String value) {
        myText.set(value);
    }
}
