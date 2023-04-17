package Controllers;

import Game.ButtonClickedObserver;
import Game.Game;
import Models.Character.Profession;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuController {

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonExit;


    @FXML
    public void onPlayButton() {
        observer.onPlayButtonClicked();
    }

    @FXML
    public void onExitButton(){
        Platform.exit();
    }

    private ButtonClickedObserver observer;

    public void setObserver(Game observer) {
        this.observer = observer;
    }

}
