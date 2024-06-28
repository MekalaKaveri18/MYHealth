package com.example.behealthy;
import com.example.behealthy3.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // Example: Play Meditation Music Video
        playVideo("uTN29kj7e-w");
    }

    private void playVideo(String videoId) {
        // Replace with your video activity logic using YouTube API or other methods
        Toast.makeText(this, "Playing Meditation Music with ID: " + videoId, Toast.LENGTH_SHORT).show();

        // Intent to play YouTube video using YouTube app or browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videoId));
        intent.putExtra("force_fullscreen", true); // Optional: Force fullscreen playback
        intent.putExtra("finish_on_ended", true); // Optional: Finish activity when video ends
        startActivity(intent);
    }
}
