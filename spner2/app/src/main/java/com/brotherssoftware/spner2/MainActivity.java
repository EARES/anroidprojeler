package com.brotherssoftware.spner2;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner sp= (Spinner) findViewById(R.id.spn);
        final RelativeLayout rld= (RelativeLayout) findViewById(R.id.rlde);
         final String renkler[]=getResources().getStringArray(R.array.Renkler);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.gorunum,renkler);
        Button btn = (Button) findViewById(R.id.buton);
        sp.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pozisyon =sp.getSelectedItemPosition();
                Toast.makeText(getApplicationContext(),"secilen renk:"+renkler[pozisyon],Toast.LENGTH_LONG).show();
            }
        });



    }
}
/*sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                switch (position){
                    case 0:rld.setBackgroundColor(Color.WHITE);break;
                    case 1:rld.setBackgroundColor(Color.BLACK);break;
                    case 3:rld.setBackgroundColor(Color.RED);break;
                    case 4:rld.setBackgroundColor(Color.BLUE);break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/