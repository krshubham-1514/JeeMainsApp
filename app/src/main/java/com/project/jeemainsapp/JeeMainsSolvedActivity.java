package com.project.jeemainsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.project.jeemainsapp.Adapters.ListviewMainsSolvedAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class JeeMainsSolvedActivity extends AppCompatActivity {


    Toolbar toolbar;
    private AdView mAdView;

    ListView listviewmainsolved;
    int[] listview_imageresoruce=new int[]{R.drawable.jeemains2018,R.drawable.jeemains2017,R.drawable.jeemains2016,R.drawable.jeemains2015,R.drawable.jeemains2014,R.drawable.jeemains2013,R.drawable.jeemains2012,R.drawable.jeemains2011,R.drawable.jeemains2010,R.drawable.jeemains2009,R.drawable.jeemains2008,R.drawable.jeemains2007,R.drawable.jeemains2006,R.drawable.jeemains2005,R.drawable.jeemains2004};
    String[] listview_textresource=new String[]{"Jee mains 2018","Jee mains 2017","Jee mains 2016","Jee mains 2015","Jee mains 2014","Jee mains 2013","AIEEE 2012","AIEEE 2011","AIEEE 2010","AIEEE 2009","AIEEE 2008","AIEEE 2007","AIEEE 2006","AIEEE 2005","AIEEE 2004"};
    String[] listview_textview_set=new String[]{"SET D","SET D","SET F","SET B","SET H","SET Q","SET C","SET Q","SET A","SET A","SET C","SET O","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_mains_solved);
        //for banner ad on this page


        mAdView = findViewById(R.id.adView_mains_solved);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //making ads for this page




        toolbar=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Jee mains papers (solved)");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //setting up instance for the fireabase storage


        listviewmainsolved=(ListView)findViewById(R.id.mains_paper_listview_solved);

        ListviewMainsSolvedAdapter listviewAcademicsAdapter=new ListviewMainsSolvedAdapter(this,listview_imageresoruce,listview_textresource,listview_textview_set);
        listviewmainsolved.setAdapter(listviewAcademicsAdapter);







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

