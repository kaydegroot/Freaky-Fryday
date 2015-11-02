package com.example.kaydegroot.de_familie_yggdrasil.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kaydegroot.de_familie_yggdrasil.Classes.Persoon;
import com.example.kaydegroot.de_familie_yggdrasil.R;
import com.example.kaydegroot.de_familie_yggdrasil.Views.YggdrasilView;

public class YggdrassilActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YggdrasilView y = new YggdrasilView(this);
        y.setBackgroundColor(Color.WHITE);
        setContentView(y);
        //setContentView(R.layout.activity_yggdrassil);
    }
}
