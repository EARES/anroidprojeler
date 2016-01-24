package com.brotherssoftware.telefon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText= (EditText) findViewById(R.id.et);
        final ImageView img= (ImageView) findViewById(R.id.iw);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText())) {
                    Intent ıntent = new Intent(Intent.ACTION_CALL, Uri.parse("Tel: " + editText.getText().toString()));
                    startActivity(ıntent);
                }
                else
                    Toast.makeText(getApplicationContext(),"Tel nosu giriniz...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
