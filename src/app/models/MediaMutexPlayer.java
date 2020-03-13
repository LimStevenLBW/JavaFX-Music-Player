package app.models;

import javafx.collections.ObservableMap;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Singleton class wrapper for the fx mediaplayer
 */
public class MediaMutexPlayer {
    private static MediaMutexPlayer single_instance = null;

    private OnCurrentSongEventListener songEventListener;
    private boolean isSongPlaying;
    private double volume = 0.1;
    private MediaPlayer mediaPlayer;

    private MediaMutexPlayer(){

    }

    public static MediaMutexPlayer getInstance() {
        if(single_instance == null){
            single_instance = new MediaMutexPlayer();
        }
        return single_instance;
    }

    public void registerSongEventListener(OnCurrentSongEventListener songEventListener){
        this.songEventListener = songEventListener;
    }

    public void playSong(Song song){
        if(isSongPlaying) {
            stopSong();
        }

        mediaPlayer = new MediaPlayer(song.getMedia());
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
        isSongPlaying = true;

        songEventListener.onCurrentSongNameUpdate(song.getName());
        songEventListener.onCurrentSongArtistUpdate(song.getArtist());
    }

    public void stopSong(){
        mediaPlayer.stop();
        isSongPlaying = false;
    }

}
