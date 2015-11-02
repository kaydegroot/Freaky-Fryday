package com.example.kaydegroot.de_familie_yggdrasil.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kaydegroot.de_familie_yggdrasil.Classes.Persoon;
import com.example.kaydegroot.de_familie_yggdrasil.Classes.YggdrasilDatabase;
import com.example.kaydegroot.de_familie_yggdrasil.R;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private ArrayList<Persoon> personen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        YggdrasilDatabase yd = new YggdrasilDatabase(this);

        personen = yd.getAllePersonen();
    }

    public void nextScreen(View view) {
        Intent intent = new Intent(this, YggdrassilActivity.class);
        intent.putExtra("AllePersonenInArray",personen);
        this.startActivity(intent);
    }
}
