package com.example.erem.media;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer player = MediaPlayer.create(this, R.raw.k);
        Button btncal = (Button) findViewById(R.id.btncal);
        Button btndur = (Button) findViewById(R.id.btnDur);
        Button btnoyna = (Button) findViewById(R.id.btnoyna);
        Button btnoynav = (Button) findViewById(R.id.btnOyna2);
        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.start();
            }
        });
        btndur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                player.pause();
            }
        });
        btnoyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent yu = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uhmxF2vGUdw"));
                startActivity(yu);
            }
        });
        btnoynav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                VideoView view = (VideoView) findViewById(R.id.videoView);
                view.setVideoPath("/sd/video1.mp4");
                view.start();
            }
        });
        findViewById(R.id.gec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

    }
}
