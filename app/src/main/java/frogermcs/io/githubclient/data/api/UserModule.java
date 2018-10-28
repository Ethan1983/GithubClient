package frogermcs.io.githubclient.data.api;

import dagger.Module;
import dagger.Provides;
import frogermcs.io.githubclient.data.UserScope;
import frogermcs.io.githubclient.data.model.User;

/**
 * Created by Miroslaw Stanek on 23.06.15.
 */
@Module
public abstract class UserModule {

    @Provides
    @UserScope
    static RepositoriesManager provideRepositoriesManager(User user, GithubApiService githubApiService) {
        return new RepositoriesManager(user, githubApiService);
    }
}
