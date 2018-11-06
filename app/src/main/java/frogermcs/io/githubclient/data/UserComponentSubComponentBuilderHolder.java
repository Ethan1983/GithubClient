package frogermcs.io.githubclient.data;

import java.util.Map;

import javax.inject.Inject;

import frogermcs.io.githubclient.ComponentBuilder;

public class UserComponentSubComponentBuilderHolder {

    @Inject
    Map< Class<?>, ComponentBuilder> mapComponentBuilders;

    public UserComponentSubComponentBuilderHolder( UserComponent userComponent ) {

        userComponent.injectSubComponentBuilderHolder( this );

    }

    public ComponentBuilder getComponentBuilder( Class<?> clazz) {
        return mapComponentBuilders.get( clazz );
    }

}