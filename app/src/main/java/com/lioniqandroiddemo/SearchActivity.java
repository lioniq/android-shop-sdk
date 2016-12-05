package com.lioniqandroiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.lioniq.LIQJavascriptInterface;
import com.lioniq.LIQView;

/**
 * Created by impressly on 2016/12/5.
 */

public class SearchActivity extends Activity {

    private LIQView liqView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        WebView webView = (WebView)findViewById(R.id.searchWebView);
        setupWebView();
        webView.addView(liqView);

        // 加载searchView
        liqView.reloadSearch();
    }


    private void setupWebView() {

        // 创建 LIQView实例 实现 LIQJavascriptInterface 接口
        liqView = new LIQView(this, new LIQJavascriptInterface() {

            @JavascriptInterface
            @Override
            public void didAddToCart(String itemData) {
                Log.d("itemData", itemData.toString());
            }

            @JavascriptInterface
            @Override
            public void didItemDetail(String item) {}

            @JavascriptInterface
            @Override
            public void didLoadItemDetail(String itemData) {}

            @JavascriptInterface
            @Override
            public void didMain(String didmain) {
                Log.d("[LIQJavascriptInterface didMain]", "");
            }

            @Override
            public void webviewDidCheckout() {}

            @Override
            public void webviewDidOrder(String orderData) {}

            @Override
            public void webviewSearchDidCancel() {
                // 返回shop
                finish();
            }

        });
    }

}
