package com.zmaj.nmr;

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

public class Udaljen extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udaljen);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Udaljen.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
        final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);

        Button mLogin = (Button) mView.findViewById(R.id.btnLogin);


        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Udaljen.this,
                        "lol da",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                String test ="http://" + mEmail.getText().toString();

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
