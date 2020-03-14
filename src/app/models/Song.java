package app.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * The basic steps required to play media in Java FX are:
 * 1. Create a Media object for the desired media source.
 * 2. Create a MediaPlayer object from the Media object.
 * 3. Create a MediaView object.
 * 4. Add the MediaPlayer to the MediaView.
 * 5. Add the MediaView to the scene graph.
 * 6. Invoke MediaPlayer.play().
 */
public class Song implements MapChangeListener<String, Object> {
    //Every song needs to be associated with a mediaplayer object to initialize its data
    private MediaPlayer mediaPlayer;
    private Media media;
    private ObservableMap<String, Object> metadata;
    private String songPath;

    private StringProperty name = new SimpleStringProperty();
    private StringProperty artist = new SimpleStringProperty();
    private StringProperty duration = new SimpleStringProperty();

    private String artwork;
    private String releaseDate;

    /**
     * Instantiate a new song based on a uri path
     * @param songPath
     */
    public Song(String songPath) {
        this.songPath = songPath;
        MapChangeListener<String, Object> listenerObj = this;

        /**
         * The media information is obtained asynchronously and so not necessarily available immediately after instantiation of the class.
         * All information should however be available if the instance has been associated with a MediaPlayer
         * and that player has transitioned to Status.READY status
         */
        try {
            media = new Media(songPath); //using JavaFx Media, create from the address of the song file

            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setOnReady(() -> {
                metadata = media.getMetadata();
                metadata.addListener(listenerObj);
                name.setValue((String) metadata.get("title"));
                artist.setValue((String) metadata.get("artist"));
                duration.setValue(media.getDuration().toString());
            });
        }
        catch(Exception ex){
            System.out.println("Could not initialize the media at path: " + songPath);
        }
    }

    /**
     * For debugging
     * @param name
     * @param artist
     * @param duration
     */
    public Song(String name, String artist, String duration) {
        this.name.setValue(name);
        this.artist.setValue(artist);
        this.duration.setValue(duration);
    }

    public Song(String name, String artist, String duration, String artwork, String releaseDate) {
        //this.name = name;
        //this.artist = artist;
        //this.duration = duration;
    }

    public String getPath(){
        return songPath;
    }

    public StringProperty getName() {
        return name;
    }

    public StringProperty getArtist() {
        return artist;
    }

    public StringProperty getDuration() {
        return duration;
    }

    public Media getMedia(){
        return media;
    }

    public MediaPlayer getMediaPlayer() { return mediaPlayer; }

    /**
     * Tracks updates to the observable metadata map and updates song fields conditionally
     * @param change - an object representing an elementary change to the observable list
     */
    @Override
    public void onChanged(Change<? extends String, ?> change) {
        change.getKey(); //Get the key associated with what changed
        if(change.wasAdded()){ //If a new value was added
            String key = change.getKey();

            if(key.equals("title")){
                name.setValue((String)change.getValueAdded());
            }
            else if(key.equals("artist")){
                artist.setValue((String)change.getValueAdded());
            }
            else{
                //System.out.println(change.getValueAdded());
            }
        }
    }
}
