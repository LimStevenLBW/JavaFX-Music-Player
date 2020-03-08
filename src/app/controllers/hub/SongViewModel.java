package app.controllers.hub;


import app.models.Song;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SongViewModel extends AnchorPane implements Initializable {
    @FXML private GridPane song_item;
    @FXML private Label song_title;
    @FXML private Label song_artist;
    @FXML private Label song_duration;
    private Song song;

    public SongViewModel(Song song) {
        this.song = song; //Init Song

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../views/Song.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * In this case, since fxml injection was done during the constructor, this occurs before the constructor completes
     * @param url
     * @param resourceBundle
     */
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        song_title.textProperty().bind(song.getName());
        song_artist.textProperty().bind(song.getArtist());
        song_duration.textProperty().bind(song.getDuration());
    }

}