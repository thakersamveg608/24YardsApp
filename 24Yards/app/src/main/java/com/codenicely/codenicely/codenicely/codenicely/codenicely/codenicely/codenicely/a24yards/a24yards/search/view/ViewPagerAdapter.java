package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vrihas on 26/7/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new RentFragment();
            case 1:
                return new BuyFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int index) {
        String title = null;
        switch (index){
            case 0:
                return title = "RENT";
            case 1:
                return title = "BUY";
        }
        return title;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
