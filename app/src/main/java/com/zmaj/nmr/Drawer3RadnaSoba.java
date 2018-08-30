package com.zmaj.nmr;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.zmaj.nmr.DrugiUredjaji.DrugiUredjaji;
public class Drawer3RadnaSoba extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    WebView webview;
    ToggleButton btnToggle1;
    ToggleButton btnToggle2;
    ToggleButton btnToggle3;
    ToggleButton btnToggle4;
    ToggleButton btnToggle5;
    ToggleButton btnToggle6;
    ToggleButton btnToggle7;
    ToggleButton btnToggle8; //imaginarni alarm
    Button btnUkljuciSve;
    Button btnIskljuciSve;
    Button btnUlazUKucu;
    Button btnIzlazIzKuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer3_radna_soba);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnToggle1 = (ToggleButton) findViewById(R.id.toggBtn1);
        btnToggle2 = (ToggleButton) findViewById(R.id.toggBtn2);
        btnToggle3 = (ToggleButton) findViewById(R.id.toggBtn3);
        btnToggle4 = (ToggleButton) findViewById(R.id.toggBtn4);
        btnToggle5 = (ToggleButton) findViewById(R.id.toggBtn5);
        btnToggle6 = (ToggleButton) findViewById(R.id.toggBtn6);
        btnToggle7 = (ToggleButton) findViewById(R.id.toggBtn7);
        btnToggle8 = (ToggleButton) findViewById(R.id.toggBtn8);
        btnUkljuciSve = (Button) findViewById(R.id.btnUkljuciSve);
        btnIskljuciSve = (Button) findViewById(R.id.btnIskljuciSve);
        btnUlazUKucu = (Button) findViewById(R.id.btnUlazUKucu);
        btnIzlazIzKuce = (Button) findViewById(R.id.btnIzlazIzKuce);
        //
        btnToggle1.setChecked(getDefaults("nesto1", this));
        setDefaults("nesto1", btnToggle1.isChecked(), this);
        btnToggle2.setChecked(getDefaults("nesto2", this));
        setDefaults("nesto2", btnToggle2.isChecked(), this);
        btnToggle3.setChecked(getDefaults("nesto3", this));
        setDefaults("nesto3", btnToggle3.isChecked(), this);
        btnToggle4.setChecked(getDefaults("nesto4", this));
        setDefaults("nesto4", btnToggle4.isChecked(), this);
        btnToggle5.setChecked(getDefaults("nesto5", this));
        setDefaults("nesto5", btnToggle5.isChecked(), this);
        btnToggle6.setChecked(getDefaults("nesto6", this));
        setDefaults("nesto6", btnToggle6.isChecked(), this);
        btnToggle7.setChecked(getDefaults("nesto7", this));
        setDefaults("nesto7", btnToggle7.isChecked(), this);
        btnToggle8.setChecked(getDefaults("nesto8", this));
        setDefaults("nesto8", btnToggle8.isChecked(), this);
        //
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //



        btnToggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle1.isChecked()) {
                    ukljuci1();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci1();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        btnUlazUKucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ulazUKucu();
                Context context = getApplicationContext();
                CharSequence text = "Sve ukljuceno, alarm iskljucen.";
                //
                btnToggle1.setChecked(false);
                btnToggle2.setChecked(false);
                btnToggle3.setChecked(false);
                btnToggle4.setChecked(false);
                btnToggle5.setChecked(false);
                btnToggle6.setChecked(false);
                btnToggle7.setChecked(false);
                btnToggle8.setChecked(true);
                //
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        btnIzlazIzKuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                izlazIzKuce();
                Context context = getApplicationContext();
                CharSequence text = "Sve iskljuceno, alarm ukljucen.";
                //
                btnToggle1.setChecked(true);
                btnToggle2.setChecked(true);
                btnToggle3.setChecked(true);
                btnToggle4.setChecked(true);
                btnToggle5.setChecked(true);
                btnToggle6.setChecked(true);
                btnToggle7.setChecked(true);
                btnToggle8.setChecked(false);
                //
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        btnToggle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle2.isChecked()) {
                    ukljuci2();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci2();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        btnToggle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle3.isChecked()) {
                    ukljuci3();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci3();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        btnToggle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle4.isChecked()) {
                    ukljuci4();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci4();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        btnToggle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle5.isChecked()) {
                    ukljuci5();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci5();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        btnToggle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle6.isChecked()) {
                    ukljuci6();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci6();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        btnToggle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle7.isChecked()) {
                    ukljuci7();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci7();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        btnToggle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle8.isChecked()) {
                    ukljuci8();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je uključen!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    iskljuci8();
                    Context context = getApplicationContext();
                    CharSequence text = "Uređaj je isključen.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        //kraj testa
        btnUkljuciSve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ukljuciSve();
            }
        });
        btnIskljuciSve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iskljuciSve();
            }
        });
//webview deo
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107");
///webview deo
    }

    @Override
    public void onStart(){
        super.onStart();

        btnToggle1.setChecked(getDefaults("nesto1",this));
        btnToggle2.setChecked(getDefaults("nesto2",this));
        btnToggle3.setChecked(getDefaults("nesto3",this));
        btnToggle4.setChecked(getDefaults("nesto4",this));
        btnToggle5.setChecked(getDefaults("nesto5",this));
        btnToggle6.setChecked(getDefaults("nesto6",this));
        btnToggle7.setChecked(getDefaults("nesto7",this));
        btnToggle8.setChecked(getDefaults("nesto8",this));

    }


    @Override
    public void onStop(){
        super.onStop();

        setDefaults("nesto1", btnToggle1.isChecked(), this);
        setDefaults("nesto2", btnToggle2.isChecked(), this);
        setDefaults("nesto3", btnToggle3.isChecked(), this);
        setDefaults("nesto4", btnToggle4.isChecked(), this);
        setDefaults("nesto5", btnToggle5.isChecked(), this);
        setDefaults("nesto6", btnToggle6.isChecked(), this);
        setDefaults("nesto7", btnToggle7.isChecked(), this);
        setDefaults("nesto8", btnToggle8.isChecked(), this);

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
        getMenuInflater().inflate(R.menu.drawer_radna_soba, menu);
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

    //pokusaj restore

//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        // Restore UI state from the savedInstanceState.
//        // This bundle has also been passed to onCreate.
//        boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
//        double myDouble = savedInstanceState.getDouble("myDouble");
//        int myInt = savedInstanceState.getInt("MyInt");
//        String myString = savedInstanceState.getString("MyString");
//
//        //btnToggle1.setChecked(false);
//    }

    //pokusaj restore


    //pokusaj cuvanja 2



    //pokusaj 2 end


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
        } else if (id == R.id.radna_soba) {
            Intent intent = new Intent(this, Drawer3RadnaSoba.class);
            startActivity(intent);
        } else if (id == R.id.drugi_uredjaji) {
            Intent intent = new Intent(this, DrugiUredjaji.class);
            startActivity(intent);
        } else if (id == R.id.podesavanja) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.info) {
            Intent intent = new Intent(this, Info.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            //ovo se pokazalo ok
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
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

    public void ulazUKucu() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/ulazUKucu");
    }

    public void izlazIzKuce() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/izlazIzKuce");
    }

    public void logout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void ukljuci1() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/13/on");
    }

    public void iskljuci1() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/13/off");
    }

    public void ukljuci2() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/12/on");
    }

    public void iskljuci2() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/12/off");
    }

    public void ukljuci3() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/14/on");
    }

    public void iskljuci3() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/14/off");
    }

    public void ukljuci4() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/2/on");
    }

    public void iskljuci4() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/2/off");
    }

    public void ukljuci5() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/0/on");
    }

    public void iskljuci5() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/0/off");
    }

    public void ukljuci6() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/4/on");
    }

    public void iskljuci6() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/4/off");
    }

    public void ukljuci7() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/5/on");
    }

    public void iskljuci7() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/5/off");
    }

    public void ukljuci8() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/16/on");
    }

    public void iskljuci8() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/16/off");
    }

    public void ukljuciSve() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/redno/on");
        btnToggle1.setChecked(true);
        btnToggle2.setChecked(true);
        btnToggle3.setChecked(true);
        btnToggle4.setChecked(true);
        btnToggle5.setChecked(true);
        btnToggle6.setChecked(true);
        btnToggle7.setChecked(true);
        btnToggle8.setChecked(true);
    }

    public void iskljuciSve() {
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.107/redno/off");
        btnToggle1.setChecked(false);
        btnToggle2.setChecked(false);
        btnToggle3.setChecked(false);
        btnToggle4.setChecked(false);
        btnToggle5.setChecked(false);
        btnToggle6.setChecked(false);
        btnToggle7.setChecked(false);
        btnToggle8.setChecked(false);
    }

//kod za cuvanje stanja
    public static void setDefaults(String key, Boolean value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }


    public static Boolean getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, true);
    }

    //kraj koda za cuvanje stanja

}
