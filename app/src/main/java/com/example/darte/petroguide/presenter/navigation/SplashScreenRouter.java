package com.example.darte.petroguide.presenter.navigation;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class SplashScreenRouter implements SmartRouter {

    private Router mRouter;
    private NavigatorHolder mNavigationHolder;

    public SplashScreenRouter(Router router, NavigatorHolder navigatorHolder){
        mRouter = router;
        mNavigationHolder = navigatorHolder;
    }

    @Override
    public void navigateForward() {
       mRouter.navigateTo(new Screens.MenuActivityScreen());
    }


    @Override
    public void navigateBack() {
        mRouter.exit();
    }

    @Override
    public void setNavigator(Navigator navigator) {
        mNavigationHolder.setNavigator(navigator);
    }

    @Override
    public void removeNavigator() {
        mNavigationHolder.removeNavigator();
    }
}
