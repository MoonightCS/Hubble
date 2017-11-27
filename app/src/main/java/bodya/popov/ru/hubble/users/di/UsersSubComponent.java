package bodya.popov.ru.hubble.users.di;

import bodya.popov.ru.hubble.users.di.module.ApiModule;
import bodya.popov.ru.hubble.users.di.module.UsersInteractorModule;
import bodya.popov.ru.hubble.users.di.module.UsersRepositoryModule;
import bodya.popov.ru.hubble.users.presentation.view.fragment.SearchUsersFragment;
import dagger.Subcomponent;

/**
 * @author Popov Bogdan
 */

@UsersScope
@Subcomponent(modules = {UsersRepositoryModule.class, UsersInteractorModule.class, ApiModule.class})
public interface UsersSubComponent {

    @Subcomponent.Builder
    interface Builder {
        UsersSubComponent build();
    }

    void inject(SearchUsersFragment fragment);

}
