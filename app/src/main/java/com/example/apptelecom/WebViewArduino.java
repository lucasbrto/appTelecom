package com.example.apptelecom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewArduino extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_arduino);


        //-----cria uma webview para exibir o site dentro do app
        WebView myWebView = (WebView) findViewById(R.id.webViewArduinoXML);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://drive.google.com/drive/folders/1NG_PD4AFfnzKkd-ZH0umvK2yymKFSgoq?usp=sharing");
    }
}
