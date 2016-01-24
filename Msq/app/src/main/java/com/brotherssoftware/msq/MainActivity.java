package com.brotherssoftware.msq;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.Channels;

public class MainActivity extends AppCompatActivity {
Button btn,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.toast);
        btn2= (Button) findViewById(R.id.resim);
        btn3=(Button) findViewById(R.id.speccial);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Bilgileriniz alınmıştır...",Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ImageView ımg = new ImageView(MainActivity.this);
                ımg.setImageResource(R.drawable.k);
                Toast tt = new Toast(MainActivity.this);
                tt.setView(ımg);
                tt.setDuration(Toast.LENGTH_LONG);
                tt.show();



            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tt = new TextView(getApplicationContext());
                tt.setText("Bu bir özel mesajdır");
                tt.setTextColor(Color.BLUE);
                tt.setBackgroundColor(Color.YELLOW);
                Toast toast = new Toast(getApplicationContext());
                toast.setView(tt);
                tt.setPadding(20,14,20,20);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }

}



