package com.nizar4790k.androidmusicplayer.main.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nizar4790k.androidmusicplayer.R;
import com.spotify.android.appremote.api.ConnectionParams;

import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.types.Artist;
import com.spotify.protocol.types.Track;

public class MainActivity extends AppCompatActivity {

    private static final String CLIENT_ID = "fb38a5ab81c947c7ac053ce21a289bbe";
    private static final String REDIRECT_URI ="http://localhost:8888/callback/";
    private SpotifyAppRemote mSpotifyAppRemote;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

    @Override
    protected void onStart() {
        super.onStart();

        ConnectionParams connectionParams = new ConnectionParams.Builder(CLIENT_ID)
                .setRedirectUri(REDIRECT_URI)
                .showAuthView(true)
                .build();




        SpotifyAppRemote.connect(this,connectionParams,new Connector.ConnectionListener(){

            @Override
            public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                mSpotifyAppRemote=spotifyAppRemote;
                Log.d("MainActivity", "Connected! Yay!");


                mSpotifyAppRemote.getPlayerApi()
                        .subscribeToPlayerState()
                        .setEventCallback(playerState -> {
                            final Track track = playerState.track;
                            if (track != null) {
                                Log.d("MainActivity", track.name + " by " + track.artist.name);

                            }
                        });






            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("MainActivity", throwable.getMessage(), throwable);
            }


        });





    }


}
