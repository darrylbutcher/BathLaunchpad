package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GiveHandMenu extends AppCompatActivity {

    public Button findJobs;
    public Button viewOffers;
    private int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_hand_menu);
        Intent myIntent=getIntent();
        this.ID=myIntent.getIntExtra("UserID", 0);
        viewOffersThread();
        findJobsThread();
    }


    public void viewOffersThread(){
        viewOffers=(Button)findViewById(R.id.ViewOffersBtn);
        viewOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GiveHandMenu.this,ViewOffers.class);
                intent.putExtra("UserID",ID);
                startActivity(intent);
            }
        });
    }

    public void findJobsThread(){
        findJobs=(Button)findViewById(R.id.findJobBtn);
        findJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GiveHandMenu.this,FindJobs.class);
                intent.putExtra("UserID",ID);
                startActivity(intent);
            }
        });
    }
}
