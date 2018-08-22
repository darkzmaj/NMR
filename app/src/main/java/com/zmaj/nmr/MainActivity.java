package com.zmaj.nmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zmaj.nmr.StareAktivnosti.Activity2;
import com.zmaj.nmr.StareAktivnosti.Activity3;
import com.zmaj.nmr.StareAktivnosti.Activity4;

public class MainActivity extends AppCompatActivity {

    private Button interfonBut;
    private Button dnevnaSobaBut;
    private Button vikendica;
    private Button test;

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

        vikendica = (Button) findViewById(R.id.button3);
        vikendica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity4();
            }
        });

        test = (Button) findViewById(R.id.button7);
        test.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity5();
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

    public void openActivity4(){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

    public void openActivity5(){
        Intent intent = new Intent(this, DrawerMain.class);
        startActivity(intent);
    }



}
