package com.ohiohealth.leviathan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LandingPageActivity extends AppCompatActivity {

    Button _webViewActivityButton;
    Button _listViewActivityButton;
    Button _spinnerViewActivityButton;
    Button _webRequestActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page_layout);

        _webViewActivityButton = (Button) this.findViewById(R.id.webview_button);
        _listViewActivityButton = (Button) this.findViewById(R.id.listview_button);
        _spinnerViewActivityButton = (Button) this.findViewById(R.id.spinnerview_button);
        _webRequestActivityButton = (Button) this.findViewById(R.id.webrequest_button);

        _webViewActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPageActivity.this, WebViewActivity.class));
            }
        });

        _listViewActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPageActivity.this, ListViewActivity.class));
            }
        });

        _spinnerViewActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPageActivity.this, SpinnerViewActivity.class));
            }
        });

        _webRequestActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPageActivity.this, WebRequestActivity.class));
            }
        });
    }

}
