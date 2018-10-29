package frogermcs.io.githubclient.data;

import java.util.Map;

import javax.inject.Inject;

import frogermcs.io.githubclient.ComponentBuilder;
import frogermcs.io.githubclient.ui.activity.component.RepositoriesListActivityComponent;
import frogermcs.io.githubclient.ui.activity.component.RepositoryDetailsActivityComponent;

public class UserComponentSubComponentBuilderHolder {

    @Inject
    Map< Class<?>, ComponentBuilder> mapComponentBuilders;

    @Inject
    RepositoriesListActivityComponent.Builder repositoriesListActivityComponentBuilder;

    @Inject
    RepositoryDetailsActivityComponent.Builder repositoryDetailsActivityComponentBuilder;

    public UserComponentSubComponentBuilderHolder( UserComponent userComponent ) {

        userComponent.injectSubComponentBuilderHolder( this );

    }

    public ComponentBuilder getComponentBuilder( Class<?> clazz) {
        return mapComponentBuilders.get( clazz );
    }

}