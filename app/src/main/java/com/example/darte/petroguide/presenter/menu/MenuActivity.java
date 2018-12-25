package com.example.darte.petroguide.presenter.menu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import com.example.darte.petroguide.R;
import com.example.darte.petroguide.presenter.map.MapFragment;

public class MenuActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mToolbar = findViewById(R.id.app_bar_menu__toolbar);
        mDrawerLayout = findViewById(R.id.activity_menu__drawer_layout);

        setSupportActionBar(mToolbar);

        createMenu();

        createFragment(new MapFragment());
    }

    public void createFragment(Fragment newFragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.app_bar_menu__fragments,newFragment);
        ft.commit();
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public void createMenu(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,mToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
}
