package com.lyadirga.mailuygulamasi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class ActivityIcerik extends AppCompatActivity{

    MailIcerikFragment mailIcerikFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        int pozisyon=getIntent().getIntExtra("pozisyon",0);
        mailIcerikFragment=new MailIcerikFragment(pozisyon);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content,mailIcerikFragment);
        transaction.commit();


    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mailIcerikFragment !=null){
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.remove(mailIcerikFragment);
            transaction.commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId()==android.R.id.home){

            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
