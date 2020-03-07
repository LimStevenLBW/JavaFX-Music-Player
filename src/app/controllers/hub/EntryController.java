package app.controllers.hub;

import app.FxController;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A controller needs to conform to some rules and it can be used for different reasons:

 * The controller is instantiated by the FXML loader.
 * The controller must have a public no-args constructor.
 If it does not exist, the FXML loader will not be able to instantiate it, which will throw an exception at the load time.
 * The controller can have accessible methods, which can be specified as event handlers in FXML.
 * The FXML loader will automatically look for accessible instance variables of the controller.
 If the name of an accessible instance variable matches the fx:id attribute of an element,
 the object reference from FXML is automatically copied into the controller instance variable.
 This feature makes the references of UI elements in FXML available to the controller.
 The controller can use them later, such as binding them to model.
 * The controller can have an accessible initialize() method, which should take no arguments and have a return type of void.
 The FXML loader will call the initialize() method after the loading of the FXML document is complete.
 */
public class EntryController extends FxController {
    public EntryController(){

    }

    public void sleepAndLoad(){
        try{
            Stage stage = getPrimaryStage();
            setPrimaryStage(stage);
            loadNewScene("../../views/Hub.fxml");
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

}