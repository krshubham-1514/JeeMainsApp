package com.project.jeemainsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import com.github.ybq.android.spinkit.style.Wave;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PdfViewActivity extends AppCompatActivity {

    public PDFView pdfView;
    FirebaseStorage storage;
    ProgressBar progressBar;
    StorageReference storageReference;
    private InterstitialAd mInterstitialAd;
    File file;
    String download_url;
    TextView download_per;
    Intent intent;
    Toolbar toolbar;
    int position;
    int type;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        //setting the ads for this page

        mInterstitialAd = new InterstitialAd(this);

        mInterstitialAd.setAdUnitId("ca-app-pub-1909654704105252/9460884793");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

      //setting the content for the pdf view
        pdfView=(PDFView)findViewById(R.id.pdfViewer);
        storage=FirebaseStorage.getInstance();
        toolbar=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("PDFView");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar=(ProgressBar)findViewById(R.id.spin_kit);
        download_per=(TextView)findViewById(R.id.down_percent);


        //starting the process for download the papers from the interner

        Wave wave=new Wave();
        progressBar.setIndeterminateDrawable(wave);

        intent=getIntent();

        position=intent.getIntExtra("posizione",0);
        type=intent.getIntExtra("type",0);


             //setting the ads to this activity














        try {
            download_pdf_paper_url();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void download_pdf_paper_url() throws IOException {

        //setting the link to the variable and downloading


        switch (type) {

            //type  1 means jee mains unsolved
            //type 2 means jee mains solved
            //type 3 means jee advance unsolved
            //type 4 means jee advance solved


            case 1: {
                if (position == 0) {

                    //Jee mains unsolved paper 2018 set A
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2018-Question-Paper-08_04_2018_SetA.pdf?alt=media&token=3f05d306-e9bb-4e47-a81f-9a991d65de49";
                } else if (position == 1) {
                    //jee mains unsolved paper 2018 set B
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2018-Question-Paper-08_04_2018_SetB.pdf?alt=media&token=673c10df-1c2e-4df8-890c-67ebc4b75777";

                } else if (position == 2) {
                    //jee mains unsolved paper 2018 set C
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2018-Question-Paper-08_04_2018_SetC.pdf?alt=media&token=41f5fbc3-6fec-446f-9bfd-dfe2c9371637";

                } else if (position == 3) {

                    //jee mains unsolved paper 2018 set D
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2018-Question-Paper-08_04_2018_SetD.pdf?alt=media&token=d5164c31-67b8-4311-b110-a7e2a356501c";

                } else if (position == 4) {
                    //jee mains unsolved paper 2017 set A
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE%20Main%202017%20Questoion%20Paper%20I%20Set%20A%2C%20April%202.pdf?alt=media&token=e5032c97-2684-4e45-95fc-651b2fc41c94";

                } else if (position == 5) {
                    //jee mains unsolved paper 2017 set B
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE%20Main%202017%20Official%20Question%20Paper%201%20SetB.pdf?alt=media&token=9333d7a9-401d-473a-9ce3-5f928667c4d7";
                } else if (position == 6) {
                    //jee mains unsolved paper 2017 set C
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE%20Main%202017%20%20%20Paper%201%20Set%20C.pdf?alt=media&token=7265d044-8c3d-4dad-8972-36712dd4b785";

                } else if (position == 7) {

                    //jee mains unsolved paper 2017 set D

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE%20Main%202017%20%20Paper%201%20Set%20D.pdf?alt=media&token=ece237db-bfda-4e15-8351-755ccd8b279d";

                } else if (position == 8) {

                    //jee mains unsolved paper 2016 set E
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2016-Question-Paper-Set-E.pdf?alt=media&token=c1d25d1f-3cae-4ff7-b078-cfd9e83cd9bb";

                } else if (position == 9) {
                    //jee  mains unsolved paper 2016 set F

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2016-Question-Paper-Set-F.pdf?alt=media&token=5700e2b6-0dbd-404a-8e67-711b07d8876c";

                } else if (position == 10) {

                    //jee mains unsolved paper 2016 set G
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2016-Question-Paper-Set-G.pdf?alt=media&token=b88dd2de-f09b-4ef6-b746-f9c844d1eaee";


                } else if (position == 11) {
                    //jee mains unsolved paper 2016set H
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-Main-2016-Question-Paper-Set-H.pdf?alt=media&token=2b0da4b4-1ce5-40fd-ac37-508e936d6ec7";

                } else if (position == 12) {

                    //jee mains unsolved paper 2015 set A
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-MAIN-SET-A-2015-QUESTION-PAPER.pdf?alt=media&token=9300d23f-a883-484e-8120-d9dcab10900a";


                } else if (position == 13) {
                    //jee mains unsolved paper 2015 set B
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-MAIN-SET-B-QUESTION-PAPER-2015.pdf?alt=media&token=707f5252-eafb-4ba7-b138-484f4786a7a6";

                } else if (position == 14) {
                    //jee mains unsolved paer 2015 set C
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-MAIN-QUESTION-PAPER-SET-C-2015.pdf?alt=media&token=cbdd7b13-fa10-4e04-9d3a-698c2eb0fd8f";
                } else if (position == 15) {
                    //jee mains unsolved paper 2015 set D
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2FJEE-MAIN-QUESTION-PAPER-SET-D-2015.pdf?alt=media&token=c45e65de-0467-4818-9ffe-3d5f46eb07ec";

                } else if (position == 16) {
                    //jee mains unsolved paper 2014 set E

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2Fjee-main2014-offline-paper-code-e.pdf?alt=media&token=724d10ab-82f6-4e03-ae60-187e7147527a";
                } else if (position == 17) {
                    //jee mains unsolved paper 2014 set F
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2Fjee-main2014-offline-paper-code-f.pdf?alt=media&token=442bcbcf-8e5c-4543-8ea7-5edc15ffd112";
                } else if (position == 18) {
                    //jee mains unsolved paper 2014 set G
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2Fjee-main2014-offline-paper-code-g.pdf?alt=media&token=60d0f3aa-13f0-4cb4-ac62-f827298fc4ea";

                } else if (position == 19) {
                    //jee mains unsolved paper 2014 set H
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_unsolved%2Fjee-main2014-offline-paper-code-h.pdf?alt=media&token=be0189bc-6870-470d-a9c8-511715dda6c2";
                }
                break;
            }

            case 2: {

                if (position == 0) {
                    //jee mains solved paper 2018 set D
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FJeemains2018_solution_setD.pdf?alt=media&token=f265137f-89e1-4403-be51-3447ab154338";
                } else if (position == 1) {
                    //jee mains solved paers 2017 set D
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FJeemains2017_solution_setD.pdf?alt=media&token=7c375f5c-3279-4015-874b-0d5623ee2568";
                } else if (position == 2) {
                    //jee mains solved papers 2016 set F
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FJeemains2016_solution_setF.pdf?alt=media&token=70099196-70bf-4fa1-8c9c-3c52b81f4958";
                } else if (position == 3) {
                    //jee mains solved papers 2015 setB
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FJeemains2015_solution_setB.pdf?alt=media&token=83c11069-f7c0-4dd4-b2c8-8aadaf03ca53";
                } else if (position == 4) {
                    //jee mains solved papers 2014 set H
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FJeemains2014_solution_setH.pdf?alt=media&token=74a39e0a-a537-4000-909b-270344c4c444";

                } else if (position == 5) {
                    //jee mains solved papers 2013 set q
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FJeemains2013_solution_setQ.pdf?alt=media&token=ff679211-528d-4b2c-8faa-9b8d715d3cc9";
                } else if (position == 6) {
                    //jee mains solved papers 2012 set C
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2012_solution_setC.pdf?alt=media&token=87fda26a-86a5-49de-adae-56787520dae5";
                } else if (position == 7) {
                    //jee mains solved papers 2011 set Q

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2011_solution_setQ.pdf?alt=media&token=93f9299d-3c91-49a7-9e3e-cfdfbf5fed14";

                } else if (position == 8) {
                    //jee mains solved papers 2010 set A
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2010_solution_setA.pdf?alt=media&token=2689858a-6264-4117-83b4-ffbafe89ea5a";

                } else if (position == 9) {
                    //jee mains solved papers 2009 set A
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2009_solution_setA.pdf?alt=media&token=61c89335-0e79-4c2d-a42a-17159bbb1769";

                } else if (position == 10) {
                    //jee mains solved papers 2008 set C
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2008_solution_setC.pdf?alt=media&token=c57cc6eb-bcd3-435c-a020-eeed0b000692";

                } else if (position == 11) {
                    //jee mains solved papers 2007 set Q
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2007_solution_setO.pdf?alt=media&token=97b48224-eb17-4a1a-93ce-5b4f8d3e7240";
                } else if (position == 12) {
                    //jee mains solved papers 2006 set U
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2006_solution_setU.pdf?alt=media&token=48983747-6709-4979-bb16-486535485769";

                } else if (position == 13) {
                    //jee mains solved papers 2005 set U
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2005_solution_setU.pdf?alt=media&token=153c3c5a-6044-4254-bdbf-a1343eb7b4ce";

                } else if (position == 14) {
                    //jee mains solved papers 2004 set U
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_mains_solved%2FAieee2004_solution_setU.pdf?alt=media&token=700c5dde-2386-4a14-b7d9-ffd064943d93";
                }
                break;
            }
            case 3: {
                if (position == 0) {
                    //jee advance 2018 unsolved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2018P1.pdf?alt=media&token=b8c5351b-1084-4e83-893f-efe39c08a26e";
                } else if (position == 1) {

                    //jee advance 2018 unsolved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2018P2.pdf?alt=media&token=e98c9f7b-9746-47f2-b725-925cae583e76";
                } else if (position == 2) {
                    //jee advance 2017 unsolved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2017p1.pdf?alt=media&token=5fcc7552-dd33-444f-9a1a-92362d53fe45";
                } else if (position == 3) {
                    //jee advance 2017 unsolved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2017p2.pdf?alt=media&token=2a036839-de60-4615-b4ef-efb8ef791720";
                } else if (position == 4) {

                    //jee advance 2016 unsolved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2016p1.pdf?alt=media&token=fab5d896-2372-40b0-b9ba-45e4674dd6a8";
                } else if (position == 5) {
                    //jee advance 2016 unsolved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2016p2.pdf?alt=media&token=0b97f6f5-599a-4da6-9b03-725ba5b9b14c";
                } else if (position == 6) {
                    //jee advance 2015 unsolved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2015p1.pdf?alt=media&token=17013dae-98ae-424e-b80f-5be178d77a41";
                } else if (position == 7) {
                    //jee advance 2015 unsolved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2015p2.pdf?alt=media&token=a3d3f365-d002-46de-9c93-a1a789281d58";
                } else if (position == 8) {
                    //jee advance 2014 unsolved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2014p1.pdf?alt=media&token=c5b839d6-8f55-4c0a-b413-609eaafdded8";
                } else if (position == 9) {
                    //jee advance 2014 unsolved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2014p2.pdf?alt=media&token=86d1002f-bb2b-499c-8cb1-beb9bd49c240";
                } else if (position == 10) {
                    //jee advance 2013 unsolved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2013p1.pdf?alt=media&token=1bd8c3c6-9d83-4a78-9913-edaa9d54cded";
                } else if (position == 11) {
                    //jee advance 2013 unsolved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2013p2.pdf?alt=media&token=2d6c42c9-2d65-42a1-af0a-d28b690cd55f";
                } else if (position == 12) {
                    //jee advance 2012 unsolved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2012p1.pdf?alt=media&token=d128ba65-b677-43f3-94e5-cc21e5a50144";
                } else if (position == 13) {
                    //jee advance 2012 unsolved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2012p2.pdf?alt=media&token=2883575d-64fc-429a-8367-d35ebe1a71e2";
                } else if (position == 14) {
                    //jee advance 2011 unsolved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2011p1.pdf?alt=media&token=b4863358-83df-4047-8792-8e1df1a81b09";
                } else if (position == 15) {
                    //jee advance 2011 unsolved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2011p2.pdf?alt=media&token=6199c3d3-cdc0-486c-ba7f-5e0c8f6cfaae";

                } else if (position == 16) {
                    //jee advance 2010 unsolved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2010p1.pdf?alt=media&token=630f85fa-55a0-4582-bac2-950a6646d7a5";

                } else if (position == 17) {
                    //jee advance 2010 usolved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2010p2.pdf?alt=media&token=2148bff0-7a73-4d98-be20-1492942f3390";
                } else if (position == 18) {
                    //jee advance 2009 unsolved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2009p1.pdf?alt=media&token=ef89a8ba-d86d-4c45-93af-e9a68bbc2146";

                } else if (position == 19) {
                    //jee advance 2009 unsolve paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2009p2.pdf?alt=media&token=0fee8bcc-81a6-447f-beba-827984b88390";
                } else if (position == 20) {
                    //jee advance 2008 unsolved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2008p1.pdf?alt=media&token=d8a8dab5-bb24-4680-98dc-91cef5444540";

                } else if (position == 21) {
                    //jee advance 2008 unsolved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2008p2.pdf?alt=media&token=1c031686-341e-42a3-9ac5-800094bc0652";

                } else if (position == 22) {
                    //jee advance 2007 unsolved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2007p1.pdf?alt=media&token=bd4bce7e-5471-4305-83c6-7f93692819ca";
                } else if (position == 23) {
                    //jee advance 2007 unsolved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_unsolved%2F2007p2.pdf?alt=media&token=b955f8ba-39bd-4d1a-9963-a2457d7851e4";
                }
                break;
            }
            case 4: {

                if (position == 0) {
                    //jee advance 2018 solved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2018p1.pdf?alt=media&token=a0a4a986-e0a0-4965-a348-3cf5bc0f2bf0";
                } else if (position == 1) {

                    //jee advance 2018 solved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2018p2.pdf?alt=media&token=5f2a9de9-ba6c-4822-b89e-4a1593757a1f";
                } else if (position == 2) {
                    //jee advance 2017 solved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2017p1.pdf?alt=media&token=04d909b4-69c6-4de9-8193-799acdc3671b";
                } else if (position == 3) {
                    //jee advance 2017 solved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2017p2.pdf?alt=media&token=eadbb8f0-0eb9-4feb-a26c-bcbef734d75f";
                } else if (position == 4) {

                    //jee advance 2016 solved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2016p1.pdf?alt=media&token=c63e9a8f-6303-4b09-bfe3-983d15a557c2";
                } else if (position == 5) {
                    //jee advance 2016 solved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2016p2.pdf?alt=media&token=c9eeb718-5731-4b18-83a6-6e0f3eca542d";
                } else if (position == 6) {
                    //jee advance 2015 solved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2015p1.pdf?alt=media&token=2d57449f-68ba-488a-a717-884361265aac";
                } else if (position == 7) {
                    //jee advance 2015 solved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2015p2.pdf?alt=media&token=6954d6e8-dd81-471f-a277-84dd1664949b";
                } else if (position == 8) {
                    //jee advance 2014 solved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2014p1.pdf?alt=media&token=38d11b1c-916a-4e95-9c2c-4fe6d0beb9d2";
                } else if (position == 9) {
                    //jee advance 2014 solved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2014p2.pdf?alt=media&token=0eb86fc6-a13a-44ab-a98c-0403625c0adf";
                } else if (position == 10) {
                    //jee advance 2013 solved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2013p1.pdf?alt=media&token=95008b60-8640-4e55-bda5-587bd3652fbc";
                } else if (position == 11) {
                    //jee advance 2013 solved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2013p2.pdf?alt=media&token=6d08f61a-6f4f-41f8-bd30-1b4424ee511b";
                } else if (position == 12) {
                    //jee advance 2012 solved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2012p1.pdf?alt=media&token=4f03f54a-ef9f-4d00-9586-d5d3cd3bc3af";
                } else if (position == 13) {
                    //jee advance 2012 solved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2012p2.pdf?alt=media&token=fa2cbfb6-d6d8-4547-8e33-67c38e4ad841";
                } else if (position == 14) {
                    //jee advance 2011 solved paper 1

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2011p1.pdf?alt=media&token=2805df9f-9283-4001-8624-24b5b63b04ef";
                } else if (position == 15) {
                    //jee advance 2011 solved paper 2

                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2011p2.pdf?alt=media&token=d3f4b47a-323f-4423-9888-46440c2fe84a";

                } else if (position == 16) {
                    //jee advance 2010 solved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2010p1.pdf?alt=media&token=a17ea94d-d524-401f-87ec-3f4ab9fb2c36";

                } else if (position == 17) {
                    //jee advance 2010 solved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2010p2.pdf?alt=media&token=6f4c16e8-3b88-4d57-80c1-365c76123860";
                } else if (position == 18) {
                    //jee advance 2009 solved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2009p1.pdf?alt=media&token=fc8b07df-e228-4ac2-9a89-3c574cd7af26";

                } else if (position == 19) {
                    //jee advance 2009 solve paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2009p2.pdf?alt=media&token=9771495c-cf86-41dd-8f3f-d529a2fbc112";
                } else if (position == 20) {
                    //jee advance 2008 solved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2008p1.pdf?alt=media&token=3d6d150e-9018-44e1-b06b-a16083d6c90b";

                } else if (position == 21) {
                    //jee advance 2008 solved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2008p2.pdf?alt=media&token=7ab99c53-b5f2-42ee-8952-dafa13fb6444";

                } else if (position == 22) {
                    //jee advance 2007 solved paper 1
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2007p1.pdf?alt=media&token=c46018fc-0ab3-406f-9532-5f656f33e69f";
                } else if (position == 23) {
                    //jee advance 2007 solved paper 2
                    download_url = "https://firebasestorage.googleapis.com/v0/b/jeemainsapp-48a64.appspot.com/o/jee_advance_solved%2F2007p2.pdf?alt=media&token=19b531ad-0fa6-442b-84ae-dc91b004374b";
                }
                break;
            }







        }


        //starting the donload of the pdf after url has been set
        
        start_download_pdf();






    }

    public void start_download_pdf() throws IOException {


        file=File.createTempFile("paper","pdf");
        storageReference = storage.getReferenceFromUrl(download_url);

        storageReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                pdfView.fromFile(file).load();
                progressBar.setVisibility(View.INVISIBLE);
                download_per.setVisibility(View.INVISIBLE);

                //showing the ads after the load of the question paper

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    //do nothing if the itestial app do not intilize correctly
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Toast.makeText(PdfViewActivity.this, "Error while downloading", Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {
                double fprogress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                int per_progress=(int) fprogress;
                download_per.setText(String.valueOf(per_progress)+"%");
            }
        });

    }

}
