package frogermcs.io.githubclient.ui.activity.component;

import dagger.BindsInstance;
import dagger.Subcomponent;
import frogermcs.io.githubclient.ComponentBuilder;
import frogermcs.io.githubclient.ui.activity.ActivityScope;
import frogermcs.io.githubclient.ui.activity.RepositoryDetailsActivity;
import frogermcs.io.githubclient.ui.activity.module.RepositoryDetailsActivityModule;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoryDetailsActivityModule.class
)
public interface RepositoryDetailsActivityComponent {

    RepositoryDetailsActivity inject(RepositoryDetailsActivity repositoryDetailsActivity);

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<RepositoryDetailsActivityComponent> {

        @BindsInstance Builder repositoryDetailsActivity( RepositoryDetailsActivity repositoryDetailsActivity);

    }

}