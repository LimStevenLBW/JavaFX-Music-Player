package app.controllers.hub;


import app.models.Song;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SongViewModel extends GridPane implements Initializable {
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
        addMouseEventListener();
    }

    /**
     * Connects the handler method reference to our event and adds it to the current node
     */
    private void addMouseEventListener() {
        EventHandler<MouseEvent> eventListener = this::handlePlaySelectedSong;
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, eventListener);
    }

    /**
     * Plays the selected song
     * @param event
     * @throws IOException
     */
    @FXML
    private void handlePlaySelectedSong(MouseEvent event){
        System.out.println("Playing");
    }

}
