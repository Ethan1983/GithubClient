package frogermcs.io.githubclient;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.frogermcs.androiddevmetrics.AndroidDevMetrics;

import java.util.Map;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import frogermcs.io.githubclient.data.UserComponent;
import frogermcs.io.githubclient.data.UserComponentSubComponentBuilderHolder;
import frogermcs.io.githubclient.data.model.User;
import timber.log.Timber;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
public class GithubClientApplication extends Application implements HasActivityInjector {

    private AppComponent appComponent;
    private UserComponent userComponent;
    private UserComponentSubComponentBuilderHolder userComponentSubComponentBuilderHolder;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Inject
    Map< Class<?>,ComponentBuilder> mapComponentbuilders;

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
        final UserComponent.Builder builder = (UserComponent.Builder) mapComponentbuilders.get(UserComponent.class);
        assert builder != null;
        userComponent = builder.user( user ).build();
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

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}