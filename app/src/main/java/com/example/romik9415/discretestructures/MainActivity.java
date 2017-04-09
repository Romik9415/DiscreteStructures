package com.example.romik9415.discretestructures;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

import static com.example.romik9415.discretestructures.R.id.result;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView enterData= (TextView) findViewById(R.id.enter_data);
        TextView result = (TextView) findViewById(R.id.result);
        context = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final TextView finalResult = result;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                String numbers = "1234";
                enterData.setText("["+numbers+"]");
                finalResult.setText(String.valueOf(powerSet(numbers)));
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        startActivity(new Intent(this,Lab3.class));
    }
    //Start

    static List<String> powerSet(String s) {

        long numSubsets = 1L << s.length(); //2^n
        return powerSet(s, numSubsets - 1);
    }

    static List<String> powerSet(String string, long active) {
        if (active < 0) {
            // Recursion base case
            // All 2^n subsets were visited, stop here and return a new list
            return new ArrayList<>();
        }

        StringBuilder subset = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            // For each bit
            if (isSet(active, i)) {
                // If the bit is set, add the correspondent char to this subset
                subset.append(string.charAt(i));
            }
        }
        // Make the recursive call, decrementing active to the next state,
        // and get the returning list
        List<String> subsets = powerSet(string, active - 1);
        // Add this subset to the list of subsets
        subsets.add(subset.toString());
        return subsets;
    }

    static boolean isSet(long bits, int i) {
        // return true if the ith bit is set
        Log.i("teg", "i="+String.valueOf(i));
        Log.i("teg", "Zsuv = "+String.valueOf((1L << i)));
        Log.i("teg", "Bits="+String.valueOf(bits));
        Log.i("teg","bool"+String.valueOf((bits & (1L << i)) != 0));
        //Toast.makeText(context,String.valueOf(5 & 1), Toast.LENGTH_SHORT).show();
        return (bits & (1L << i)) != 0;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent;
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            intent = new Intent(this, Lab2.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            intent = new Intent(this, Lab3.class);
            startActivity(intent);
        }

        startActivity(new Intent(this,Lab3.class));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
