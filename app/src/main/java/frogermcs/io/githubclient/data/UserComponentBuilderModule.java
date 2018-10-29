package frogermcs.io.githubclient.data;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import frogermcs.io.githubclient.ComponentBuilder;
import frogermcs.io.githubclient.ui.activity.component.RepositoriesListActivityComponent;
import frogermcs.io.githubclient.ui.activity.component.RepositoryDetailsActivityComponent;

@Module
public abstract class UserComponentBuilderModule {

    @Binds
    @IntoMap
    @ClassKey(RepositoriesListActivityComponent.class)
    public abstract ComponentBuilder bindRepositoriesListActivityComponentBuilder( RepositoriesListActivityComponent.Builder impl );

    @Binds
    @IntoMap
    @ClassKey(RepositoryDetailsActivityComponent.class)
    public abstract ComponentBuilder bindRepositoryDetailsActivityComponentBuilder( RepositoryDetailsActivityComponent.Builder impl );

}
