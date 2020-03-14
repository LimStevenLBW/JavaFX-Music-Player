package app.models;

import javafx.scene.media.MediaPlayer;

/**
 * Singleton class wrapper for the fx media player
 */
public class MediaMutexPlayer {
    private static MediaMutexPlayer single_instance = null;
    private MediaPlayer activePlayer;
    private OnCurrentSongEventListener songEventListener;
    private boolean isSongPlaying;
    private double volume = 0.1;

    private MediaMutexPlayer(){}

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
        if(isSongPlaying) { stopSong(); }

        activePlayer = song.getMediaPlayer();
        activePlayer.setVolume(volume);
        activePlayer.play();
        isSongPlaying = true;

        songEventListener.onCurrentSongNameUpdate(song.getName());
        songEventListener.onCurrentSongArtistUpdate(song.getArtist());
    }

    public void stopSong(){
        activePlayer.stop();
        isSongPlaying = false;
    }

}
