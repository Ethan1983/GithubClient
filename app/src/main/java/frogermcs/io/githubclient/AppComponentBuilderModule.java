package frogermcs.io.githubclient;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import frogermcs.io.githubclient.data.UserComponent;
import frogermcs.io.githubclient.ui.activity.component.SplashActivityComponent;

@Module
public abstract class AppComponentBuilderModule {

    @Binds
    @IntoMap
    @ClassKey(UserComponent.class)
    public abstract ComponentBuilder bindUserComponentBuilder( UserComponent.Builder impl );

    @Binds
    @IntoMap
    @ClassKey(SplashActivityComponent.class)
    public abstract ComponentBuilder bindSplashActivityComponentBuilder( SplashActivityComponent.Builder impl );

}
