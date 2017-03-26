package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GiveHand extends AppCompatActivity {

    public Button submit;
    private String FirstName;
    private String LastName;
    private String DOB;
    private String Uni;
    private String Skill;
    private String Bio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_hand);
        menuThread();
    }

    public void menuThread(){
        submit=(Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GiveHand.this,GiveHandMenu.class);
                startActivity(intent);
//                if(checkInput()){
//                    if(true){
//                        Toast.makeText(GiveHand.this, "Data Added", Toast.LENGTH_LONG).show();
//                        Intent intent= new Intent(GiveHand.this,ViewApplicants.class);
//                        startActivity(intent);
//                        clearText();
//                    }else{
//                        Toast.makeText(GiveHand.this, "Failed", Toast.LENGTH_LONG).show();
//                    }
//                }else{
//                    Toast.makeText(GiveHand.this, "ERROR! Make sure you fill in all fields!", Toast.LENGTH_LONG).show();
//                }
            }
        });
    }


    public boolean checkInput(){
        setText();
        if(!FirstName.equals("")&& !LastName.equals("")&&!DOB.equals("")&&!Uni.equals("")&&!Skill.equals("")&&!Bio.equals("")){
            return true;
        }else{
            return false;
        }
    }

    public void setText(){
        FirstName=((EditText)findViewById(R.id.firstNameTxt)).getText().toString();
        LastName=((EditText)findViewById(R.id.lastNameTxt)).getText().toString();
        DOB=((EditText)findViewById(R.id.DOBTxt)).getText().toString();
        Uni=((EditText)findViewById(R.id.uniTxt)).getText().toString();
        Skill=((EditText)findViewById(R.id.skillTxt)).getText().toString();
        Bio=((EditText)findViewById(R.id.BioTxt)).getText().toString();
    }

    public void clearText(){
        ((EditText)findViewById(R.id.firstNameTxt)).setText("");
        ((EditText)findViewById(R.id.lastNameTxt)).setText("");
        ((EditText)findViewById(R.id.DOBTxt)).setText("");
        ((EditText)findViewById(R.id.uniTxt)).setText("");
        ((EditText)findViewById(R.id.skillTxt)).setText("");
        ((EditText)findViewById(R.id.BioTxt)).setText("");
    }

}
