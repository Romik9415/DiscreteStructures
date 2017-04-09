package com.example.romik9415.discretestructures;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO: display
        List<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        //set.add("c");
        //set.add("d");

        //TODO: display
        List<Double> vals = new ArrayList<>();
        vals.add(0d);
        vals.add(.45d);
        vals.add(1d);

        List<FuzzySet> fuzzySetSet = FuzzySet.Boolean(set,vals);
        Log.d("A_L3","Length: "+fuzzySetSet.size()+" expected= "+Math.pow(vals.size(),set.size()));
        for (FuzzySet fuzzySet : fuzzySetSet) {
            Log.d("A_L3",fuzzySet.toStr()); //TODO: display
        }


    }


}
