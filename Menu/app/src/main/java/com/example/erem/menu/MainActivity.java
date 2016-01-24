package com.example.erem.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1=(Button)findViewById(R.id.btncon);
        registerForContextMenu(btn1);




        Button btn=(Button)findViewById(R.id.btnpop);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final PopupMenu menu=new PopupMenu(getApplicationContext(),v);
                menu.inflate(R.menu.popup);
                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        int id=item.getItemId();

                        if(id==R.id.pop1)
                            Toast.makeText(getApplicationContext(),"1.secildi",Toast.LENGTH_SHORT).show();

                        else if(id==R.id.exit)
                            finish();
                        return false;
                    }
                });
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.benimmenum,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.sec1)
        {
            Toast.makeText(getApplicationContext(),"1.seçenek seçildi...",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.sec2)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.con1)
            Toast.makeText(getApplicationContext(),"1.seçeneke seçildi",Toast.LENGTH_SHORT) .show();
        else if(id == R.id.exitcontext)
            finish();
        return super.onContextItemSelected(item);
    }
}
