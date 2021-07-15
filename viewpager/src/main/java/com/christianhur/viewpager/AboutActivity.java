package com.christianhur.viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class AboutActivity extends AppCompatActivity {

    private final int MAX_TABS = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        MyViewPagerAdapter myViewPagerAdapter =
                new MyViewPagerAdapter(this,getSupportFragmentManager(),MAX_TABS);
        viewPager.setAdapter(myViewPagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        //tabLayout.setupWithViewPager(viewPager);

        String[] titles = {"About","Schools","Students","Staff"};
        for(int i=0; i<titles.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(titles[i]));
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}