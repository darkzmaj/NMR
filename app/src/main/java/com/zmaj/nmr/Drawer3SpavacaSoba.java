package com.zmaj.nmr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zmaj.nmr.DrugiUredjaji.DrugiUredjaji;

public class Drawer3SpavacaSoba extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer3_spavaca_soba);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.105");

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
        getMenuInflater().inflate(R.menu.drawer_spavaca_soba, menu);
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
        }
        else if (id == R.id.spavaca_soba) {
            Intent intent = new Intent(this, Drawer3SpavacaSoba.class);
            startActivity(intent);
        }
        else if (id == R.id.drugi_uredjaji) {
            Intent intent = new Intent(this, DrugiUredjaji.class);
            startActivity(intent);

        }
        else if (id == R.id.podesavanja) {
            Intent intent = new Intent(this, Podesavanja.class);
            startActivity(intent);
        } else if (id == R.id.info) {
            Intent intent = new Intent(this, Info.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
