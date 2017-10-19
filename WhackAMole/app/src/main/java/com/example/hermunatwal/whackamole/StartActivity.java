package com.example.hermunatwal.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MediaPlayer bg= MediaPlayer.create(StartActivity.this,R.raw.back);
        bg.start();
        setContentView(R.layout.activity_start);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }
        });
    }
}
