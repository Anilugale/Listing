package com.androidworks.anil.listing;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androidworks.anil.listing.fragment.AdList;
import com.androidworks.anil.listing.fragment.LandingPage;
import com.androidworks.anil.listing.fragment.Profile;
import com.androidworks.anil.listing.fragment.Regisration;
import com.androidworks.anil.listing.util.CommanMethod;

public class MainActivity extends AppCompatActivity implements   NavigationView.OnNavigationItemSelectedListener  {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contnainer);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(ContextCompat.getDrawable(this,R.mipmap.logo));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        setNavigation(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        goToLanding();
    }

    private void goToLanding() {
        FragmentManager manager =getSupportFragmentManager();
        LandingPage landingPage=(LandingPage) manager.findFragmentByTag(LandingPage.TAG);
        if(landingPage==null)
            landingPage=LandingPage.newInstance();

        manager.beginTransaction()
                .replace(R.id.frame,landingPage)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.userProfile) {

        goToProfile();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToProfile() {
        FragmentManager fm =getSupportFragmentManager();
        Regisration fragment=(Regisration) fm.findFragmentByTag(Regisration.TAG);
        if(fragment==null)
            fragment=Regisration.newInstance();
        fm.beginTransaction()
                .replace(R.id.frame,fragment)
                .addToBackStack(Regisration.TAG)
                .commit();
    }

    private void setNavigation(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.add_desc, R.string.add_desc);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        Menu menu=navigationView.getMenu();
        int i=0;
        for(String cat: CommanMethod.category)
        {

            menu.add(i,1,1,cat);
            i++;
        }
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fm =getSupportFragmentManager();
        AdList fragment=(AdList) fm.findFragmentByTag(AdList.TAG);
        if(fragment==null)
        {
            fragment=AdList.newInstance();
        }

        fm.beginTransaction()
                .replace(R.id.frame,fragment)
                .addToBackStack(AdList.TAG)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
