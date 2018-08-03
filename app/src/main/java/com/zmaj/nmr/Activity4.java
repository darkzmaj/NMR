package com.zmaj.nmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Activity4 extends AppCompatActivity {
    WebView webview;
    private Button glavniMeniDug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        webview = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://192.168.1.106");

        glavniMeniDug = (Button) findViewById(R.id.button6);
        glavniMeniDug.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                glavniMeni();
            }
        });
    }
    public void glavniMeni(){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }


}

