package com.brotherssoftware.cekbox;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    Button kaydet;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kaydet = (Button) findViewById(R.id.btn);
        cb = (CheckBox) findViewById(R.id.cb);
    }
public void Tiklendi(View v)
    {

Boolean durum=((CheckBox)v).isChecked();
        if(durum==true)
            kaydet.setEnabled(true);
        else
            kaydet.setEnabled(false);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kaydet.setEnabled(false);
                cb.setChecked(false);
            }
        });
    }

    }
//Aşağıdaki şekildede olur
/* cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean durum = cb.isChecked();
                if (durum==true)//if(durum) da olur çünkü sadece true false var
                    kaydet.setEnabled(true);
                else
                kaydet.setEnabled(false);





            }
        });

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kaydet.setEnabled(false);
                cb.setChecked(false);
            }
        });*/