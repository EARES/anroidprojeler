package com.example.erem.denemem;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton img1;
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView autom=(AutoCompleteTextView)findViewById(R.id.auto);
        MultiAutoCompleteTextView multim=(MultiAutoCompleteTextView)findViewById(R.id.multi);
        String [] cihaz=getResources().getStringArray(R.array.Cihazlar);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,cihaz);
        autom.setAdapter(adapter);
        multim.setAdapter(adapter);
        multim.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        Button btnm=(Button)findViewById(R.id.btn);
       final  EditText ed=(EditText)findViewById(R.id.ed);
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str=ed.getText().toString();
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();


            }
        });



        img1 = (ImageButton) findViewById(R.id.imgm);
        btn=(Button)findViewById(R.id.tst);
        btn2=(Button)findViewById(R.id.special);

        findViewById(R.id.imgm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        ImageView imgem = new ImageView(MainActivity.this);
        imgem.setImageResource(R.drawable.k);
        Toast tt = new Toast(MainActivity.this);
        tt.setView(imgem);
        tt.setDuration(Toast.LENGTH_SHORT);
        tt.show();


    }
});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tt=new TextView(MainActivity.this);
                tt.setText("Bu bir özel mesajdır.");
                tt.setPadding(10,14,20,20);
                tt.setTextColor(Color.RED);
                tt.setBackgroundColor(Color.BLACK);
                Toast te=new Toast(MainActivity.this);
                te.setDuration(Toast.LENGTH_LONG);
                te.setView(tt);
                te.show();


            }
        });




       /* btnm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"1.Butona Dokundun:D",Toast.LENGTH_SHORT).show();

            }
        });
        btnm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"2.Butona Dokunuldu",Toast.LENGTH_SHORT).show();

            }
        });
        btnm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"3.Butona Dokunuldu",Toast.LENGTH_SHORT).show();

            }
        });*/
    }
}
