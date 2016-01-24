package com.example.erem.oo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener
{

    int count;Button btn;SharedPreferences preferences,ayarlar;RelativeLayout arka;
    //private AdView adView;
    Boolean ses_durumu,titresim_durumu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.sayac);
        arka=(RelativeLayout)findViewById(R.id.rl);
        preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ayarlar= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final  MediaPlayer ses=MediaPlayer.create(getApplicationContext(),R.raw.btnsesi);
        final Vibrator titre= (Vibrator) getSystemService(VIBRATOR_SERVICE);
       //reklamiyukle();
        ayarlariyukle();
        count=preferences.getInt("count_anahtari", 0);
        btn.setText(""+count);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ses_durumu){
                    ses.start();
                }
                if (titresim_durumu)
                {
                    titre.vibrate(250);
                }
                count=count+1;
                btn.setText(""+count);



            }
        });

    }

  /* private void reklamiyukle() {

    adView= new AdView(this);
    adView.setAdSize(AdSize.BANNER);
    adView.setAdUnitId(getString(R.string.reklam_kimligi));
    LinearLayout reklam=(LinearLayout)findViewById(R.id.reklamım);
    reklam.addView(adView);
    AdRequest adrequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
    adView.loadAd(adrequest);

    Sonra permisson vercez onlar şunlar:

    1-)<uses-permission android:name="android.permission.INTERNET"/>
    2-)<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

devam
application satırını bitip activity nin başladığı yerde

<meta-data
android:name="com.google.android.gms.version"
android:value=@integer/google_play_services_version/>
<activity
android:name="com.google.android.gms.AdActivity"
android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize"/>



}
    */

    private void ayarlariyukle()
    {
        String pos=ayarlar.getString("arkaplan","3");
        switch (Integer.valueOf(pos))
        {
            case 0:
                arka.setBackgroundResource(R.drawable.arkaplanim);
                break;
            case 1:
                arka.setBackgroundColor(Color.RED);
                break;
            case 2:
                arka.setBackgroundColor(Color.BLACK);
                break;
            case 3:
                arka.setBackgroundColor(Color.WHITE);
                break;
            case 4:
                arka.setBackgroundColor(Color.GRAY);
                break;
        }
        ses_durumu=ayarlar.getBoolean("ses",false);
        titresim_durumu=ayarlar.getBoolean("titresim",false);
        ayarlar.registerOnSharedPreferenceChangeListener(MainActivity.this);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.Ayar)
        {
            Intent intent=new Intent(getApplicationContext(),Ayarlar.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.Sıfır)
        {
            count=0;
            btn.setText(""+count);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("count_anahtari",count);
        editor.commit();
        super.onPause();

    }
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        ayarlariyukle();
    }

}
