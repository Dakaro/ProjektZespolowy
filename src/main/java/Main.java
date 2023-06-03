import Game.Game;
import Models.Character.CharacterClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    Game newGame = new Game();

    @Override
    public void start(Stage stage) {
        stage.setResizable( false );
        stage.setMaximized( false );
        newGame.play(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}