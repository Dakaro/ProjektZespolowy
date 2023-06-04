package Controllers;

import Chambers.Chamber;
import Chambers.ChestAfterOpen;
import Chambers.TraderChamber;
import Game.Game;
import Models.Character.Hero;
import Models.Character.Profession;
import Others.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TraderChamberController extends ChamberController implements Initializable {

    TraderChamber currentChamber;
    Hero myHero;
    Item[] items;
    int goldInfo;

    @Override
    public void setChamber(Chamber chamber) {
        super.setChamber(chamber);
        currentChamber = (TraderChamber) chamber;
        myHero = currentChamber.getHero();
        updateTraderInfoText();
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

    @FXML
    private Button button_firstItem;
    @FXML
    private Button button_secondItem;
    @FXML
    private Button button_thirdItem;
    @FXML
    private Text info_firstItem;
    @FXML
    private Text info_secondItem;
    @FXML
    private Text info_thirdItem;
    @FXML
    private Text info_gold;

    public void buyFirstItem(){
        amountGoldText.set( Integer.toString( currentChamber.buyItem( items[0] ) ) );
        button_firstItem.setDisable( true );
    }

    public  void buySecondItem(){
        amountGoldText.set( Integer.toString( currentChamber.buyItem( items[1] ) ) );
        button_secondItem.setDisable( true );
    }

    public void buyThirdItem(){
        amountGoldText.set( Integer.toString( currentChamber.buyItem( items[2] ) ) );
        button_thirdItem.setDisable( true );
    }


    @Override
    public void setMediator(Game mediator) {
        super.setMediator(mediator);
    }

    private StringProperty amountGoldText = new SimpleStringProperty();
    private StringProperty itemInfoTextFirst= new SimpleStringProperty();
    private StringProperty itemInfoTextSecond= new SimpleStringProperty();
    private StringProperty itemInfoTextThird= new SimpleStringProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amountGoldText.addListener((observable, oldValue, newValue) -> {
            info_gold.setText(newValue);
        });

        itemInfoTextFirst.addListener((observable, oldValue, newValue) -> {
            info_firstItem.setText(newValue);
        });

        itemInfoTextSecond.addListener((observable, oldValue, newValue) -> {
            info_secondItem.setText(newValue);
        });

        itemInfoTextThird.addListener((observable, oldValue, newValue) -> {
            info_thirdItem.setText(newValue);
        });

    }

    String getItemInfo(Item item, Profession prof){
        return item.showItem(item, prof);
    }

    void updateTraderInfoText(){
        items = currentChamber.getTraderItems();
        goldInfo = currentChamber.getGoldBalance();

        amountGoldText.set( Integer.toString(goldInfo) );
        itemInfoTextFirst.set( getItemInfo(items[0], myHero.getProf()) );
        itemInfoTextSecond.set( getItemInfo(items[1], myHero.getProf()) );
        itemInfoTextThird.set( getItemInfo(items[2], myHero.getProf()) );

    }
}
