package frogermcs.io.githubclient;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frogermcs.io.githubclient.utils.AnalyticsManager;
import frogermcs.io.githubclient.utils.Validator;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
@Module
public abstract class AppModule {

    @Provides
    @Singleton
    static AnalyticsManager provideAnalyticsManager( Application application ) {
        return new AnalyticsManager(application);
    }

    @Provides
    @Singleton
    static Validator provideValidator() {
        return new Validator();
    }

    @Provides
    @Singleton
    static HeavyExternalLibrary provideHeavyExternalLibrary() {
        HeavyExternalLibrary heavyExternalLibrary = new HeavyExternalLibrary();
        heavyExternalLibrary.init();
        return heavyExternalLibrary;
    }

    @Provides
    @Singleton
    static HeavyLibraryWrapper provideLibraryWrapper() {
        return new HeavyLibraryWrapper();
    }
}