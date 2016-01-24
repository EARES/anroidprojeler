package com.example.erem.denemem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class sonactivty extends AppCompatActivity {
    Button btnm;
    CheckBox chek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonactivty);

        btnm=(Button)findViewById(R.id.btn);
        chek=(CheckBox)findViewById(R.id.chek);



    }
    public void Tiklendi(View v)
    {
        Boolean durum=((CheckBox)v).isChecked();
        if (durum)
            btnm.setEnabled(true);
        else
            btnm.setEnabled(false);

    }


}
