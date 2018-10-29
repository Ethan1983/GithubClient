package frogermcs.io.githubclient;

import android.app.Application;
import android.content.Context;

import com.frogermcs.androiddevmetrics.AndroidDevMetrics;

import javax.inject.Inject;

import frogermcs.io.githubclient.data.UserComponent;
import frogermcs.io.githubclient.data.UserComponentSubComponentBuilderHolder;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.ui.activity.component.SplashActivityComponent;
import timber.log.Timber;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
    public class GithubClientApplication extends Application {

    private AppComponent appComponent;
    private UserComponent userComponent;
    private UserComponentSubComponentBuilderHolder userComponentSubComponentBuilderHolder;
    @Inject
    UserComponent.Builder userComponentBuilder;
    @Inject
    SplashActivityComponent.Builder splashActivityComponentBuilder;

    public static GithubClientApplication get(Context context) {
        return (GithubClientApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            AndroidDevMetrics.initWith(this);
        }

        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .application( this )
                .build();

        appComponent.injectApp( this );
    }

    public UserComponent createUserComponent(User user) {
        userComponent = userComponentBuilder.user( user ).build();
        userComponentSubComponentBuilderHolder = new UserComponentSubComponentBuilderHolder( userComponent );
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
        userComponentSubComponentBuilderHolder = null;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponentSubComponentBuilderHolder getUserComponentSubComponentBuilderHolder() {
        return userComponentSubComponentBuilderHolder;
    }

    public SplashActivityComponent.Builder getSplashActivityComponentBuilder() {
        return splashActivityComponentBuilder;
    }

}