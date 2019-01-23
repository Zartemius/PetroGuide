package com.example.darte.petroguide.presenter.navigation;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class BottomSheetRouter {

    private Router mRouter;
    private NavigatorHolder mNavigationHolder;

    public BottomSheetRouter(Router router, NavigatorHolder navigatorHolder){
        mRouter = router;
        mNavigationHolder = navigatorHolder;
    }

    public void navigateForward(String id) {
        mRouter.navigateTo(new Screens.PlaceScreenInstance(id));
    }

    public void navigateBack() {
        mRouter.finishChain();
    }

    public void setNavigator(Navigator navigator) {
        mNavigationHolder.setNavigator(navigator);
    }

    public void removeNavigator() {
        mNavigationHolder.removeNavigator();
    }
}
