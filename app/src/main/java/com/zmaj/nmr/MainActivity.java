package com.zmaj.nmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button interfonBut;
    private Button dnevnaSobaBut;
    private Button vikendica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interfonBut = (Button) findViewById(R.id.button);
        interfonBut.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                openActivity2();
            }
        });
//
        dnevnaSobaBut = (Button) findViewById(R.id.button2);
        dnevnaSobaBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}
