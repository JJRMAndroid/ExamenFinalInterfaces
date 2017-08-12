package com.nextu.jj.examenfinalinterfaces;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.nextu.jj.examenfinalinterfaces.adaptador.BaseViewPagerAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TabLayout tabLayout;
    Toolbar toolbar;

    int colorPrimary ;
    int colorPrimaryDark;
    int idItem;

    String titulo = "Inicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new Inicio())
                .commit();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);

        Log.i("onCreate","onCreate");
    }

    public void updateView(String title) {
      toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            toolbar.setTitle(title);
        }

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);

        //Cambio de color toolbar
        toolbar.setSubtitle(titulo);
        toolbar.setBackgroundColor(colorPrimary);
        //Cambio de imagen toolbar
        cambiaImagen(idItem);

        toogle.syncState();

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        if (tabLayout != null) {
            //Cambio de color tabLayout
            tabLayout.setBackgroundColor(colorPrimary);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        idItem = item.getItemId();

        Fragment fragment = null;
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        switch (idItem) {
            case R.id.nav_home:
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimary);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDark);
                titulo = "Inicio";
                fragment = new Inicio();
                break;

            case R.id.nav_facebook:
                titulo = "Facebook";
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryFacebook);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkFacebook);
                fragment = new RedesSociales();
                break;
            case R.id.nav_instagram:
                titulo = "Instagram";
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryInstagram);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkInstagram);
                fragment = new RedesSociales();
                break;
            case R.id.nav_google_plus:
                titulo = "Google Plus";
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryGooglePlus);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkGooglePlus);
                fragment = new RedesSociales();
                break;
            case R.id.nav_twiter:
                titulo = "Twiter";
                colorPrimary = ContextCompat.getColor(this, R.color.colorPrimaryTwiter);
                colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDarkTwiter);
                fragment = new RedesSociales();
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null)
        {
            cambiaColor(colorPrimary, colorPrimaryDark);
        }

        return true;
    }

    private void cambiaColor(int colorPrimary, int colorPrimaryDark){

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.nav_header_container);
        linearLayout.setBackgroundColor(colorPrimary);

        Drawable bgColor = new ColorDrawable(colorPrimary);

        if(getSupportActionBar() != null){
            getSupportActionBar().setBackgroundDrawable(bgColor);
        }

        if (Build.VERSION.SDK_INT >= 21){
            getWindow().setStatusBarColor(colorPrimaryDark);
        }

    }

    public void cambiaImagen(int redSocial){

        int tab1 = 0;
        int tab2 = 0;
        int tab3 = 0;
        int imagen = 0;
        int titulo = 0;

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        switch(redSocial){
            case R.id.nav_facebook:
                tab1 = R.drawable.noticias;
                tab2 = R.drawable.group;
                tab3 = R.drawable.earth;
                imagen = R.array.facebook;
                titulo = R.array.facebook_titulo;
                break;
            case R.id.nav_instagram:
                tab1 = R.drawable.search;
                tab2 = R.drawable.camara;
                tab3 = R.drawable.like;
                imagen = R.array.instagram;
                titulo = R.array.instagram_titulo;
                break;
            case R.id.nav_google_plus:
                tab1 = R.drawable.grid;
                tab2 = R.drawable.grupo_g;
                tab3 = R.drawable.campana;
                imagen = R.array.google_plus;
                titulo = R.array.google_plus_titulo;
                break;
            case R.id.nav_twiter:
                tab1 = R.drawable.campana;
                tab2 = R.drawable.mensaje;
                tab3 = R.drawable.search;
                imagen = R.array.twiter;
                titulo = R.array.twiter_titulo;
                break;
        }

        if (getSupportActionBar() != null)
            getSupportActionBar().setElevation(0);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        if (viewPager != null)
            viewPager.setAdapter(new BaseViewPagerAdapter(getSupportFragmentManager(), getApplicationContext(), imagen, titulo));

        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = tabLayout.getTabAt(i);
                Drawable icon = null;
                switch (i) {
                    case 0:
                        icon = ContextCompat.getDrawable(this, tab1);
                        break;
                    case 1:
                        icon = ContextCompat.getDrawable(this, tab2);
                        break;
                    case 2:
                        icon = ContextCompat.getDrawable(this, tab3);
                        break;
                }
                DrawableCompat.setTint(icon, ContextCompat.getColor(this, android.R.color.white));
                if (tab != null)
                    tab.setIcon(icon);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
