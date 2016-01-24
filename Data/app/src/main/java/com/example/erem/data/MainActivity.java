package com.example.erem.data;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2,btn3,btn4,btn5,btn6;
    TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> listem = new ArrayList<String>();
        final ArrayList<String> eleman = new ArrayList<String>();
        eleman.add("Diğer dizi1");
        eleman.add("Diğer dizi2");
        btn2 = (Button) findViewById(R.id.btnAray);
        btn3 = (Button) findViewById(R.id.btnSil);
        btn4 = (Button) findViewById(R.id.btnKopyala);
        btn5 = (Button) findViewById(R.id.btnAra);
        btn6 = (Button) findViewById(R.id.btnEleman);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listem.add("istanbul");
                listem.add("izmir");
                listem.add("Elazig");
                for (String Sehir : listem) {
                    Toast.makeText(getApplicationContext(), Sehir, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listem.remove(1);//1.değerdeki bilgiyi siler...
                //listem.clear();//Dizinin hepsini siler...
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eleman.addAll(listem);
                for (String dizi : eleman) {
                    Toast.makeText(getApplicationContext(), dizi, Toast.LENGTH_SHORT).show();
                }
            }
        });
        final EditText ed = (EditText) findViewById(R.id.araedit);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listem.indexOf(ed.getText().toString()) < 0) {
                    Toast.makeText(getApplicationContext(), "Aranan değer bulunamadı...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), String.valueOf(listem.indexOf(ed.getText().toString())), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Dizinin eleman sayisi:" + String.valueOf(listem.size()), Toast.LENGTH_SHORT).show();
            }
        });
        tt = (TextView) findViewById(R.id.txtalert);
        btn = (Button) findViewById(R.id.btnAlert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this).setTitle("Bu bir alert diologdur...").setMessage("İçerik:D").setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tt.setText("Evet denildi");

                    }
                })
                        .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tt.setText("Hayır Denildi.");

                            }
                        })
                        .setNeutralButton("İptal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tt.setText("İptal Edildi Muck");

                            }
                        }).show();
            }
        });
        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, diger.class));
            }
        });

    }
}
