package me.mach0319.jungall;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String AUDIO_URL="https://www.youtube.com/embed/q4e5zF--ZTU";

    private MediaPlayer mediaPlayer;
    private int playbackPosition = 0;
    Button startBtn,pauseBtn,restartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn =(Button)findViewById(R.id.playBtn);
        pauseBtn =(Button)findViewById(R.id.pauseBtn);
        restartBtn = (Button)findViewById(R.id.restartBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    playAudio(AUDIO_URL);

                    Toast.makeText(getApplicationContext(),"재생시작",Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    e.printStackTrace();

                }
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer !=null){
                    playbackPosition = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(),"음악 파일 재생 중지됨",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void playAudio(String url)throws Exception{
        killMediaPlayer();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare();
        mediaPlayer.start();

    }

    protected void onDestroy(){
        super.onDestroy();
        killMediaPlayer();
    }

    private void killMediaPlayer() {
        if(mediaPlayer != null){
            try{
                mediaPlayer.release();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


}
