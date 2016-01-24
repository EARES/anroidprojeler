package com.brotherssoftware.paylas;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        Button msjgndr= (Button)findViewById(R.id.msjbtn);
        final EditText ed1=(EditText)findViewById(R.id.adres);
        final EditText ed2=(EditText)findViewById(R.id.konu);
        final EditText ed3=(EditText)findViewById(R.id.msj);
        Button btn2=(Button)findViewById(R.id.msjbtn);
        final TextView tv= (TextView) findViewById(R.id.tw);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence mesaj = tv.getText();
                paylaşmesaj(mesaj);
            }
        });

        msjgndr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence mesaj2 = tv.getText();
                // mesajgönder(mesaj2);
                smsdirektgonder(mesaj2);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String adres=ed1.getText().toString(); diyede yapabiliriz.
                mailgonder(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString());
            }
        });
    }

    private void mailgonder(String adres, String konu, String mesaj) {

        String [] dizi={adres};
        Intent mailıntent=new Intent(Intent.ACTION_SEND);
        mailıntent.setType("message/rfc822");
        mailıntent.putExtra(Intent.EXTRA_EMAIL, dizi);
        mailıntent.putExtra(Intent.EXTRA_SUBJECT,konu);
        mailıntent.putExtra(Intent.EXTRA_TEXT,mesaj);
        try {
            startActivity(mailıntent);
        }
        catch (ActivityNotFoundException hata)
        {
            Toast.makeText(getApplicationContext(),"Hata oluştu\n"+hata.getMessage().toString(),Toast.LENGTH_LONG);

        }



    }

    private void smsdirektgonder(CharSequence mesaj2) {
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage("05346826482",null,mesaj2.toString(),null,null);
    }

    private void mesajgönder(CharSequence mesaj2) {
        Intent ind2= new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:053468264882"));
        ind2.putExtra("sms_body",mesaj2);
        startActivity(ind2);
    }

    private void paylaşmesaj(CharSequence mesaj) {
        Intent ind=new Intent(Intent.ACTION_SEND);
        ind.setType("text/plain");
        ind.putExtra(Intent.EXTRA_TEXT, mesaj);
        startActivity(Intent.createChooser(ind, "Paylaş aga!"));
    }



}
