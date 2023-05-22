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
      FXMLLoader myLoader = loadRoom("/_mainMenuScreen.fxml");
       MainMenuController myController = myLoader.getController();
       myController.setObserver(game);
   }

   public void loadSelectClassRoom(Game game){
       FXMLLoader myLoader = loadRoom("/_classSelectScreen.fxml");
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
        FXMLLoader myLoader = loadRoom("/_winScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadDied(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/_diedScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadCheckStats(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/_checkStatsEqEnterDungScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadChestAfterOpen(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/treasureRoom_afterOpen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadChestCheck(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/chestOpenScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadEmpty(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/emptyRoom.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadHealthChamber(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/healthRoom.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadLeftRight(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/_leftRightScreen.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadMonsterChamber(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/monsterRoom.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadTraderChamber(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/traderRoom.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadTrapChamber(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/trapRoom.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadBreak(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/breakTime.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }

    public void loadBoss(Game game, Chamber chamber){
        FXMLLoader myLoader = loadRoom("/bossChamber.fxml");
        ChamberController myController = myLoader.getController();
        myController.setObserver(game);
        myController.setChamber(chamber);
    }
}


