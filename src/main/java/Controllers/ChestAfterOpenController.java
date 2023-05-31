package Controllers;

import Chambers.Chamber;
import Chambers.ChestAfterOpen;
import Game.Game;
import Others.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ChestAfterOpenController extends ChamberController implements Initializable {

    ChestAfterOpen currentChamber;

    @Override
    public void setChamber(Chamber chamber) {
        super.setChamber(chamber);
        currentChamber = (ChestAfterOpen)chamber;
        updateChestInfoText();
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
    private Text amountGold;

    @FXML
    private Text itemsInfo;

    private StringProperty amountGoldText = new SimpleStringProperty();
    private StringProperty itemInfoText = new SimpleStringProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amountGoldText.addListener((observable, oldValue, newValue) -> {
            amountGold.setText(newValue);
        });

        itemInfoText.addListener((observable, oldValue, newValue) -> {
            itemsInfo.setText(newValue);
        });
    }

    private void updateChestInfoText() {
        Item item = currentChamber.getFoundItem();
        String foundItemInfo = "Name: " + item.getName() + "\n value: " + Integer.toString( item.getValue() );
        amountGold.setText( Integer.toString( currentChamber.getFoundGold() ) );
        itemsInfo.setText( foundItemInfo );

        amountGoldText.set(Integer.toString( currentChamber.getFoundGold()) ) ;
        itemInfoText.set(foundItemInfo);
    }

}