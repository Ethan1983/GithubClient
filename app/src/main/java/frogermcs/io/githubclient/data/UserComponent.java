package frogermcs.io.githubclient.data;

import dagger.BindsInstance;
import dagger.Subcomponent;
import frogermcs.io.githubclient.data.api.UserModule;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.ui.activity.component.RepositoriesListActivityComponent;
import frogermcs.io.githubclient.ui.activity.component.RepositoryDetailsActivityComponent;
import frogermcs.io.githubclient.ui.activity.component.SplashActivityComponent;
import frogermcs.io.githubclient.ui.activity.module.RepositoriesListActivityModule;
import frogermcs.io.githubclient.ui.activity.module.RepositoryDetailsActivityModule;
import frogermcs.io.githubclient.ui.activity.module.SplashActivityModule;

/**
 * Created by Miroslaw Stanek on 23.06.15.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    RepositoriesListActivityComponent.Builder repositoriesListActivityComponentBuilder();

    RepositoryDetailsActivityComponent.Builder repositoryDetailsActivityComponentBuilder();

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance Builder user( User user );
        UserComponent build();
    }
}