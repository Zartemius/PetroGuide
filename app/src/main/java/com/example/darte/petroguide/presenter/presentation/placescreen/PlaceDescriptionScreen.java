package com.example.darte.petroguide.presenter.presentation.placescreen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.darte.petroguide.R;
import com.squareup.picasso.Picasso;

public class PlaceDescriptionScreen extends Fragment {

    private ImageView mainPicture;
    private ImageView marker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.place_description, container, false);

        mainPicture = view.findViewById(R.id.place_description_screen__main_view);
        marker = view.findViewById(R.id.place_description_screen__marker);

        displayPicture("https://firebasestorage.googleapis.com/v0/b/petroguide-2a3bc.appspot.com/o/1_zb9My39w6yUUIULNX83acQ.jpeg?alt=media&token=c7067d16-5c29-44e4-92e7-5d66cc739851",mainPicture);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i("WHAT_HAPPENED", "HERE IN PLACE DESCRIPTION FRAGMENT AND ID IS " + getPlaceId());
    }

    void displayPicture(String pictureUrl, ImageView imageView){
        Picasso.get().load(pictureUrl).fit().into(imageView);
    }

    private String getPlaceId() {
        Bundle placeData = getArguments();
        String placeId = placeData.getString("placeId");
        return placeId;
    }



}
