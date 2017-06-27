package me.mach0319.test_mp3_3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView txtView;
    TextView txtVieww;
    long totalDuration = mediaPlayer.getDuration();
    long currentDuration = mediaPlayer.getCurrentPosition();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView)findViewById(R.id.txt);
        txtVieww = (TextView)findViewById(R.id.txtt);

        txtView.setText(milliSecondsToTimer(currentDuration));
        txtVieww.setText(milliSecondsToTimer(totalDuration));
    }


    public void start(View view) {
        if(mediaPlayer==null)
            mediaPlayer = MediaPlayer.create(this,R.raw.music);

        mediaPlayer.start();

    }

    public void pause(View view) {
        mediaPlayer.pause();
    }

    public void stop(View view) {
        mediaPlayer.stop();
        mediaPlayer=null;
    }



    public String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

// Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
// Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

// Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        }   else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

// return timer string
        return finalTimerString;
    }

}
