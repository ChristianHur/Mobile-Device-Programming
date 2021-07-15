package com.christianhur.myfavoriteactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.christianhur.myfavoriteactivities.ui.EateryFragment;
import com.christianhur.myfavoriteactivities.ui.HomeFragment;
import com.christianhur.myfavoriteactivities.ui.HotelFragment;
import com.christianhur.myfavoriteactivities.ui.UserFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activate Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Activate drawerlayout
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_open_drawer, R.string.nav_close_drawer);
        toggle.syncState();

        //Load default fragment
        loadFragment(new HomeFragment());

        //Respond to user clicks (events)
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        
        //** Method 1
        navigationView.setNavigationItemSelectedListener(this);

        //** Method 2
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return onSelectedItem(item);  //create your own function
//            }
//        });

        //Method 3
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment = new HomeFragment();
//                switch (item.getItemId()) {
//                    case R.id.nav_user:
//                        fragment = new UserFragment();
//                        break;
//                    case R.id.nav_eatery:
//                        fragment = new EateryFragment();
//                        break;
//                    case R.id.nav_hotel:
//                        fragment = new HotelFragment();
//                        break;
//                    case R.id.nav_contact:
//                        startActivity(new Intent(MainActivity.this, ContactActivity.class));
//                        break;
//                    case R.id.nav_location:
//                        startActivity(new Intent(MainActivity.this, LocationActivity.class));
//                        break;
//                }
//
//                loadFragment(fragment);
//                drawer.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });

    }

//    public boolean onSelectedItem(MenuItem item){
//        Fragment fragment = new HomeFragment();
//        switch(item.getItemId()){
//            case R.id.nav_user:
//                fragment = new UserFragment();
//                break;
//            case R.id.nav_eatery:
//                fragment = new EateryFragment();
//                break;
//            case R.id.nav_hotel:
//                fragment = new HotelFragment();
//                break;
//            case R.id.nav_contact:
//                startActivity(new Intent(MainActivity.this,ContactActivity.class));
//                break;
//            case R.id.nav_location:
//                startActivity(new Intent(MainActivity.this,LocationActivity.class));
//                break;
//        }
//
//        loadFragment(fragment);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = new HomeFragment();
        switch (item.getItemId()) {
            case R.id.nav_user:
                fragment = new UserFragment();
                break;
            case R.id.nav_eatery:
                fragment = new EateryFragment();
                break;
            case R.id.nav_hotel:
                fragment = new HotelFragment();
                break;
            case R.id.nav_contact:
                startActivity(new Intent(MainActivity.this, ContactActivity.class));
                break;
            case R.id.nav_location:
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
                break;
        }

        loadFragment(fragment);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}