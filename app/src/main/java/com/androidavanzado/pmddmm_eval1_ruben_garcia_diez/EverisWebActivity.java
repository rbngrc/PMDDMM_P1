package com.androidavanzado.pmddmm_eval1_ruben_garcia_diez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EverisWebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everis_web);

        webView = findViewById(R.id.webViewEveris);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.everisschool.com/");

    }
}