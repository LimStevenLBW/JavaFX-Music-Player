package app.controllers.hub;
import app.FxController;
import app.models.Playlist;
import app.models.Song;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HubController extends FxController{

    @FXML private VBox song_list; //Vertical Box List containing song items
    @FXML private GridPane song_item;
    @FXML private Label song_title;
    @FXML private Label song_artist;
    @FXML private Label song_duration;
    private Playlist activePlaylist;

    private ObservableList<Node> observableSongs; //Viewable song collection

    public HubController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        setLibrary();
        ArrayList<Song> mySongs = activePlaylist.getSongs();
        renderObservableSongs(mySongs);
    }

    /**
     * Read all song files from a directory
     */
    private void setLibrary(){
        //If this pathname does not denote a directory, then listFiles() returns null.
        String musicPath = "C:\\Users\\LimSt\\IdeaProjects\\MusicPlayer\\src\\app\\sampleSongs\\";
        File[] files = new File(musicPath).listFiles();
        activePlaylist = new Playlist();
        //File directory = new File("./"); Can check the current path through this tech
        //System.out.println(directory.getAbsolutePath());

        if(files == null){
            System.out.println("null, could not find music files");
        } else {
            activePlaylist.setName("Library");
            for (File file : files) {
                if (file.isFile()) {
                    activePlaylist.add(file.toURI().toString());
                }
            }
        }
    }

    /**
     * Read all songs from the users library and update the observable list
     */
    private ArrayList<Song> getSongs(){
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
