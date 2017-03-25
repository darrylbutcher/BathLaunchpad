package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button giveHandBtn;
    public Button needHandBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giveHandThread();
        needHandThread();
    }

    public void giveHandThread(){
        giveHandBtn=(Button)findViewById(R.id.giveBtn);
        giveHandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,GiveHand.class);
                startActivity(intent);
            }
        });
    }

    public void needHandThread(){
        needHandBtn=(Button)findViewById(R.id.needBtn);
        needHandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,NeedHand.class);
                startActivity(intent);
            }
        });
    }

}
