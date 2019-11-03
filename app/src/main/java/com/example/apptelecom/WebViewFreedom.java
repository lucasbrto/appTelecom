package com.example.apptelecom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewFreedom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_freedom);


        //-----cria uma webview para exibir o site dentro do app
        WebView myWebView = (WebView) findViewById(R.id.webViewFreedomXML);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://drive.google.com/drive/folders/17hGf85mIdvaqjtrtDp5wB8qL8HVvOgOW?usp=sharing");
    }
}
