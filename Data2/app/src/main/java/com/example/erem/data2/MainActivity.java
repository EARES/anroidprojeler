package com.example.erem.data2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tabhost;
    TabHost.TabSpec t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost = (TabHost) findViewById(R.id.tabHost);
        tabhost.setup();

        t1 = tabhost.newTabSpec("1");
        t1.setIndicator("Yemekler1");
        t1.setContent(R.id.linearLayout);


        t2 = tabhost.newTabSpec("2");
        t2.setIndicator("Yemekler2");
        t2.setContent(R.id.linearLayout2);

        t3 = tabhost.newTabSpec("3");
        t3.setIndicator("Yemekler3");
        t3.setContent(R.id.linearLayout3);

        tabhost.addTab(t1);
        tabhost.addTab(t2);
        tabhost.addTab(t3);

        tabhost.setCurrentTab(1);
        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
}
