package Controllers;


import Chambers.Chamber;
import Game.Game;
import Game.ChamberMediator;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class ChamberController {

    public Chamber chamber;

    public void setChamber(Chamber chamber){
        this.chamber = chamber;
    }

    @FXML
    public void onOption1Clicked() {
        chamber.selectOption1();
        observer.selectOption1();
    }

    @FXML
    public void onOption2Clicked(){
        chamber.selectOption2();
        observer.selectOption2();
    }

    @FXML
    public void onOption3Clicked(){

    }

    private ChamberMediator observer;

    public void setObserver(Game observer) {
        this.observer = observer;
    }

}
