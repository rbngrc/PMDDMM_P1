package com.androidavanzado.pmddmm_eval1_ruben_garcia_diez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EverisWebActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everis_web);

        mBottomNavigationView = findViewById(R.id.btnNavBar);
        mBottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.abrirNavegador){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.everisschool.com/"));
                    startActivity(intent);
                } if (item.getItemId() == R.id.localizacion) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:41.6269323,-4.717817"));
                    startActivity(intent);
                }

            }
        });

        webView = findViewById(R.id.webViewEveris);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.everisschool.com/");

    }
}