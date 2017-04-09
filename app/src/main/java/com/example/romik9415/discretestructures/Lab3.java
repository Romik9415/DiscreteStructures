package com.example.romik9415.discretestructures;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Lab3 extends AppCompatActivity {
    //Створити програмне забезпечення для знаходження булеану довільної нечіткої множини.

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        enteredA = (TextView) findViewById(R.id.enteredA);
        enteredE = (TextView) findViewById(R.id.enteredE);
        result = (TextView) findViewById(R.id.result);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
