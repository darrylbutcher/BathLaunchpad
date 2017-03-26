package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NeedHandMenu extends AppCompatActivity {

    private static int JobID;
    public Button viewApp;
    public Button viewJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_hand_menu);
        Intent intent=getIntent();
        JobID=intent.getIntExtra("JobID",0);
        viewApplicantsThread();
    }

    public void viewApplicantsThread(){
        viewApp=(Button)findViewById(R.id.ViewAppliBtn);
        viewApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NeedHandMenu.this,ViewApplicants.class);
                intent.putExtra("JobID",JobID);
                Toast.makeText(NeedHandMenu.this, String.valueOf(JobID), Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

    public void findJobsThread(){
        viewJob=(Button)findViewById(R.id.findJobBtn);
        viewJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NeedHandMenu.this,FindJobs.class);
                intent.putExtra("JobID",JobID);
                startActivity(intent);
            }
        });
    }

}
