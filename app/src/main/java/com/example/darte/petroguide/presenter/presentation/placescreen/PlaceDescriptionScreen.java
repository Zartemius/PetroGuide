package com.example.darte.petroguide.presenter.presentation.placescreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.darte.petroguide.R;
import com.example.darte.petroguide.presenter.constants.DataPassedBetweenActivities;

public class PlaceDescriptionScreen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.place_description, container, false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Log.i("WHAT_HAPPENED", "HERE IN PLACE DESCIRPTION FRAGMENT AND ID IS " + getPlaceId() );
    }

   /* private String getPlaceId() {
        Bundle placeData = getArguments();
        String placeId = placeData.getString("placeId");
        return placeId;
    }*/
}
