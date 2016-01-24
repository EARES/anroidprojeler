package com.example.erem.oo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by erem on 22.12.2015.
 */
public class Ayarlar extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.ayarlar);
    }
}
