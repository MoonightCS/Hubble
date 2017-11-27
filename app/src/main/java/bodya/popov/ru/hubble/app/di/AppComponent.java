package bodya.popov.ru.hubble.app.di;

import javax.inject.Singleton;

import bodya.popov.ru.hubble.users.di.UsersSubComponent;
import dagger.Component;

/**
 * @author Popov Bogdan
 */

@Singleton
@Component
public interface AppComponent {

    UsersSubComponent.Builder usersSubComponentBuilder();

}
