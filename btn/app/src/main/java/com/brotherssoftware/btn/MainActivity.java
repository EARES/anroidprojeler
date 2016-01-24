package com.brotherssoftware.btn;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id= v.getId();
        switch (id)//switch(v.getId()) de olur...
        {
            case R.id.button:
                Toast.makeText(getApplicationContext(),"1.Butona Dokunuldu",Toast.LENGTH_LONG).show();
                break;

            case R.id.button2:
                Toast.makeText(getApplicationContext(),"2.Butona Dokunuldu",Toast.LENGTH_LONG).show();
                break;

            case  R.id.button3:
                Toast.makeText(getApplicationContext(),"3.Butona Dokunuldu",Toast.LENGTH_LONG).show();
                break;
        }
    }
}

//Bu yol implement yoludur.1.Yol msq örneğinde var.
//3. yol ise:
//Xml kısmında onclick olayında mesajı yazarız yani "butona dokunuldu" sonra kod kısmında ise:
//public void BtnDknldu(View v)
//{ switch(v.getId())
//case R.id.Button:
//  Toast.makeText(getApplicationContext(),"1 butona dokunuldu",Toast.LENGHT_LONG).show();
//break;
//Böyle devam etcek caseler...