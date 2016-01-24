package com.example.erem.deneme;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int count;
    SharedPreferences sharedPreferences;

    @Override
    protected void onPause() {
        SharedPreferences.Editor ed=sharedPreferences.edit();
        ed.putInt("count_anahtari",count);
        ed.commit();
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn=(Button)findViewById(R.id.buttonum);
        final Button btn2=(Button)findViewById(R.id.sıfır);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

count=sharedPreferences.getInt("count_anahtari",0);
        btn.setText(""+count);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count=count+1;
                btn.setText(""+count);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count=0;
                btn.setText(""+count);
            }
        });
    }


}
