package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NeedHand extends AppCompatActivity {

    public Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_hand);
        submitThread();
    }

    public void submitThread(){
        submit=(Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NeedHand.this,ViewApplicants.class);
                startActivity(intent);
            }
        });
    }

}
