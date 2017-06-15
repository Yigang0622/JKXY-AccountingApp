package com.jikexueyuan.accountingt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.LinkedList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    LinkedList<String> dates = new LinkedList<>();
    LinkedList<MainFragment> fragments = new LinkedList<>();


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }


    private void initFragments(){

        Log.e("Adapter","INIT");


        dates = GlobalUtil.getInstance().recordDatabaseHelper.readAvailableDate();

        dates.add("1");
        dates.add("2");
        dates.add("3");
        dates.add("4");

        fragments.clear();

        for (String str: dates){
            MainFragment fragment = new MainFragment(str);
            fragments.add(fragment);
        }



    }

    public int getLastIndex(){
        return fragments.size() -1;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
