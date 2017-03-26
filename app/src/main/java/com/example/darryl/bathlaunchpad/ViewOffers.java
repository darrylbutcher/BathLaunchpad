package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewOffers extends AppCompatActivity {

    private int UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_offers);
        Intent intent=getIntent();
        UserID=intent.getIntExtra("UserID", 0);
        MatchesDbHelper MBDH= new MatchesDbHelper(this);
        Cursor res=MBDH.getJobs(UserID);
        LinearLayout panel=(LinearLayout)findViewById(R.id.pane1);
        res.getCount();
        while(res.moveToNext()){

            int JobID=res.getInt(0);
            JobsDbHelper JDBH=new JobsDbHelper(this);
            String names=JDBH.getName(JobID);
            TextView name= (TextView)findViewById(R.id.textBox1);
            name.setText("  Job Title: "+names+"\n  Status: ACCEPTED");
        }
    }
}
