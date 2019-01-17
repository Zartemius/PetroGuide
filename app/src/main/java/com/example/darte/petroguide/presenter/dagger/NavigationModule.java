package com.example.darte.petroguide.presenter.dagger;

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
    Router provideRouter(){
        return cicerone.getRouter();
    }

    @Provides
    NavigatorHolder provideNavigationHolder(){
        return cicerone.getNavigatorHolder();
    }

    @Provides
    SplashScreenRouter provideSplashScreenRouter(Router router, NavigatorHolder navigatorHolder){
        return new SplashScreenRouter(router,navigatorHolder);
    }
}
