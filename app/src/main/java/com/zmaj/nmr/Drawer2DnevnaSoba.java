package com.zmaj.nmr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.ImageButton;

import com.zmaj.nmr.DrugiUredjaji.DrugiUredjaji;

public class Drawer2DnevnaSoba extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    WebView webview;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btnUkljuciCeluKucu;
    Button btnIskljuciCeluKucu;
    ImageButton img1, img2, img3, img4;

    //
    public interface DelayCallback {
        void afterDelay();
    }

    public static void delay(int secs, final DelayCallback delayCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, secs * 1000);
    }

    //

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer2_dnevna_soba);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);


        img1 = (ImageButton) findViewById(R.id.btnDnevnaSobaSvetloON);
        img2 = (ImageButton) findViewById(R.id.btnDnevnaSobaSvetloOFF);
        img3 = (ImageButton) findViewById(R.id.btnDnevnaSobaLedON);
        img4 = (ImageButton) findViewById(R.id.btnDnevnaSobaLedOFF);


        btnUkljuciCeluKucu = (Button) findViewById(R.id.btnUkljuciCeluKucu);
        btnIskljuciCeluKucu = (Button) findViewById(R.id.btnIskljuciCeluKucu);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ukljuciLedTrake();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iskljuciLedTrake();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ukljuciLampe();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iskljuciLampe();
            }
        });


        btnUkljuciCeluKucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int secs = 1;

                delay(secs, new DelayCallback() {
                    @Override
                    public void afterDelay() {

                        ukljuciLampe();
                        delay(1, new DelayCallback() {
                            @Override
                            public void afterDelay() {

                                ukljuciLedTrake();

                                delay(1, new DelayCallback() {
                                    @Override
                                    public void afterDelay() {

                                        ukljuciSveNode();

                                    }
                                });

                            }
                        });

                    }
                });


            }
        });

        btnIskljuciCeluKucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int secs = 1;
                delay(secs, new DelayCallback() {
                    @Override
                    public void afterDelay() {
                        iskljuciLampe();
                        delay(1, new DelayCallback() {
                            @Override
                            public void afterDelay() {
                                iskljuciLedTrake();
                                delay(1, new DelayCallback() {
                                    @Override
                                    public void afterDelay() {
                                        iskljuciSveNode();


                                    }
                                });
                            }
                        });
                    }
                });
            }
        });


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ovo dugme treba da ukljucuje lampu lampu
                ukljuciLampe();
//
            }

        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iskljuciLampe();
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ukljuciLedTrake();
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iskljuciLedTrake();
            }
        });


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
        getMenuInflater().inflate(R.menu.drawer2_dnevna_soba, menu);
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
                            //Ne
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

    public void logout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    //


    void ukljuciLampe() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.200/light1on");
    }

    void iskljuciLampe() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.200/light1off");
    }

    void ukljuciLedTrake() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.200/light2on");
    }

    void iskljuciLedTrake() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.200/light2off");


    }

    void ukljuciV1() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.106/4/on");


    }

    void iskljuciV1() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.106/4/off");


    }


    void ukljuciV2() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.5.106/5/on");
    }

    void iskljuciV2() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.106/5/off");
    }


//NodeMCU redno

    public void ukljuciSveNode() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.107/redno/on");
    }

    public void iskljuciSveNode() {
        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.5.107/redno/off");
    }

    //
}
