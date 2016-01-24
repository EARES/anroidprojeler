package com.example.erem.dosyaislemi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText metingirisi;
    private final String DOSYAADI="dosya.txt";
    private final String DIZINISMI="birdizin.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metingirisi=(EditText)findViewById(R.id.veri);
    }
    public  void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.kaydet:
                try {
                    File dizin = getDir(DIZINISMI, MODE_PRIVATE);
                    File dosya = new File(dizin, DOSYAADI);
                    FileOutputStream fileout = new FileOutputStream(dosya);
                    try {
                        dosyaKaydet(fileout);
                        metingirisi.setText("Dosya Kaydedildi.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



    private void dosyaKaydet(FileOutputStream fileout) throws IOException
    {
        OutputStreamWriter writer=new OutputStreamWriter(fileout);
        String metin=metingirisi.getText().toString();
    try
    {
        writer.write(metin);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
        finally {
        if (writer != null)
        {
            writer.close();
        }
    }
    }
    }
