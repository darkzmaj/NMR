package com.zmaj.nmr.DrugiUredjaji;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zmaj.nmr.R;

public class Lokal extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udaljen);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Lokal.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_lokal, null);
        final EditText adresa = (EditText) mView.findViewById(R.id.adresa);

        Button mLogin = (Button) mView.findViewById(R.id.btnLogin);


        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Lokal.this,
                        "Uspeh",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                String test ="http://192.168." + adresa.getText().toString();

                webview = (WebView) findViewById(R.id.webView);

                WebSettings webSettings = webview.getSettings();

                webSettings.setJavaScriptEnabled(true);

                webview.setWebViewClient(new WebViewClient());

                webview.loadUrl(test);


            }
        });


    }

    ;
}
