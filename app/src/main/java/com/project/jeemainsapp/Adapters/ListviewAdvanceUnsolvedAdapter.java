package com.project.jeemainsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.jeemainsapp.PdfViewActivity;
import com.project.jeemainsapp.R;


public class ListviewAdvanceUnsolvedAdapter extends ArrayAdapter<String> {
    Context context;
    final int type;
    public int[] academics_listview_icons;
    public String[] academics_listview_text;
    public String[] listview_paper_arr;



    public ListviewAdvanceUnsolvedAdapter( Context context, int[]academics_listview_icons,String[]academics_listview_text,String[]listview_paper_arr) {
        super(context, R.layout.listview_items_paper, R.id.textlistview_common,academics_listview_text);
        this.academics_listview_icons=academics_listview_icons;
        this.context=context;
        this.listview_paper_arr=listview_paper_arr;
        this.academics_listview_text=academics_listview_text;
        this.type=3;

    }

    //function to get the view of each layout



    @Override
    public View getView(final int position,View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.listview_items_paper,parent,false);
        ImageView listview_image=(ImageView)row.findViewById(R.id.imageview_common);
        TextView listview_textview=(TextView) row.findViewById(R.id.textlistview_common);
        TextView listview_textview_paper=(TextView)row.findViewById(R.id.textlistview_common_set);
        Button button_download=(Button)row.findViewById(R.id.common_button);
        listview_image.setImageResource(academics_listview_icons[position]);
        listview_textview.setText(academics_listview_text[position]);
        listview_textview_paper.setText(listview_paper_arr[position]);
        button_download.setText("Download paper");
        //setting the on click listener to n the download button in the listview
        button_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i = new Intent(v.getContext() , PdfViewActivity.class);
                i.putExtra("posizione", position);
                i.putExtra("type",type);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        return row;

    }



}

