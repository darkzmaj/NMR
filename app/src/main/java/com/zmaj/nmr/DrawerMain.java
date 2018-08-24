package com.zmaj.nmr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.zmaj.nmr.DrugiUredjaji.DrugiUredjaji;

public class DrawerMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button interfon;
    Button dnevnaSoba;
    Button spavacaSoba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        interfon = (Button) findViewById(R.id.btnInterfon);
        interfon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        dnevnaSoba = (Button) findViewById(R.id.btnDnevnaSoba);
        dnevnaSoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        spavacaSoba = (Button) findViewById(R.id.btnSpavacaSoba);
        spavacaSoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

    }

    public void openActivity2() {
        Intent intent = new Intent(this, Drawer1Interfon.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Drawer2DnevnaSoba.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, Drawer3SpavacaSoba.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.g_meni) {
            // Handle the camera action
            Intent intent = new Intent(this, DrawerMain.class);
            startActivity(intent);
        } else if (id == R.id.interfon) {
            Intent intent = new Intent(this, Drawer1Interfon.class);
            startActivity(intent);
        } else if (id == R.id.dnevna_soba) {
            Intent intent = new Intent(this, Drawer2DnevnaSoba.class);
            startActivity(intent);
        } else if (id == R.id.spavaca_soba) {
            Intent intent = new Intent(this, Drawer3SpavacaSoba.class);
            startActivity(intent);
        } else if (id == R.id.drugi_uredjaji) {
            Intent intent = new Intent(this, DrugiUredjaji.class);
            startActivity(intent);

        } else if (id == R.id.podesavanja) {
            Intent intent = new Intent(this, Podesavanja.class);
            startActivity(intent);
        } else if (id == R.id.info) {
            Intent intent = new Intent(this, Info.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
                       //ovo se pokazalo ok
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            logout();

                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Provera");
            builder.setMessage("Da li ste sigurni?").setPositiveButton("Da", dialogClickListener)
                    .setNegativeButton("Ne", dialogClickListener).show();
            //



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void logout(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
