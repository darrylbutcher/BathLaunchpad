package com.example.darryl.bathlaunchpad;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewApplicants extends AppCompatActivity {

    private static int JobID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_applicants);
        Intent intent=getIntent();
        JobID= intent.getIntExtra("JobID",0);
        JobID=5;
        //Toast.makeText(ViewApplicants.this, String.valueOf(JobID), Toast.LENGTH_LONG).show();
        MatchesDbHelper MBDH= new MatchesDbHelper(this);
        Cursor res=MBDH.getUsers(JobID);
        LinearLayout panel=(LinearLayout)findViewById(R.id.pane);
        res.getCount();
        while(res.moveToNext()){
            LinearLayout row= new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
            int userID=res.getInt(0);
            EmployeeDbHelper EBDH=new EmployeeDbHelper(this);
            String names=EBDH.getName(userID);
            TextView name= new TextView(this);
            name.setId(userID);
            name.setWidth(200);
            name.setText("  "+names);
            row.addView(name);
            Button view= new Button(this);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getId();
                    Intent intent= new Intent(ViewApplicants.this,ViewProfile.class);
                    startActivity(intent);

                }
            });
            view.setText("VIEW PROFILE");

            row.addView(view);
            Button accept= new Button(this);
            accept.setText("HIRE");
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ViewApplicants.this, "HIRED!", Toast.LENGTH_LONG).show();
                }
            });
            row.addView(accept);
            Button decline= new Button(this);
            decline.setText("FIRE");
            row.addView(decline);
            decline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ViewApplicants.this, "FIRED!", Toast.LENGTH_LONG).show();
                }
            });

            panel.addView(row);
        }
    }
}
