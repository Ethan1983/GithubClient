package frogermcs.io.githubclient.data;

import javax.inject.Inject;

import frogermcs.io.githubclient.ui.activity.component.RepositoriesListActivityComponent;
import frogermcs.io.githubclient.ui.activity.component.RepositoryDetailsActivityComponent;

public class UserComponentSubComponentBuilderHolder {

    @Inject
    RepositoriesListActivityComponent.Builder repositoriesListActivityComponentBuilder;

    @Inject
    RepositoryDetailsActivityComponent.Builder repositoryDetailsActivityComponentBuilder;

    public UserComponentSubComponentBuilderHolder( UserComponent userComponent ) {

        userComponent.injectSubComponentBuilderHolder( this );

    }

    public RepositoriesListActivityComponent.Builder getRepositoriesListActivityComponentBuilder() {
        return repositoriesListActivityComponentBuilder;
    }

    public RepositoryDetailsActivityComponent.Builder getRepositoryDetailsActivityComponentBuilder() {
        return repositoryDetailsActivityComponentBuilder;
    }

}