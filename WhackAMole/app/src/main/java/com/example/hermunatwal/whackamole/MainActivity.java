package com.example.hermunatwal.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.hermunatwal.whackamole.R.drawable.hole;
import static com.example.hermunatwal.whackamole.R.drawable.mole;

public class MainActivity extends AppCompatActivity {
    public static int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer bg= MediaPlayer.create(MainActivity.this,R.raw.back);
        bg.start();
        new CountDownTimer(120000, 1000) {
            TextView time = (TextView) findViewById(R.id.time);
            public void onTick(long millisUntilFinished) {
                time.setText("Time: "+millisUntilFinished / 1000);
            }
            public void onFinish() {
                startActivity(new Intent(MainActivity.this, EndActivity.class));
            }
        }.start();
        score=0;
        final ImageButton buttons [] = {(ImageButton)findViewById(R.id.hole1),(ImageButton)findViewById(R.id.hole2),(ImageButton)findViewById(R.id.hole3),
                (ImageButton)findViewById(R.id.hole4),(ImageButton)findViewById(R.id.hole5),(ImageButton)findViewById(R.id.hole6),
                (ImageButton)findViewById(R.id.hole7),(ImageButton)findViewById(R.id.hole8),(ImageButton)findViewById(R.id.hole9)};
        spawnMole(buttons);
    }
    public void spawnMole(ImageButton buttons []){
        int holes = (int)(9*Math.random());
        final ImageButton temp = buttons[holes];
        temp.setBackgroundResource(mole);
        temp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageButton buttonss [] ={(ImageButton)findViewById(R.id.hole1),(ImageButton)findViewById(R.id.hole2),(ImageButton)findViewById(R.id.hole3),
                        (ImageButton)findViewById(R.id.hole4),(ImageButton)findViewById(R.id.hole5),(ImageButton)findViewById(R.id.hole6),
                        (ImageButton)findViewById(R.id.hole7),(ImageButton)findViewById(R.id.hole8),(ImageButton)findViewById(R.id.hole9)};
                final MediaPlayer s=MediaPlayer.create(MainActivity.this,R.raw.whack);
                s.start();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        s.release();
                    }
                }, 1000);
                score++;
                temp.setBackgroundResource(hole);
                TextView scored = (TextView) findViewById(R.id.score);
                scored.setText("Score: " +score);
                spawnMole(buttonss);
            }
        });
    }
}
