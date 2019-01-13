package com.example.darte.petroguide.presenter.menu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
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
