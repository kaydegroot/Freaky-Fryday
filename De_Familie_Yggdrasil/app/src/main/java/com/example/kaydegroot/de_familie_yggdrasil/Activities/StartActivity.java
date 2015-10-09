package com.example.kaydegroot.de_familie_yggdrasil.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.example.kaydegroot.de_familie_yggdrasil.Views.YggdrasilView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YggdrasilView y = new YggdrasilView(this);
        y.setBackgroundColor(Color.WHITE);
        setContentView(y);
        //setContentView(R.layout.activity_start);
    }
}
