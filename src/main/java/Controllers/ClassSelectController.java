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
        System.out.println( inputName.getCharacters() );
        String name = String.valueOf( inputName.getCharacters() );
        System.out.println(event.getTarget() );

        if( event.getTarget() == buttonMage ){
            System.out.println("MAG");
            observer.onSelectButton(Profession.MAGE, name );
        }

        if( event.getTarget() == buttonScout ){
            System.out.println("Scout");
            observer.onSelectButton(Profession.SCOUT, name);
        }

        if( event.getTarget() == buttonWarrior ){
            System.out.println("Warrior");
            observer.onSelectButton(Profession.WARRIOR, name);
        }

    }

    private ButtonClickedObserver observer;

    public void setObserver(Game observer) {
        this.observer = observer;
    }

}
