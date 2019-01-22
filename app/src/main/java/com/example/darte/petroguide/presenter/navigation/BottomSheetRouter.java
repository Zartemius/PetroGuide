package com.example.darte.petroguide.presenter.navigation;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class BottomSheetRouter implements SmartRouter {

    private Router mRouter;
    private NavigatorHolder mNavigationHolder;

    public BottomSheetRouter(Router router, NavigatorHolder navigatorHolder){
        mRouter = router;
        mNavigationHolder = navigatorHolder;
    }

    @Override
    public void navigateForward() {
        mRouter.navigateTo(new Screens.PlaceScreenFragment());
    }

    @Override
    public void navigateBack() {
        mRouter.finishChain();
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
