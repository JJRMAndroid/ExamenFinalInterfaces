package com.nextu.jj.examenfinalinterfaces;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new AppBarWithoutTabsFragment())
                .commit();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);
    }

    public void updateView(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null)
            toolbar.setTitle(title);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;

        switch (id) {
            case R.id.nav_without_tabs:
                fragment = new AppBarWithoutTabsFragment();
                break;
            case R.id.nav_with_tabs:
                fragment = new AppBarWithTabsFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}

/*public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.redes_sociales);
        toolbar.setSubtitle(R.string.seccion1);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int idItem = item.getItemId();

        switch (idItem) {
            case R.id.nav_home:
                toolbar.setSubtitle(R.string.seccion1);
                ImageView imageView = (ImageView)findViewById (R.id.img_figura);
                imageView.setImageResource(R.drawable.home3);
                break;
            case R.id.nav_facebook:
                toolbar.setSubtitle(R.string.seccion2);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.nav_header_container);
                linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryFacebook));
                ImageView imageView2 = (ImageView)findViewById (R.id.img_figura);
                imageView2.setImageResource(R.drawable.noticias);
                break;
            case R.id.nav_instagram:
                toolbar.setSubtitle(R.string.seccion3);
                LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.nav_header_container);
                linearLayout1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryInstagram));
                //imageView2.setImageResource(R.drawable.noticias);
                break;
            case R.id.nav_google_plus:
                toolbar.setSubtitle(R.string.seccion4);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.nav_header_container);
                linearLayout2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryGooglePlus));
                break;
            case R.id.nav_twiter:
                toolbar.setSubtitle(R.string.seccion5);
                LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.nav_header_container);
                linearLayout3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryTwiter));
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}*/
