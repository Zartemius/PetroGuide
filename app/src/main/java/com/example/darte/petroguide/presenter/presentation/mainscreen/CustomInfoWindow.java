package com.example.darte.petroguide.presenter.presentation.mainscreen;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.example.darte.petroguide.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {

    private Context mContext;

    CustomInfoWindow(Context context){
        mContext = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = ((Activity)mContext).getLayoutInflater().inflate(R.layout.map_custom_info_window,null);

        TextView placeName = view.findViewById(R.id.map_custom_info_window__name);
        TextView placeAddress = view.findViewById(R.id.map_custom_info_window__address);

        placeName.setText(marker.getTitle());
        placeAddress.setText(marker.getSnippet());
        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
