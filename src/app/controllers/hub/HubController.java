package app.controllers.hub;
import app.FxController;
import app.models.Song;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HubController extends FxController{

    @FXML private VBox song_list; //Vertical Box List containing song items
    @FXML private GridPane song_item;
    @FXML private Label song_title;
    @FXML private Label song_artist;
    @FXML private Label song_duration;

    private ObservableList<Node> observableSongs; //Viewable song collection

    public HubController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList<Song> mySongs = getSongLibrary();
        renderObservableSongs(mySongs);
    }

    /**
     * Read all songs from the users library and update the observable list
     */
    private ArrayList<Song> getSongLibrary(){
        ArrayList<Song> mySongs = new ArrayList<Song>(); //Collection of songs
        mySongs.add(new Song("name1", "artist1", "duration1"));
        //mySongs.add(new Song("name2", "artist2", "duration2"));
        //mySongs.add(new Song("name3", "artist3", "duration3"));
        return mySongs;
    }

    /**
     * Triggers a visual update at the list of songs in the vBox
     */
    private void renderObservableSongs(ArrayList<Song> mySongs){
        observableSongs = song_list.getChildren();
        for(Song song: mySongs){
            SongViewModel viewableSong = new SongViewModel(song);
            observableSongs.add(viewableSong);
        }

    }

    private void addSongAndRender(){

    }
}
