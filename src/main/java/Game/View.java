package Game;

import Chambers.Chamber;
import Controllers.*;
import Models.Character.Hero;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class View{

   private Stage stage;

   SceneController sceneController;

   public View(Stage stage){
       this.stage = stage;
   }

   public FXMLLoader loadMenuScene(String path){
       FXMLLoader loader = new FXMLLoader();

       Parent root = null;
       Scene scene;
       loader.setLocation(getClass().getResource(path));
       try {
           root = loader.load();
       } catch (IOException e) {
           e.printStackTrace();
       }

       scene = new Scene(root);
       this.stage.setScene(scene);
       this.stage.show();

       return loader;
   }

   public void loadStartRoom(Game game, Stage stage){
      FXMLLoader myLoader = loadMenuScene("/_mainMenuScreen.fxml");
       MainMenuController myController = myLoader.getController();
       myController.setObserver(game);
   }

   public void loadMainScene(Game game, Stage stage){
       FXMLLoader myLoader = loadMenuScene("/root_layout.fxml");
       SceneController myController = myLoader.getController();
       sceneController = myController;
       myController.setMyStage(stage);
       myController.setHero(game.getHero());
   }

   public void loadSelectClassRoom(Game game){
       FXMLLoader myLoader = loadMenuScene("/_classSelectScreen.fxml");
       ClassSelectController myController = myLoader.getController();
       myController.setObserver(game);
   }

   public void loadDungeon(Game game, Chamber chamber){
       FXMLLoader myLoader = sceneController.loadRoom("/dungeon.fxml");
       ChamberController myController = myLoader.getController();
       myController.setMediator(game);
       myController.setChamber(chamber);
   }

   public void loadFood(Game game, Chamber chamber){
       FXMLLoader myLoader = sceneController.loadRoom("/foodFountainScreen.fxml");
       ChamberController myController = myLoader.getController();
       myController.setMediator(game);
       myController.setChamber(chamber);
   }

    public void loadWin(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/_winScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }

    public void loadDied(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/_diedScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }


    public void loadChestAfterOpen(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/chestOpenScreen.fxml");
        ChestAfterOpenController myController = (ChestAfterOpenController)myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }

    public void loadEmpty(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/emptyRoom.fxml");
        ChamberController myController = myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }


    public void loadLeftRight(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/_leftRightScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }

    public void loadMonsterChamber(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/monsterRoom.fxml");
        MonsterChamberController myController = myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }

    public void loadTraderChamber(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/traderRoom.fxml");
        TraderChamberController myController = myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }

    public void loadTrapChamber(Game game, Chamber chamber){
        FXMLLoader loader = sceneController.loadRoom("/trapRoom.fxml");

        TrapChamberController myController = (TrapChamberController) loader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }

    public void loadBoss(Game game, Chamber chamber){
        FXMLLoader myLoader = sceneController.loadRoom("/bossChamber.fxml");
        BossController myController = myLoader.getController();
        myController.setMediator(game);
        myController.setChamber(chamber);
    }
}


