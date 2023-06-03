package Controllers;


import Chambers.Chamber;
import Game.Game;
import Game.ChamberMediator;
import javafx.fxml.FXML;

public class ChamberController {

    public Chamber chamber;

    public void setChamber(Chamber chamber){
        this.chamber = chamber;
    }

    @FXML
    public void onOption1Clicked() {
        chamber.selectOption1();
        mediator.selectOption1();
    }

    @FXML
    public void onOption2Clicked(){
        chamber.selectOption2();
        mediator.selectOption2();
    }

    @FXML
    public void onOption3Clicked(){
    }

    private ChamberMediator mediator;

    public void setMediator(Game mediator) {
        this.mediator = mediator;
    }

}
