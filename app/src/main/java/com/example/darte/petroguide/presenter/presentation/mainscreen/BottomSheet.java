package com.example.darte.petroguide.presenter.presentation.mainscreen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.darte.petroguide.presenter.PGApplication;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.darte.petroguide.R;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

import javax.inject.Inject;

public class BottomSheet extends BottomSheetDialogFragment implements BottomSheetView{

    @Inject BottomSheetPresenter mBottomSheetPresenter;
    private TextView mPlaceName;
    private Navigator mNavigator;
    private Button buttonLearnMore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet,container,false);

        getDialog().getWindow().setLayout(100, ViewGroup.LayoutParams.MATCH_PARENT);

        ((PGApplication) getActivity().getApplication()).getAppComponent().inject(this);

        buttonLearnMore = view.findViewById(R.id.bottom_sheet__button_learnMore);

        mPlaceName = view.findViewById(R.id.bottom_sheet__place_name);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavigator = new SupportAppNavigator(getActivity(),-1);

        buttonLearnMore.setOnClickListener(this::clicked);
    }


    @Override
    public void onResume() {
        super.onResume();
        mBottomSheetPresenter.subscribe(this);
        mBottomSheetPresenter.displayInformationAboutPlace();
        mBottomSheetPresenter.setNavigator(mNavigator);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBottomSheetPresenter.unsubscribe();
        mBottomSheetPresenter.removeNavigator();
    }

    @Override
    public String getPlaceId() {
        Bundle placeData = getArguments();
        String placeId = placeData.getString("placeId");
        return placeId;
    }

    @Override
    public void displayInfoAboutThePlace(Place place) {
        mPlaceName.setText(place.getName());
    }

    private void clicked(View view){
        mBottomSheetPresenter.navigateForward();
    }


}
