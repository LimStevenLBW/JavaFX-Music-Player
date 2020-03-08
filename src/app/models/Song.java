package app.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Song {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty artist = new SimpleStringProperty();
    private StringProperty duration = new SimpleStringProperty();

    private String artwork;
    private String releaseDate;

    public Song(){

    }

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
