package Game;

import Chambers.Chamber;
import Controllers.ChamberController;
import Controllers.ClassSelectController;
import Controllers.MainMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class View{

   private Stage stage;


   public View(Stage stage){
       this.stage = stage;
   }

   /*FXMLLoader getLoader(){
       return loader;
   }

    */

   private FXMLLoader loadRoom(String path)  {
        FXMLLoader loader = new FXMLLoader();

        Parent root = null;
        Scene scene;
       loader.setLocation(getClass().getResource(path));
      // Parent pane = null;
       try {
           root = loader.load();
       } catch (IOException e) {
           e.printStackTrace();
       }

       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();

       return loader;
   }

   public void loadStartRoom(Game game){
      FXMLLoader myLoader = loadRoom("/mainMenu.fxml");
       MainMenuController myController = myLoader.getController();
       myController.setObserver(game);
   }

   public void loadSelectClassRoom(Game game){
       FXMLLoader myLoader = loadRoom("/classSelect.fxml");
       ClassSelectController myController = myLoader.getController();
       myController.setObserver(game);
   }

   public void loadDungeon(Game game, Chamber chamber){
       FXMLLoader myLoader = loadRoom("/dungeon.fxml");
       ChamberController myController = myLoader.getController();
       myController.setObserver(game);
       myController.setChamber(chamber);
   }

   public void loadFood(Game game, Chamber chamber){
       FXMLLoader myLoader = loadRoom("/foodFountainScreen.fxml");
       ChamberController myController = myLoader.getController();
       myController.setObserver(game);
       myController.setChamber(chamber);
   }

    public void loadFight(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/fightScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadWin(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/winScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadDied(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/diedScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }



}


