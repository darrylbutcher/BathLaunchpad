package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NeedHand extends AppCompatActivity {

    public Button submit;
    private JobsDbHelper JDBH;
    private String JobTitle;
    private String JobRole;
    private String Description;
    private String Location;
    private String Date;
    private String Hours;
    private String Pay;
    private String Skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_hand);
        JDBH=new JobsDbHelper(this);
        submitThread();
    }

    public void submitThread(){
        submit=(Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkInput()){
                    boolean isInserted=JDBH.insertData(JobTitle,JobRole,Location,Description,Date,Hours,Pay,Skills);
                    if(isInserted){
                       Toast.makeText(NeedHand.this, "Job Added", Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(NeedHand.this,ViewApplicants.class);
                        startActivity(intent);
                        clearText();
                    }else{
                        Toast.makeText(NeedHand.this, "Failed", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(NeedHand.this, "ERROR! Make sure you fill in all fields!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean checkInput(){
        setText();
        if(!JobTitle.equals("")&& !JobRole.equals("")&&!Description.equals("")&&!Location.equals("")&&!Date.equals("")&& !Hours.equals("")&&!Pay.equals("")&&!Skills.equals("")){
            return true;
        }else{
            return false;
        }
    }

    public void setText(){
        JobTitle=((EditText)findViewById(R.id.JobTxt)).getText().toString();
        JobRole=((EditText)findViewById(R.id.roleTxt)).getText().toString();
        Description=((EditText)findViewById(R.id.descriptionTxt)).getText().toString();
        Location=((EditText)findViewById(R.id.LocationTxt)).getText().toString();
        Date=((EditText)findViewById(R.id.dateTxt)).getText().toString();
        Hours=((EditText)findViewById(R.id.hoursTxt)).getText().toString();
        Pay=((EditText)findViewById(R.id.payTxt)).getText().toString();
        Skills=((EditText)findViewById(R.id.skillTxt)).getText().toString();
    }

    public void clearText(){
        ((EditText)findViewById(R.id.JobTxt)).setText("");
        ((EditText)findViewById(R.id.roleTxt)).setText("");
        ((EditText)findViewById(R.id.descriptionTxt)).setText("");
        ((EditText)findViewById(R.id.LocationTxt)).setText("");
        ((EditText)findViewById(R.id.dateTxt)).setText("");
        ((EditText)findViewById(R.id.hoursTxt)).setText("");
        ((EditText)findViewById(R.id.payTxt)).setText("");
        ((EditText)findViewById(R.id.skillTxt)).setText("");
    }

}
