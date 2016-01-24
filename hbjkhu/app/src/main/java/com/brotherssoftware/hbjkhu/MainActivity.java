package com.brotherssoftware.hbjkhu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Tiklandi(View v)
    {
        if (v.getId()==R.id.button) //butona tıklanmışsa
        {
            //2.ekreana geçiçek
            Intent intend = new Intent(getApplicationContext(),ikinciekran.class);
            //Intent:istek anlamına gelir
            startActivity(intend);

        }
    }
}
