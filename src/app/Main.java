package app;

import app.controllers.hub.EntryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        //Sets up program as a JavaFX application and calls start()
        launch(args);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        //Load Content into the Root of Scene Graph
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/Entry.fxml"));
        Parent root = (Parent) loader.load();

        //In JavaFX language, each window is called a STAGE, the content inside is the SCENE
        //Additional stages can be created for things such as dialog options or wizards usually
        //Modality can be set to block access to other stages
        primaryStage.setTitle("Music Player");
        //primaryStage.initStyle(StageStyle.TRANSPARENT);

        //Cast to FxController, pass in the primary stage
        EntryController entry = (EntryController) loader.getController();
        entry.setPrimaryStage(primaryStage);

        //A stage can only show one scene at a time, but it is possible to exchange the scene at runtime
        //All visual components are called nodes and attach to the scene as part of its scene graph
        primaryStage.setScene(
                new Scene(root)
        );

        //Makes the stage visible and exits the show method immediately
        //An alternative is showAndWait() which blocks until the stage is closed
        primaryStage.show();
        entry.sleepAndLoad();
    }
}
