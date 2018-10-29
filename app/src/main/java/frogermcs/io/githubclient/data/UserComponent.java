package frogermcs.io.githubclient.data;

import dagger.BindsInstance;
import dagger.Subcomponent;
import frogermcs.io.githubclient.data.api.UserModule;
import frogermcs.io.githubclient.data.model.User;

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

    void injectSubComponentBuilderHolder( UserComponentSubComponentBuilderHolder builderHolder );

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance Builder user( User user );
        UserComponent build();
    }
}