package com.brotherssoftware.edit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView auto =(AutoCompleteTextView) findViewById(R.id.ac);
        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView) findViewById(R.id.mac);

        String [] cihaz= getResources().getStringArray(R.array.cihazlar);

        ArrayAdapter<String> adaptörüm= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,cihaz);

        auto.setAdapter(adaptörüm);
        multi.setAdapter(adaptörüm);

        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        Button btn= (Button)findViewById(R.id.btn);
        final EditText ed= (EditText)findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= ed.getText().toString();
               // int i= Integer.valueOf(str);//Sayısal için int türüne dönüştürüyoruz
               // String s= String.valueOf(str);//String için doublea döüştürüyo
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();


            }
        });
    }
}
