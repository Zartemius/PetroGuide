package com.example.darte.petroguide.presenter.presentation.placescreen;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.darte.petroguide.R;
import com.example.darte.petroguide.presenter.constants.DataPassedBetweenActivities;

public class PlaceScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_screen);

        Toolbar toolbar = findViewById(R.id.app_bar_menu__toolbar);

        setSupportActionBar(toolbar);

        createFragment(new PlaceDescriptionScreen());
    }

    public void createFragment(Fragment newFragment){
        setData(newFragment);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.place_screen__fragments,newFragment);
        ft.commit();
    }

    private void setData(Fragment newFragment){

        Intent i = getIntent();
        String dataKey = DataPassedBetweenActivities.placeId;
        String placeId = i.getStringExtra(dataKey);

        Fragment targetFragment = newFragment;
        Bundle placeData = new Bundle();
        placeData.putString("placeId",placeId);
        targetFragment.setArguments(placeData);
    }
}
