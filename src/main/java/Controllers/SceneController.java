package Controllers;

import Models.Character.Hero;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.css.converter.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController {

    Stage myStage;

    @FXML
    private AnchorPane mainPane;

    Hero myHero;
    public void setHero(Hero hero){
        myHero = hero;
        bindLabelsToPlayerStats();
    }

    public SceneController(){ }

    public void setMyStage(Stage stage ){
        myStage = stage;
    }

    public FXMLLoader loadRoom(String path)  {
        FXMLLoader loader = new FXMLLoader();

        Parent root = null;
        Scene scene;
        loader.setLocation(getClass().getResource(path));
        try {
            root = loader.load();
            mainPane.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loader;
    }

    @FXML
    private Text name_stats;
    @FXML
    private Text money_stats;
    @FXML
    private Text defense_stats;
    @FXML
    private Text block_chance_stats;
    @FXML
    private Text level_stats;
    @FXML
    private Text max_health_stats;
    @FXML
    private Text curr_health_stats;
    @FXML
    private Text min_attack_stats;
    @FXML
    private Text max_attack_stats;
    @FXML
    private Text crit_chance_stats;
    @FXML
    private Text profession_stats;
    @FXML
    private Text first_text_eq;
    @FXML
    private Text second_text_eq;
    @FXML
    private Text third_text_eq;
    @FXML
    private Text fourth_text_eq;
    @FXML
    private Text fifth_text_eq;

    private void bindLabelsToPlayerStats() {
        StringBinding criticalChanceBinding = Bindings.createStringBinding(
                () -> String.format("%.2f", myHero.criticalChanceProp.getValue()),
                myHero.criticalChanceProp
        );

        StringBinding blockChanceBinding = Bindings.createStringBinding(
                () -> String.format("%.2f", myHero.blockChanceProp.getValue()),
                myHero.blockChanceProp
        );

        name_stats.textProperty().bind(myHero.nameProp);
        level_stats.textProperty().bind(myHero.levelProp.asString());
        money_stats.textProperty().bind(myHero.moneyProp.asString());
        defense_stats.textProperty().bind(myHero.defenseProp.asString());
        block_chance_stats.textProperty().bind(blockChanceBinding);
        max_health_stats.textProperty().bind(myHero.maxHealthProp.asString());
        curr_health_stats.textProperty().bind(myHero.currentHealthProp.asString());
        min_attack_stats.textProperty().bind(myHero.minimalAttackProp.asString());
        max_attack_stats.textProperty().bind(myHero.maximalAttackProp.asString());
        crit_chance_stats.textProperty().bind(criticalChanceBinding);
        profession_stats.textProperty().bind(myHero.profProp);
        first_text_eq.textProperty().bind(myHero.weaponProp);
        second_text_eq.textProperty().bind(myHero.talismanProp);
        third_text_eq.textProperty().bind(myHero.shieldProp);
        fourth_text_eq.textProperty().bind(myHero.armorProp);
        fifth_text_eq.textProperty().bind(myHero.headgearProp);


    }



}
