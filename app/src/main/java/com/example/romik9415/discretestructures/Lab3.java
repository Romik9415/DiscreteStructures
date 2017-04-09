package com.example.romik9415.discretestructures;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lab3 extends AppCompatActivity {
    //Створити програмне забезпечення для знаходження булеану довільної нечіткої множини.

    List<String> set;
    List<Double> vals;
    List<FuzzySet> fuzzySetSet;

    TextView enteredA;
    TextView enteredE;
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFuzzySet();
            }
        });

        enteredA = (TextView) findViewById(R.id.enteredA);
        enteredE = (TextView) findViewById(R.id.enteredE);
        result = (TextView) findViewById(R.id.result);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        set = new ArrayList<>();
        set.add("a");
        set.add("b");
        //set.add("c");
        //set.add("d");

        vals = new ArrayList<>();
        vals.add(0d);
        vals.add(.45d);
        vals.add(1d);

        displayEnteredData();
    }

     private void getFuzzySet(){
        fuzzySetSet = FuzzySet.Boolean(set,vals);
        Log.d("A_L3","Length: "+fuzzySetSet.size()+" expected= "+Math.pow(vals.size(),set.size()));
        for (FuzzySet fuzzySet : fuzzySetSet) {
            Log.d("A_L3",fuzzySet.toStr());
            result.append(fuzzySet.toStr());
        }
    }

    private void displayEnteredData() {
        enteredA.append(set.toString());
        enteredE.append(vals.toString());
    }


}
