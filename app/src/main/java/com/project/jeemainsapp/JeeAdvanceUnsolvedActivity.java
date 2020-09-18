package com.project.jeemainsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.project.jeemainsapp.Adapters.ListviewAdvanceUnsolvedAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class JeeAdvanceUnsolvedActivity extends AppCompatActivity {


    Toolbar toolbar;
    private AdView mAdView;

    ListView listviewadvanceunsolved;
    int[] listview_imageresoruce=new int[]{R.drawable.jeeadvance2018,R.drawable.jeeadvance2018,R.drawable.jeeadvance2017,R.drawable.jeeadvance2017,R.drawable.jeeadvance2016,R.drawable.jeeadvance2016,R.drawable.jeeadvance2015,R.drawable.jeeadvance2015,R.drawable.jeeadvance2014,R.drawable.jeeadvance2014,R.drawable.jeeadvance2013,R.drawable.jeeadvance2013,R.drawable.jeeadvance2012,R.drawable.jeeadvance2012,R.drawable.jeeadvance2011,R.drawable.jeeadvance2011,R.drawable.jeeadvance2010,R.drawable.jeeadvance2010,R.drawable.jeeadvance2009,R.drawable.jeeadvance2009,R.drawable.jeeadvance2008,R.drawable.jeeadvance2008,R.drawable.jeeadvance2007,R.drawable.jeeadvance2007};
    String[] listview_textresource=new String[]{"Jee advanced 2018","Jee advanced 2018","Jee advanced 2017","Jee advanced 2017","Jee advanced 2016","Jee advanced 2016","Jee advanced 2015","Jee advanced 2015","Jee advanced 2014","Jee advanced 2014","Jee advanced 2013","Jee advanced 2013","Jee advanced 2012","Jee advanced 2012","Jee advanced 2011","Jee advanced 2011","Jee advaced 2010","Jee advaced 2010","Jee advanced 2009","Jee advanced 2009","Jee advanced 2008","Jee advanced 2008","Jee advanced 2007","Jee advanced 2007"};
    String[] listview_textview_paper=new String[]{"Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2","Paper 1","Paper 2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_advance_unsolved);

        //intilzing ads for this page
        //for banner ad on this page


        mAdView = findViewById(R.id.adView_advance_unsolved);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        toolbar=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Jee Advance papers (unsolved)");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //setting up instance for the fireabase storage


        listviewadvanceunsolved=(ListView)findViewById(R.id.advance_unsolved);

        ListviewAdvanceUnsolvedAdapter listviewAcademicsAdapter=new  ListviewAdvanceUnsolvedAdapter(this,listview_imageresoruce,listview_textresource,listview_textview_paper);
        listviewadvanceunsolved.setAdapter(listviewAcademicsAdapter);







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

