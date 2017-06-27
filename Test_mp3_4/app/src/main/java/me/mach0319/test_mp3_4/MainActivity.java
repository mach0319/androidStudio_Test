package me.mach0319.test_mp3_4;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView,qwe;
    Button bu;
    MediaPlayer mMedia;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView)findViewById(R.id.txt);
        qwe = (TextView)findViewById(R.id.qwe);
        bu = (Button)findViewById(R.id.button);
        final MediaPlayer mMedia = MediaPlayer.create(MainActivity.this,R.raw.music);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMedia.isPlaying()) {
                    txtView.setText("Playing : music.mp3....");
                    mMedia.pause();
                } else {
                    txtView.setText("pause : music.mp3....");
                    mMedia.start();
                    qwe.post(mUpdateTime);
                }

            }
        });


    }


    public Runnable mUpdateTime = new Runnable() {
        public void run() {
            int currentDuration;
            if (mMedia.isPlaying()) {
                currentDuration = mMedia.getCurrentPosition();
                updatePlayer(currentDuration);
                qwe.postDelayed(this, 1000);
            }else {
                qwe.removeCallbacks(this);
            }
        }
    };

    public void updatePlayer(int currentDuration){
        qwe.setText("" + milliSecondsToTimer((long) currentDuration));
    }

    /**
     * Function to convert milliseconds time to Timer Format
     * Hours:Minutes:Seconds
     * */
    public  String milliSecondsToTimer(long milliseconds) {
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
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }
}
