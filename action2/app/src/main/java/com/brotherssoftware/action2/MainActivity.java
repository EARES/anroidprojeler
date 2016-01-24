package com.brotherssoftware.action2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv= (TextView)findViewById(R.id.tw);
        tv.setText(Html.fromHtml(getResources().getString(R.string.html)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode != null)
                {

                    return false;
            }
                MyActionModeCallBack callBack=new MyActionModeCallBack();
                actionMode=startActionMode(callBack);
                v.setSelected(true);
                return true;
            }

        });
    }

    class MyActionModeCallBack implements ActionMode.Callback
    {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.context_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.düzenle:
                    Toast.makeText(getApplicationContext(),"Düzenleme İşlemi",Toast.LENGTH_LONG).show();
                    mode.finish();
                    return true;
                case R.id.sil:
                    Toast.makeText(getApplicationContext(),"Silme İşlemi",Toast.LENGTH_LONG).show();
                    mode.finish();
                    return true;
                default:
                    return  false;

            }
        }


        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode=null;

        }
    }
}
