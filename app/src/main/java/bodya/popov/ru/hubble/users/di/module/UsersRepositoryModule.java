package bodya.popov.ru.hubble.users.di.module;

import bodya.popov.ru.hubble.users.data.api.GithubUsersApi;
import bodya.popov.ru.hubble.users.data.repository.UsersRepository;
import bodya.popov.ru.hubble.users.data.repository.UsersRepositoryImpl;
import bodya.popov.ru.hubble.users.di.UsersScope;
import dagger.Module;
import dagger.Provides;

/**
 * @author Popov Bogdan
 */

@Module
public class UsersRepositoryModule {

    @Provides
    @UsersScope
    UsersRepository provideUsersRepository(GithubUsersApi api) {
        return new UsersRepositoryImpl(api);
    }

}
