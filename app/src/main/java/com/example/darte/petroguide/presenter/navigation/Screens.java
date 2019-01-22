package com.example.darte.petroguide.presenter.navigation;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.example.darte.petroguide.presenter.presentation.menu.MenuActivity;
import com.example.darte.petroguide.presenter.presentation.placescreen.PlaceScreen;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

class Screens {

    public static class MenuActivityScreen extends SupportAppScreen{
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context,MenuActivity.class);
        }
    }

    public static final class PlaceScreenFragment extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new PlaceScreen();
        }
    }
}

