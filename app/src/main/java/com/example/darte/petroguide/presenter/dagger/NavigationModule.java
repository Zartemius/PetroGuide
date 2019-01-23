package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.navigation.BottomSheetRouter;
import com.example.darte.petroguide.presenter.navigation.SplashScreenRouter;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import javax.inject.Singleton;

@Module
public class NavigationModule {
    private Cicerone<Router> cicerone;

    public NavigationModule(){
        cicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    Router provideRouter(){
        return cicerone.getRouter();
    }

    @Provides
    @Singleton
    NavigatorHolder provideNavigationHolder(){
        return cicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    SplashScreenRouter provideSplashScreenRouter(Router router, NavigatorHolder navigatorHolder){
        return new SplashScreenRouter(router,navigatorHolder);
    }

    @Provides
    @Singleton
    BottomSheetRouter provideBottomSheetRouter(Router router, NavigatorHolder navigatorHolder){
        return new BottomSheetRouter(router,navigatorHolder);
    }
}
