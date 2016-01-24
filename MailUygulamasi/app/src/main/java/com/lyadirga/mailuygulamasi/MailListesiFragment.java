package com.lyadirga.mailuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;


public class MailListesiFragment extends ListFragment {

    private boolean ekran_yataymi;
    private MailIcerikFragment mailIcerikFragment;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] mail_listesi=getActivity().getResources().getStringArray(R.array.mail_listesi);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,mail_listesi);
        setListAdapter(adapter);

        FrameLayout container= (FrameLayout) getActivity().findViewById(R.id.icerik_fragment_container);

        ekran_yataymi = container!=null && container.getVisibility()== View.VISIBLE;


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (ekran_yataymi){

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

            mailIcerikFragment= (MailIcerikFragment) getFragmentManager().findFragmentById(R.id.icerik_fragment_container);

            if (mailIcerikFragment==null || mailIcerikFragment.getPozisyon()!=position){
                mailIcerikFragment= new MailIcerikFragment(position);
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.icerik_fragment_container,mailIcerikFragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.commit();
            }
        }



        else{
            Intent intent=new Intent(getActivity(),ActivityIcerik.class);
            intent.putExtra("pozisyon",position);
            startActivity(intent);

        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if(mailIcerikFragment !=null){
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            transaction.remove(mailIcerikFragment);
            transaction.commit();
        }
    }
}
