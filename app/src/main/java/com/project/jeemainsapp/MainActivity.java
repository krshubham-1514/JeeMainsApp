package com.project.jeemainsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Toolbar toolbar;
    CardView cardView_mains_unsolved;
    CardView cardView_mains_solved;
    CardView cardView_advance_unsolved;
    CardView cardView_advance_solved;
    private AdView mAdView;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for banner ad on this page only once
        MobileAds.initialize(this, "ca-app-pub-1909654704105252~1647401005");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //setting a action bar

        toolbar=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cardView_mains_unsolved=(CardView)findViewById(R.id.card_view_jeemains_unsolved);
        cardView_mains_solved=(CardView)findViewById(R.id.card_view_mains_solved);
        cardView_advance_unsolved=(CardView)findViewById(R.id.card_view_advance_unsolved);
        cardView_advance_solved=(CardView) findViewById(R.id.card_view_advance_solved);

        //setting on click listener for menu navigation bar



         navigationView=(NavigationView)findViewById(R.id.navigation_view_draw);
         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                 int id=menuItem.getItemId();
                 if(id== R.id.home)
                 {
                     startActivity(new Intent(MainActivity.this,MainActivity.class));
                     return true;

                 }
                 else if(id==R.id.share)
                 {
                     /*

                     Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                     sharingIntent.setType("text/plain");
                     String shareBodyText = "Download Jee prepration app. Link:'https://thisisname'";
                     sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Jee (mains+advance) prepration app");
                     sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                     startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                     */
                     return true;

                 }
                 else if(id==R.id.feedback)
                 {

                     return true;

                 }
                 else if(id==R.id.privacy)
                 {
                     startActivity(new Intent(MainActivity.this,PrivacyPolicyActivity.class));
                     return  true;
                 }
                 return true;
             }
         });

        //setting the on card click listener to the cardview
        cardView_mains_unsolved.setOnClickListener(this);
        cardView_mains_solved.setOnClickListener(this);
        cardView_advance_unsolved.setOnClickListener(this);
        cardView_advance_solved.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {




        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.card_view_jeemains_unsolved:
                startActivity(new Intent(this,JeeMainsUnsolvedActivity.class));
                break;
            case R.id.card_view_mains_solved:
                startActivity(new Intent(this,JeeMainsSolvedActivity.class));
                break;
            case R.id.card_view_advance_unsolved:
                startActivity(new Intent(this,JeeAdvanceUnsolvedActivity.class));
                break;
            case R.id.card_view_advance_solved:
                startActivity(new Intent(this,JeeAdvanceSolvedActivity.class));


        }
    }



}
