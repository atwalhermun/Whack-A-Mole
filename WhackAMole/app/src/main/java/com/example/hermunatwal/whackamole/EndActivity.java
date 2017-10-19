package com.example.hermunatwal.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.hermunatwal.whackamole.R.id.exit;
import static com.example.hermunatwal.whackamole.R.id.reset;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        MediaPlayer bg= MediaPlayer.create(EndActivity.this,R.raw.back);
        bg.start();
        TextView scored = (TextView) findViewById(R.id.text);
        scored.setText("Game Over! Score: " +MainActivity.score);
        Button button = (Button) findViewById(reset);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EndActivity.this, MainActivity.class));
            }
        });
        Button button1 = (Button) findViewById(exit);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}
