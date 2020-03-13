package app.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A curated list of songs from the user
 */
public class Playlist {
    private String name;
    private ArrayList<Song> myPlaylist;

    public Playlist(){
        name = "Library";
        myPlaylist = new ArrayList<Song>();
    }
    public Playlist(ArrayList<Song> myPlaylist){
        name = "Library";
        this.myPlaylist = myPlaylist;
    }

    /**
     *
     * @return
     */
    public ArrayList<Song> getSongs(){
        return myPlaylist;
    }

    public void addNewSong(String musicPath){
        Song song = new Song(musicPath);
        myPlaylist.add(song);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
