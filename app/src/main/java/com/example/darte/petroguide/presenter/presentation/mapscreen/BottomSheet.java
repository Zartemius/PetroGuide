package com.example.darte.petroguide.presenter.presentation.mapscreen;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.darte.petroguide.R;

public class BottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet,container,false);

        getDialog().getWindow().setLayout(100,ViewGroup.LayoutParams.MATCH_PARENT);
        return view;
    }
}
