package com.zmaj.nmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        b1 = (Button) findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nazad();
            }
        });


    }

    public void nazad(){
        Intent intent = new Intent(this, DrawerMain.class);
        startActivity(intent);
    }
}
