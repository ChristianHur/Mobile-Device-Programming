package com.christianhur.viewpager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.christianhur.viewpager.fragments.AboutFragment;
import com.christianhur.viewpager.fragments.SchoolsFragment;
import com.christianhur.viewpager.fragments.StudentsFragment;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private int tabTotal = 0;
    private Context context;
    public MyViewPagerAdapter(Context context, FragmentManager fm, int tabTotal) {
        super(fm);
        this.tabTotal = tabTotal;
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0: return new AboutFragment();
            case 1: return new SchoolsFragment();
            case 2: return new StudentsFragment();
        }
        return new AboutFragment();
    }

    @Override
    public int getCount() {
        return tabTotal;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        switch(position) {
//            case 0: return context.getResources().getText(R.string.tab_about);
//            case 1: return context.getResources().getText(R.string.tab_schools);
//            case 2: return context.getResources().getText(R.string.tab_students);
//        }
        return null;
    }
}
