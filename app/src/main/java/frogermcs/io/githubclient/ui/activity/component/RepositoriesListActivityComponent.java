package frogermcs.io.githubclient.ui.activity.component;

import dagger.BindsInstance;
import dagger.Subcomponent;
import frogermcs.io.githubclient.ComponentBuilder;
import frogermcs.io.githubclient.ui.activity.ActivityScope;
import frogermcs.io.githubclient.ui.activity.RepositoriesListActivity;
import frogermcs.io.githubclient.ui.activity.module.RepositoriesListActivityModule;
import frogermcs.io.githubclient.ui.activity.presenter.RepositoriesListActivityPresenter;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoriesListActivityModule.class
)
public interface RepositoriesListActivityComponent {

    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<RepositoriesListActivityComponent> {

        @BindsInstance Builder repositoriesListActivity( RepositoriesListActivity repositoriesListActivity );

    }

}