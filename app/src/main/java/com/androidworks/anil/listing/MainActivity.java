package com.androidworks.anil.listing;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.androidworks.anil.listing.fragment.LandingPage;
import com.androidworks.anil.listing.fragment.Profile;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contnainer);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(ContextCompat.getDrawable(this,R.mipmap.logo));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
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

    private void goToProfile() {
        FragmentManager fm =getSupportFragmentManager();
        Profile fragment=(Profile) fm.findFragmentByTag(Profile.TAG);
        if(fragment==null)
            fragment=Profile.newInstance();
        fm.beginTransaction()
                .replace(R.id.frame,fragment)
                .addToBackStack(Profile.TAG)
                .commit();
    }
}
