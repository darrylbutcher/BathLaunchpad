package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GiveHand extends AppCompatActivity {

    public Button submit;
    private int ID;
    private String FirstName;
    private String LastName;
    private String DOB;
    private String Uni;
    private String Skill;
    private String Bio;
    private EmployeeDbHelper EDBH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_hand);
        EDBH=new EmployeeDbHelper(this);
        submitThread();
    }

    public void submitThread(){
        submit=(Button)findViewById(R.id.addBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkInput()){
                    boolean isInserted=EDBH.insertData(FirstName,LastName,DOB,Uni,Skill,Bio);
                    if(isInserted){



                        Intent intent= new Intent(GiveHand.this,GiveHandMenu.class);
                        intent.putExtra("UserID",getUserID());
                        startActivity(intent);
                        Toast.makeText(GiveHand.this, "Job Added", Toast.LENGTH_LONG).show();
                        clearText();
                    }else{
                        Toast.makeText(GiveHand.this, "Failed", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(GiveHand.this, "ERROR! Make sure you fill in all fields!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public boolean checkInput() {
        setText();
        if(!FirstName.equals("")&& !LastName.equals("")&&!DOB.equals("")&&!Uni.equals("")&&!Skill.equals("")&&!Bio.equals("")){
            return true;
        }else{
            return false;
        }
    }

    public int getUserID(){
        EmployeeDbHelper EDBH= new EmployeeDbHelper(GiveHand.this);
        Cursor res=EDBH.getAllData();
        int id=0;
        while(res.moveToNext()){
            id=Integer.valueOf(res.getString(0));
        }
        return id;
    }

    public void setText(){
        FirstName=((EditText)findViewById(R.id.firstNameTxt)).getText().toString();
        LastName=((EditText)findViewById(R.id.lastNameTxt)).getText().toString();
        DOB=((EditText)findViewById(R.id.DOBTxt)).getText().toString();
        Uni=((EditText)findViewById(R.id.uniTxt)).getText().toString();
        Skill=((EditText)findViewById(R.id.skill1Txt)).getText().toString();
        Bio=((EditText)findViewById(R.id.BioTxt)).getText().toString();
    }

    public void clearText(){
        ((EditText)findViewById(R.id.firstNameTxt)).setText("");
        ((EditText)findViewById(R.id.lastNameTxt)).setText("");
        ((EditText)findViewById(R.id.DOBTxt)).setText("");
        ((EditText)findViewById(R.id.uniTxt)).setText("");
        ((EditText)findViewById(R.id.skill1Txt)).setText("");
        ((EditText)findViewById(R.id.BioTxt)).setText("");
    }

}
