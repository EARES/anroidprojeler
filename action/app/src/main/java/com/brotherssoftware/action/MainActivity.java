package com.brotherssoftware.action;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    ListView lw;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String personel[]=getResources().getStringArray(R.array.Adlar);
        lw=(ListView)findViewById(R.id.lis);
        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.listemiz,personel);
        lw.setAdapter(adapter);
        registerForContextMenu(lw);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo menuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {
            case R.id.sil:

                TextView tv=(TextView)menuInfo.targetView;
                Toast.makeText(getApplicationContext(),"Secilen eleman:"+tv.getText().toString(),Toast.LENGTH_SHORT).show();
                return true;

            case R.id.paylas:
                return true;

            case R.id.duzenle:
                return true;


        }
        return super.onContextItemSelected(item);

    }

}
