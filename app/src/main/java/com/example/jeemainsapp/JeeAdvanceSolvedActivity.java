package com.example.jeemainsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jeemainsapp.Adapters.ListviewAdvanceSolvedAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class JeeAdvanceSolvedActivity extends AppCompatActivity {


    Toolbar toolbar;
    ListView listviewadvancesolved;
    int[] listview_imageresoruce = new int[]{R.drawable.jeeadvance2018, R.drawable.jeeadvance2018, R.drawable.jeeadvance2017, R.drawable.jeeadvance2017, R.drawable.jeeadvance2016, R.drawable.jeeadvance2016, R.drawable.jeeadvance2015, R.drawable.jeeadvance2015, R.drawable.jeeadvance2014, R.drawable.jeeadvance2014, R.drawable.jeeadvance2013, R.drawable.jeeadvance2013, R.drawable.jeeadvance2012, R.drawable.jeeadvance2012, R.drawable.jeeadvance2011, R.drawable.jeeadvance2011, R.drawable.jeeadvance2010, R.drawable.jeeadvance2010, R.drawable.jeeadvance2009, R.drawable.jeeadvance2009, R.drawable.jeeadvance2008, R.drawable.jeeadvance2008, R.drawable.jeeadvance2007, R.drawable.jeeadvance2007};
    String[] listview_textresource = new String[]{"Jee advanced 2018", "Jee advanced 2018", "Jee advanced 2017", "Jee advanced 2017", "Jee advanced 2016", "Jee advanced 2016", "Jee advanced 2015", "Jee advanced 2015", "Jee advanced 2014", "Jee advanced 2014", "Jee advanced 2013", "Jee advanced 2013", "Jee advanced 2012", "Jee advanced 2012", "Jee advanced 2011", "Jee advanced 2011", "Jee advaced 2010", "Jee advaced 2010", "Jee advanced 2009", "Jee advanced 2009", "Jee advanced 2008", "Jee advanced 2008", "Jee advanced 2007", "Jee advanced 2007"};
    String[] listview_textview_paper = new String[]{"Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2", "Paper 1", "Paper 2"};
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_advance_solved);
        //intilzing ads for this page
        //for banner ad on this page
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView_advance_solved);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Jee Advance papers (solved)");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //setting up instance for the fireabase storage


        listviewadvancesolved = (ListView) findViewById(R.id.advance_solved);

        ListviewAdvanceSolvedAdapter listviewAcademicsAdapter = new ListviewAdvanceSolvedAdapter(this, listview_imageresoruce, listview_textresource, listview_textview_paper);
        listviewadvancesolved.setAdapter(listviewAcademicsAdapter);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}


