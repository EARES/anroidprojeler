package com.example.erem.dosyayukleme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText metingirisi;
    private final String DOSYAADI="dosya.txt";
    private final String DIZINISMI="birdizin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metingirisi=(EditText)findViewById(R.id.editText);
    }
    public  void onButtonClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnm:
            try{
                File dizin=getDir(DIZINISMI,MODE_PRIVATE);
                File dosya=new File(dizin,DOSYAADI);
                FileInputStream fileIn=new FileInputStream(dosya);
                try{
                    dateiLaden(fileIn);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }
                break;

        }
    }

    private void dateiLaden(FileInputStream fileIn) throws IOException{
        BufferedReader fileInBuffer=new BufferedReader(new InputStreamReader(fileIn));
        String text="";
        String satir;
        try
        {
            while((satir=fileInBuffer.readLine())!=null)
            {
                text +=satir;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            fileInBuffer.close();
        }
        metingirisi.setText(text);
    }

}
