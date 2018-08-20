package com.zmaj.nmr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrugiUredjaji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugi_uredjaji);

        Button mShowDialog =(Button) findViewById(R.id.btnShowDialog);
        mShowDialog.setOnClickListener(new View.OnClickListener() { //dovoljno je samo V za autocomplete
            @Override
            public void onClick(View view) {

            }
        });

    }
}
