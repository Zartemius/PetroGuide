package com.example.darte.petroguide.presenter.navigation;

import android.content.Context;
import android.content.Intent;
import com.example.darte.petroguide.presenter.constants.DataPassedBetweenActivities;
import com.example.darte.petroguide.presenter.presentation.menu.MenuActivity;
import com.example.darte.petroguide.presenter.presentation.placescreen.PlaceScreen;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

class Screens {

    public static class MenuActivityScreen extends SupportAppScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, MenuActivity.class);
        }
    }

    public static final class PlaceScreenInstance extends SupportAppScreen {

        private String mId;
        private String mKeyName = DataPassedBetweenActivities.placeId;

        public PlaceScreenInstance(String id){
            mId = id;
        }

        @Override
        public Intent getActivityIntent(Context context) {
            Intent intent = new Intent(context,PlaceScreen.class);
            intent.putExtra(mKeyName,mId);
            return intent;
        }
    }
}

