package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        Intent intent=getIntent();
        int ID= intent.getIntExtra("UserID",0);
        ID=2;
        TextView text=(TextView) findViewById(R.id.textBox);
        text.setTextSize(25);
        String profile="";
        EmployeeDbHelper EBDH= new EmployeeDbHelper(this);
        Cursor res=EBDH.getAllDataOfUser(ID);
        while(res.moveToNext()){
            profile+="First Name: "+res.getString(1)+"\n\n";
            profile+="Last Name: "+res.getString(2)+"\n\n";
            profile+="Date of Birth: "+res.getString(3)+"\n\n";
            profile+="Uni: "+res.getString(4)+"\n\n";
            profile+="Skills: "+res.getString(5)+"\n\n";
            profile+="Short Bio: "+res.getString(6)+"\n\n";
            profile+="*****************\n\n";
            profile+="REVIEWS:\n\n";
            profile+="None yet.";

        }
        text.setText(profile);
    }
}
