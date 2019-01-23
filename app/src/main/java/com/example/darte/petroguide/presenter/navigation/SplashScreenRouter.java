package com.example.darte.petroguide.presenter.navigation;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class SplashScreenRouter{

    private Router mRouter;
    private NavigatorHolder mNavigationHolder;

    public SplashScreenRouter(Router router, NavigatorHolder navigatorHolder){
        mRouter = router;
        mNavigationHolder = navigatorHolder;
    }

    public void navigateForward() {
       mRouter.navigateTo(new Screens.MenuActivityScreen());
    }

    public void navigateBack() {
        mRouter.exit();
    }

    public void setNavigator(Navigator navigator) {
        mNavigationHolder.setNavigator(navigator);
    }

    public void removeNavigator() {
        mNavigationHolder.removeNavigator();
    }
}
