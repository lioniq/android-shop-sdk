package com.lioniqandroiddemo;

import android.app.Activity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.lioniq.LIQManager;

public class MainActivity extends AppCompatActivity {

    public LIQManager liqManager = LIQManager.getInstance();

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 拷贝资源到本地文件夹
        liqManager.setup(this);

        // 保存 key, secret
        String userID = "xyz123123";
        liqManager.set_appUserId(userID);

        String key = "15ef0668e2f7d3234c1706997156c8a2";
        String secret = "2ab6633650437c8bb29ee5bcdf072034";
        liqManager.setAppKey(this, key, secret);

        // tabHost
        setupTabHost();
    }


    private void setupTabHost() {
        tabHost = (FragmentTabHost) super.findViewById(android.R.id.tabhost);
        // Tab内容容器contentLayout
        // MARK: 实例化了tabWidget和tabContent
        tabHost.setup(this, super.getSupportFragmentManager(), R.id.contentLayout);
        //设置选项卡之间的可拉的使用作为一个分频器指标
        tabHost.getTabWidget().setDividerDrawable(null);
        initTab();
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                updateTab();
            }
        });
    }

    private void initTab() {
        String tabs[] = TabData.getTabsTxt();
        for (int i = 0; i < tabs.length; i++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabs[i]).setIndicator(getTabView(i)); //添加title, iamge
            tabHost.addTab(tabSpec, TabData.getFragments()[i], null); // 添加标签,设置内容
            tabHost.setTag(i);
        }
    }

    private View getTabView(int idx) {
        View view = LayoutInflater.from(this).inflate(R.layout.footer_tabs, null);
        ((TextView) view.findViewById(R.id.tvTab)).setText(TabData.getTabsTxt()[idx]);
        if (idx == 0) {
            ((TextView) view.findViewById(R.id.tvTab)).setTextColor(getResources().getColor(R.color.colorTheme));
            ((ImageView) view.findViewById(R.id.ivImg)).setImageResource(TabData.getTabsImgLight()[idx]);
        } else {
            ((ImageView) view.findViewById(R.id.ivImg)).setImageResource(TabData.getTabsImg()[idx]);
        }

        return view;
    }


    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);

    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }

    // 点击选项切换title和image
    private void updateTab() {
        // TabWidget切换卡
        TabWidget tabWidget = tabHost.getTabWidget();
        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            View view = tabWidget.getChildAt(i);
            ImageView imageView = (ImageView) view.findViewById(R.id.ivImg);
            if (i == tabHost.getCurrentTab()) {
                ((TextView) view.findViewById(R.id.tvTab)).setTextColor(getResources().getColor(R.color.colorTheme));
                imageView.setImageResource(TabData.getTabsImgLight()[i]);
            } else {
                ((TextView) view.findViewById(R.id.tvTab)).setTextColor(getResources().getColor(R.color.colorUnselected));
                imageView.setImageResource(TabData.getTabsImg()[i]);
            }
        }
    }


}
