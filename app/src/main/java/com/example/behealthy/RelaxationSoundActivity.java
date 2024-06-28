package com.example.behealthy;
import com.example.behealthy3.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RelaxationSoundActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation_sound);

        // Initialize MediaPlayer with a relaxation sound file
      //  zmediaPlayer = MediaPlayer.create(this, R.raw.relaxation_sound);

        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pauseSound();
                } else {
                    playSound();
                }
            }
        });
    }

    private void playSound() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            playButton.setText("Pause");
            isPlaying = true;
        }
    }

    private void pauseSound() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playButton.setText("Play");
            isPlaying = false;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
