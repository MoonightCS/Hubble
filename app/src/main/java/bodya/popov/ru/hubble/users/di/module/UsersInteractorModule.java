package bodya.popov.ru.hubble.users.di.module;

import bodya.popov.ru.hubble.users.domain.repository.UsersRepository;
import bodya.popov.ru.hubble.users.di.UsersScope;
import bodya.popov.ru.hubble.users.domain.converter.UserBeanUserConverter;
import bodya.popov.ru.hubble.users.domain.interactor.UsersInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * @author Popov Bogdan
 */

@Module
public class UsersInteractorModule {

    @Provides
    @UsersScope
    UserBeanUserConverter provideUserBeanUserConverter() {
        return new UserBeanUserConverter();
    }

    @Provides
    @UsersScope
    UsersInteractor provideUsersInteractor(UsersRepository usersRepository, UserBeanUserConverter userConverter) {
        return new UsersInteractor(usersRepository, userConverter);
    }


}
