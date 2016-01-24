package com.brotherssoftware.veri_tasima;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{

    EditText ed;//global atadık

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"geriye bastınız",Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"pauseladı",Toast.LENGTH_SHORT).show();
    }

    public void Tiklendi(View v)
    {
        if (v.getId() == R.id.button)
        {
            Intent intent = new Intent(getApplicationContext(), digerekran.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.button2)
        {

            CharSequence c = ed.getText();//sonuna tostring de koyabiliriz başını sileriz
            if (TextUtils.isEmpty(c))//BU mwthot çok işe yarar boş olup olmadığını kontrol eder.
            {
                Toast.makeText(getApplicationContext(),"Boş Geçilemez!",Toast.LENGTH_SHORT).show();
            }
            else
            {

                Intent intent2 = new Intent(getApplicationContext(), digerindigeri.class);
                intent2.putExtra("anahtar", c);
                startActivity(intent2);
            }

        }
    }
}
