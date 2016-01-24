package com.example.erem.progses_diolog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1=(Button)findViewById(R.id.btnileri);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ProgressDialog ileri= new ProgressDialog(MainActivity.this);
                ileri.setTitle("Başlık");
                ileri.setMessage("İçerik");
                ileri.show();
            }
        });
    }
}
