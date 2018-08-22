package com.zmaj.nmr.DrugiUredjaji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zmaj.nmr.R;

public class DrugiUredjaji extends AppCompatActivity {

    Button adresa;
    Button broj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugi_uredjaji);

        adresa = (Button) findViewById(R.id.btnUdaljen);
        adresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                udaljenAktivnost();
            }
        });

        broj = (Button) findViewById(R.id.btnLokal);
        broj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                udaljenLokal();
            }
        });

    }

    public void udaljenAktivnost() {
        Intent intent = new Intent(this, Udaljen.class);

        startActivity(intent);
    }

    public void udaljenLokal() {
        Intent intent = new Intent(this, Lokal.class);

        startActivity(intent);
    }

}
