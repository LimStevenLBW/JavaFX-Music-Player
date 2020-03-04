package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args); //Sets up program as a JavaFX application and calls start()
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //In JavaFX language, the entire window is called a STAGE, the content inside is the SCENE
        primaryStage.setTitle("Music Player");
        primaryStage.setScene(
                new Scene(root, 300, 275)
        );
        primaryStage.show();
    }
}
