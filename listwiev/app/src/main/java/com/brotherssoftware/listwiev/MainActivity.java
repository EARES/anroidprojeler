package com.brotherssoftware.listwiev;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lt = (ListView) findViewById(R.id.listView);
        String iller[]=getResources().getStringArray(R.array.iller);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.listemiz,iller);
        lt.setAdapter(adapter);


        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"Secilen elemanın indisi"+position,Toast.LENGTH_LONG).show();

            }
        });
    }
}
