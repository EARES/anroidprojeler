package com.example.erem.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class diger extends Activity
{
    ToggleButton tgl;
    Button btn;
    RadioGroup rdgrp;
    public int secilenid;
    SeekBar sb;
    RatingBar rb;
    TextView tv,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digerr);
        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(diger.this, MainActivity.class));
            }
        });
        tgl = (ToggleButton) findViewById(R.id.toggleButton);
        btn = (Button) findViewById(R.id.btntogle);

        tgl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (tgl.isChecked()) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
            }
        });
        rdgrp = (RadioGroup) findViewById(R.id.grup);
        rdgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                secilenid = rdgrp.getCheckedRadioButtonId();
                RadioButton rdbtn1 = (RadioButton) findViewById(secilenid);
                Toast.makeText(getApplicationContext(), "secilen: " + rdbtn1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        sb = (SeekBar) findViewById(R.id.seekBar);
        tv = (TextView) findViewById(R.id.textView);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        rb = (RatingBar) findViewById(R.id.ratingBar);
        tv2 = (TextView) findViewById(R.id.textView2);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv2.setText(String.valueOf(rating));
            }
        });


    }
}
