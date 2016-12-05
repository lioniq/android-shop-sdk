package com.lioniqandroiddemo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.lioniq.LIQJavascriptInterface;
import com.lioniq.LIQManager;
import com.lioniq.LIQView;

/**
 * Created by impressly on 2016/12/5.
 */

public class ShopFragment extends Fragment {

    private LIQView liqView;
    public LIQManager liqManager = LIQManager.getInstance();

    private View navigationBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shop_view, container, false);

        navigationBar = view.findViewById(R.id.shopNavigationBar);
        setupNavigationBar();


        WebView webView = (WebView)view.findViewById(R.id.shopWebView);
        setupWebView();
        webView.addView(liqView);

        // 加载shopView
        liqView.reloadShop();

        // 可选 加载离线数据
        liqManager.setShopData(getContext(), "shop_data.json");

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

    private void setupNavigationBar() {

        ImageButton rightImageButton = (ImageButton)navigationBar.findViewById(R.id.rightImageButton);
        rightImageButton.setImageResource(R.drawable.search);

        rightImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到搜索
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

}
