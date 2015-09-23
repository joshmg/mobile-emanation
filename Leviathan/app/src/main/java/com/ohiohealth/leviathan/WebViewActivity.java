package com.ohiohealth.leviathan;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView _webView;

    @Override
    public void onBackPressed() {
        if (_webView.canGoBack()) {
            _webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);


        _webView = (WebView) findViewById(R.id.activity_main_webview);
        _webView.getSettings().setJavaScriptEnabled(true);


        _webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO: handle staying within domain.

                view.loadUrl(url);
                return false;
            }
        });

        _webView.loadUrl("http://www.google.com");
    }


}
