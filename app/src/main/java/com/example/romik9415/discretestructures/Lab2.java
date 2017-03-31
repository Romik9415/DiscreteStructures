package com.example.romik9415.discretestructures;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Lab2 extends AppCompatActivity {
    //Лінійний індекс +
    //квадратний індексечіткості +
    // ентропію
    TextView sets_lab2;
    TextView linear_index;
    TextView sqindex;
    TextView entropi;
    double[] a;
    double[] b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        a = new double[]{0.3, 0.5, 0.0, 0.8, 1.0};
        b = new double[]{0.1, 0.8, 0.2, 0.0, 0.9};
        sets_lab2 = (TextView) findViewById(R.id.sets_lab2);
        linear_index = (TextView) findViewById(R.id.linear_index);
        entropi = (TextView) findViewById(R.id.entropi);
        sqindex = (TextView) findViewById(R.id.sqindex);

        print(a,sets_lab2,"A");
        print(b,sets_lab2,"B");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearIndex();
                quadraticIndex();
                entropia();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void print(double[] maMatrix, TextView textView,String letter) {
        textView.append(String.valueOf(letter)+" = [");
        for (int i = 0; i < maMatrix.length; i++) {

                System.out.print(maMatrix[i] + " ");
                textView.append( "(X"+(i+1)+", "+String.valueOf(maMatrix[i])+"); ");

        }
        textView.append("]\n");
    }

    private void linearIndex() {
        double prefix = (2.0/ a.length);
        double sumHemming = 0;
        double[] sets_copy = a.clone();
        for(int i = 0; i< a.length; i++){
            if(a[i]>0.5){sets_copy[i]=1;}
            else sets_copy[i]=0;
        }
        for (int j = 0; j< a.length; j++){
            sumHemming = sumHemming + Math.abs((a[j]-sets_copy[j]));
        }
        linear_index.append((String.valueOf(sumHemming*prefix))+";\n");
    }

    private void quadraticIndex() {
        double prefix = (2.0/Math.sqrt(a.length));
        double sumHemming = 0;

        for(int i = 0; i< b.length; i++){
            if(b[i]>0.5){b[i]=1;}
            else b[i]=0;
        }
        for (int j = 0; j< a.length; j++){
            sumHemming = sumHemming + Math.pow((a[j]-b[j]),2);
        }
        sqindex.append((String.valueOf(Math.sqrt(sumHemming)*prefix))+";");
    }

    private void entropia(){
        double[] copyA = a.clone();

        for (int i=0;i<copyA.length;i++){
            copyA[i] = a[i]*10;
        }
        double sum = 0;
        double finalSum = 0;
        double prefix = -1/(Math.log(copyA.length));
        for (int i=0;i<copyA.length;i++){
            sum = sum + copyA[i];
        }

        for (int j=0;j<a.length;j++){
            if(copyA[j]!=0.0)
            finalSum = finalSum+(copyA[j]/sum)*(Math.log(copyA[j]/sum));
        }
        entropi.append(String.valueOf(prefix*finalSum));
    }

}
