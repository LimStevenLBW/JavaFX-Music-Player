package app.models;

import javafx.beans.property.StringProperty;

public interface OnCurrentSongEventListener {
    void onCurrentSongNameUpdate(StringProperty name);
    void onCurrentSongArtistUpdate(StringProperty name);
    void onCurrentSongImageUpdate(String image);
}
