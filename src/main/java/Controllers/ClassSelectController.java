package Controllers;

import Game.ButtonClickedObserver;
import Game.Game;
import Models.Character.CharacterClass;
import Models.Character.Profession;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClassSelectController {

    @FXML
    private TextField inputName;

    @FXML
    private Button buttonScout;

    @FXML
    private Button buttonWarrior;

    @FXML
    private Button buttonMage;


    @FXML
    public void setClass(Event event) {
        String name = String.valueOf( inputName.getCharacters() );

        if( event.getTarget() == buttonMage ){
            observer.onSelectButton(Profession.MAGE, name );
        }

        if( event.getTarget() == buttonScout ){
            observer.onSelectButton(Profession.SCOUT, name);
        }

        if( event.getTarget() == buttonWarrior ){
            observer.onSelectButton(Profession.WARRIOR, name);
        }

    }

    private ButtonClickedObserver observer;

    public void setObserver(Game observer) {
        this.observer = observer;
    }

}
