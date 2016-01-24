package com.brotherssoftware.veri_tasima;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class digerindigeri extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digerindigeri);
        TextView tv= (TextView) findViewById(R.id.textView2);
        Bundle gelenveri=getIntent().getExtras();
        CharSequence gelenyazi=gelenveri.getCharSequence("anahtar");
        tv.setText(gelenyazi);
    }
}
