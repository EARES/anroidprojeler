package com.brotherssoftware.button_image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}

//ImageButton ımg = (ImageButton)findViewById(R.id.ileri);
//ImageButton ımg2= (ImageButton)findViewById(R.id.geri);

// ımg.setOnClickListener(new View.OnClickListener() {
//   @Override
// public void onClick(View v) {

//   Toast.makeText(getApplicationContext(),"İleri Gidilcek",Toast.LENGTH_SHORT).show();
//  }
//});

//ımg2.setOnClickListener(new View.OnClickListener() {
//  @Override
//   public void onClick(View v) {
//
//     Toast.makeText(MainActivity.this, "Geri Gidilecek", Toast.LENGTH_SHORT).show();
//    }
//  });