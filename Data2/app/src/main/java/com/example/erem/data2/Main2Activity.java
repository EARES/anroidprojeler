package com.example.erem.data2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ArrayList<String> dizi =new ArrayList<String>();
        final ListView lstvw=(ListView)findViewById(R.id.listem);
        Button btnekle=(Button)findViewById(R.id.btnEkle);
        final EditText et=(EditText)findViewById(R.id.editText);
        dizi.add("Emre");
        dizi.add("Apo");
        dizi.add("ıSO");
        final ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,dizi);
        lstvw.setAdapter(adapter);
        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dizi.add(et.getText().toString());
                lstvw.setAdapter(adapter);
            }
        });
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
