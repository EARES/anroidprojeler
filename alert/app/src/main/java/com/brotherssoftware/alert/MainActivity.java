package com.brotherssoftware.alert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private static final int ALERT_DIALOG_ID=0;
    private static final int ALERT_DIALOG_LISTE_ID=1;
    private static final int CUSTOM_DIALOG_ID=2;
    String renkler[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        renkler= new String[]{"sarı","kırmızı","yeşil","mavi","mor"};
    }



    public void ButonaDokunuldu(View v)
    {
        switch (v.getId())
        {
            case R.id.alert:
//            AlertDialog.Builder builder=new AlertDialog.Builder(this);
//            builder.setTitle("Uyarı!!!");
//            builder.setMessage("Eminmisin ?");
//            builder.setIcon(android.R.drawable.alert_dark_frame);
//
//                builder.setCancelable(false);
//                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        dialog.dismiss();
//                    }
//                });
//
//                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                        dialog.cancel();
//                    }
//                });
//            AlertDialog alertDialog=builder.create();
//            alertDialog.show();
                showDialog(ALERT_DIALOG_ID);
            break;

            case R.id.cstmalertbtn:
                showDialog(CUSTOM_DIALOG_ID);

                break;

            case R.id.lstealrt:
                showDialog(ALERT_DIALOG_LISTE_ID);

                break;


        }
    }
    @Override
    protected Dialog onCreateDialog(int id)
    {

        switch (id)
        {
            case ALERT_DIALOG_ID:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Uyarı!!!");
                builder.setMessage("Eminmisin ?");
                builder.setIcon(android.R.drawable.alert_dark_frame);

                builder.setCancelable(false);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();

                return alertDialog;

            case ALERT_DIALOG_LISTE_ID:
                AlertDialog.Builder build=new AlertDialog.Builder(this);
                build.setTitle("Renkleriniz:");
                build.setItems(renkler, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Seçilen Renk:" + renkler[which], Toast.LENGTH_SHORT).show();

                    }
                });
                AlertDialog dialogum= build.create();
                return  dialogum;

            case CUSTOM_DIALOG_ID:
                final Dialog dialog2=new Dialog(this);
                dialog2.setTitle("Custom Dialog");
                dialog2.setContentView(R.layout.custom_dialog);
                Button kaydet=(Button)dialog2.findViewById(R.id.btn_kaydet);
                Button vacgec=(Button)dialog2.findViewById(R.id.btn_vazgec);
                DatePicker dp=(DatePicker)dialog2.findViewById(R.id.datePickerim);
                kaydet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
                vacgec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog2.cancel();
                    }
                });

                return dialog2;
                default:
                    return super.onCreateDialog(id);
        }


    }
}
