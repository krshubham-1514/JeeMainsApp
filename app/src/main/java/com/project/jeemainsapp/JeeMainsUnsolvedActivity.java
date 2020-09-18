package com.project.jeemainsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.project.jeemainsapp.Adapters.ListviewMainsUnsolvedAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class JeeMainsUnsolvedActivity extends AppCompatActivity {


    Toolbar toolbar;
    private AdView mAdView;

    ListView listviewmainsunsolved;
    int[] listview_imageresoruce=new int[]{R.drawable.jeemains2018,R.drawable.jeemains2018,R.drawable.jeemains2018,R.drawable.jeemains2018,R.drawable.jeemains2017,R.drawable.jeemains2017,R.drawable.jeemains2017,R.drawable.jeemains2017,R.drawable.jeemains2016,R.drawable.jeemains2016,R.drawable.jeemains2016,R.drawable.jeemains2016,R.drawable.jeemains2015,R.drawable.jeemains2015,R.drawable.jeemains2015,R.drawable.jeemains2015,R.drawable.jeemains2014,R.drawable.jeemains2014,R.drawable.jeemains2014,R.drawable.jeemains2014,R.drawable.jeemains2014};
    String[] listview_textresource=new String[]{"Jee mains  2018","Jee mains 2018","Jee mains 2018","Jee mains 2018","Jee mains 2017","Jee mains 2017","Jee mains 2017","Jee mains 2017","Jee mains 2016","Jee mains 2016","Jee mains 2016","Jee mains 2016","Jee mains 2015","Jee mains 2015","Jee mains 2015","Jee mains 2015","Jee mains 2014","Jee mains 2014","Jee mains 2014","Jee mains 2014"};
    String[] listview_textview_set=new String[]{"SET A","SET B","SET C","SET D","SET A","SET B","SET C","SET D","SET E","SET F","SET G","SET H","SET A","SET B","SET C","SET D","SET E","SET F","SET G","SET H",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_mains_unsolved);

        //intilizing ads for this page
        //for banner ad on this page


        mAdView = findViewById(R.id.adView_unsolved_mains);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        toolbar=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Jee mains papers (unsolved)");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //setting up instance for the fireabase storage


        listviewmainsunsolved=(ListView)findViewById(R.id.mains_paper_listview_unsolved);

        ListviewMainsUnsolvedAdapter listviewAcademicsAdapter=new ListviewMainsUnsolvedAdapter(this,listview_imageresoruce,listview_textresource,listview_textview_set);
        listviewmainsunsolved.setAdapter(listviewAcademicsAdapter);







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
