package com.lyadirga.mailuygulamasi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MailIcerikFragment extends Fragment {

    private  int pozisyon=0;

    public MailIcerikFragment(int pozisyon){
        this.pozisyon=pozisyon;
    }

    public int getPozisyon(){
        return pozisyon;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.icerik,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView icerik_tv= (TextView) getActivity().findViewById(R.id.tv_icerik);
        String[] icerik=getActivity().getResources().getStringArray(R.array.mail_icerik);
        icerik_tv.setText(icerik[pozisyon]);
    }
}
