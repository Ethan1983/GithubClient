package frogermcs.io.githubclient;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import frogermcs.io.githubclient.data.api.GithubApiModule;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                GithubApiModule.class,
                AppComponentBuilderModule.class,
                AndroidInjectionModule.class
        }
)
public interface AppComponent {

    void injectApp( GithubClientApplication application );

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application( Application application );
        AppComponent build();
    }

}