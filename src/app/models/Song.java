package app.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.Media;

/**
 * The basic steps required to play media in Java FX are:
 * 1. Create a Media object for the desired media source.
 * 2. Create a MediaPlayer object from the Media object.
 * 3. Create a MediaView object.
 * 4. Add the MediaPlayer to the MediaView.
 * 5. Add the MediaView to the scene graph.
 * 6. Invoke MediaPlayer.play().
 */
public class Song {
    private Media media;
    private StringProperty name = new SimpleStringProperty();
    private StringProperty artist = new SimpleStringProperty();
    private StringProperty duration = new SimpleStringProperty();

    private String artwork;
    private String releaseDate;

    /**
     * Instantiate a new song based on a uri path
     * @param musicPath
     */
    public Song(String musicPath){
        this.name.setValue(musicPath);
        this.artist.setValue("test");
        this.duration.setValue("test");
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

    public StringProperty getName() {
        return name;
    }

    public StringProperty getArtist() {
        return artist;
    }

    public StringProperty getDuration() {
        return duration;
    }
}
