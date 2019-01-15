package com.example.darte.petroguide.presenter.navigation;

import android.content.Context;
import android.content.Intent;
import com.example.darte.petroguide.presenter.presentation.menu.MenuActivity;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

class Screens {

    public static class MenuActivityScreen extends SupportAppScreen{
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context,MenuActivity.class);
        }
    }
}
