package frogermcs.io.githubclient;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import frogermcs.io.githubclient.data.UserComponent;
import frogermcs.io.githubclient.data.UserComponentSubComponentBuilderHolder;
import frogermcs.io.githubclient.ui.activity.SplashActivity;
import frogermcs.io.githubclient.ui.activity.component.SplashActivityComponent;

@Module
public abstract class AppComponentBuilderModule {

    @Binds
    @IntoMap
    @ClassKey(UserComponent.class)
    public abstract ComponentBuilder bindUserComponentBuilder( UserComponent.Builder impl );

    @Binds
    @IntoMap
    @ClassKey(SplashActivity.class)
    public abstract AndroidInjector.Factory<?> bindSplashActivityInjectorFactory(SplashActivityComponent.Builder builder );

}
