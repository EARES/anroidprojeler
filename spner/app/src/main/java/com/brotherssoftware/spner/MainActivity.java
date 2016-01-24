package com.brotherssoftware.spner;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp = (Spinner) findViewById(R.id.spin);
        final RelativeLayout zemin= (RelativeLayout) findViewById(R.id.rl);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        zemin.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:zemin.setBackgroundColor(Color.BLUE);
                        break;
                    case 2:zemin.setBackgroundColor(Color.BLACK);
                        break;
                    case 3:zemin.setBackgroundColor(Color.CYAN);
                        break;
                    case 4: zemin.setBackgroundColor(Color.WHITE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
