package com.example.darryl.bathlaunchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button giveHandBtn;
    public Button needHandBtn;
    private Boolean give;
    private Boolean need;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("H!RED- It Works for you");
        //getActionBar().setIcon(R.drawable.icon);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ImageView icon= new ImageView(this);
//        icon.setImageResource(R.drawable.icon);


        give=true;
        need=true;
        giveHandThread();
        needHandThread();
    }

    public void giveHandThread(){
        giveHandBtn=(Button)findViewById(R.id.giveBtn);
        giveHandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(give){
                Intent intent= new Intent(MainActivity.this,GiveHand.class);
                startActivity(intent);
                    give=false;
                }else{
                    Intent intent= new Intent(MainActivity.this,GiveHandMenu.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void needHandThread(){
        needHandBtn=(Button)findViewById(R.id.needBtn);
        needHandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(need){
                    Intent intent= new Intent(MainActivity.this,NeedHand.class);
                    intent.putExtra("first",true);
                    startActivity(intent);

                    need=false;
                }else{
                    Intent intent= new Intent(MainActivity.this,NeedHandMenu.class);
                    startActivity(intent);
                }

            }
        });
    }

}
