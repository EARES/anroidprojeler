package com.example.erem.media;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        final Button btnters=(Button)findViewById(R.id.btnTers);
        btnters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnters.setRotation(btnters.getRotation()+10);
            }
        });
        final Button btnyd=(Button)findViewById(R.id.btnYD);
        btnyd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnyd.setX(btnyd.getX()+10);
            }
        });

    }
}
