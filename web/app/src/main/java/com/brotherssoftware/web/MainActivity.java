package com.brotherssoftware.web;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final TextView tt= (TextView) findViewById(R.id.tv);

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=hPlCe8cVqCA&list=PL9qDMO9EzLX25NTHm0q7svKLx__OZY8-e&index=40"));
               startActivity(intent);
            }
        });
    }
}
