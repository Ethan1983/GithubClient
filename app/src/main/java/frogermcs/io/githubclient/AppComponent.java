package frogermcs.io.githubclient;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import frogermcs.io.githubclient.data.api.GithubApiModule;
import frogermcs.io.githubclient.data.UserComponent;
import frogermcs.io.githubclient.ui.activity.component.SplashActivityComponent;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                GithubApiModule.class
        }
)
public interface AppComponent {

    SplashActivityComponent.Builder splashActivityComponentBuilder();

    UserComponent.Builder userComponentBuilder();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application( Application application );
        AppComponent build();
    }

}