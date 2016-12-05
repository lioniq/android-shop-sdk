package com.lioniqandroiddemo;

/**
 * Created by impressly on 2016/12/5.
 */

public class TabData {
    // title
    public static String[] getTabsTxt() {
        String[] tabs = {"Shop", "Cart"};
        return tabs;
    }


    // image normal
    public  static  int[] getTabsImg() {
        int[] ids = {
                R.drawable.home1,
                R.drawable.car1,
        };
        return ids;
    }

    // image press
    public static int[] getTabsImgLight() {
        int[] ids = {
                R.drawable.home2,
                R.drawable.car2,
        };
        return ids;
    }

    // Fragments
    public static Class[] getFragments() {
        Class[] classes = {
                ShopFragment.class,
                CartFragment.class
        };
        return classes;
    }

}
