package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ViewApplicants extends AppCompatActivity {

    private int JobID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_applicants);
        Intent intent=getIntent();
        JobID= intent.getIntExtra("JobID",0);
    }
}
