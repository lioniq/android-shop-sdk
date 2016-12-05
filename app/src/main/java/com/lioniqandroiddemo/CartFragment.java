package com.lioniqandroiddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.lioniq.LIQJavascriptInterface;
import com.lioniq.LIQView;

/**
 * Created by impressly on 2016/12/5.
 */

public class CartFragment extends Fragment {

    private LIQView liqView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cart_view, container, false);

        WebView webView = (WebView)view.findViewById(R.id.cartWebView);
        setupWebView();
        webView.addView(liqView);

        // 加载cartView
        liqView.reloadCart();

        return view;
    }


    private void setupWebView() {

        // 创建 LIQView实例 实现 LIQJavascriptInterface 接口
        liqView = new LIQView(getContext(), new LIQJavascriptInterface() {

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
            public void webviewSearchDidCancel() {}

        });
    }



}
