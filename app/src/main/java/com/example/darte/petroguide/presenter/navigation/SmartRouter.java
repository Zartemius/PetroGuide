package com.example.darte.petroguide.presenter.navigation;

import ru.terrakok.cicerone.Navigator;

public interface SmartRouter {

    void navigateForward();
    void navigateBack();
    void setNavigator(Navigator navigator);
    void removeNavigator();
}
