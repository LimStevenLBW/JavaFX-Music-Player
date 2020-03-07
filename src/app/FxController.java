package app;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class FxController implements Initializable {
    private String viewName;
    private Stage primaryStage;

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    /**
     *
     * @param event
     */
    public void setPrimaryStage(ActionEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.primaryStage = primaryStage;
    }

    /**
     *
     * @param resource the relative location of the fxml file to load
     * @throws IOException
     */
    public void loadNewScene(String resource) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(resource));

        if(primaryStage != null){
            primaryStage.setScene(
                    new Scene(root)
            );
            primaryStage.show();
        }
        else{
            System.out.println("!!!ERROR, Primary Stage was not set");
        }
        //primaryStage.setResizable(false);
        //primaryStage.setTitle("Order History");

    }

    /**
     * initialize is called after the constructor, when the FXML fields have been populated.
     * It has proper access to those values
     * @param url the location of the fxml document
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
