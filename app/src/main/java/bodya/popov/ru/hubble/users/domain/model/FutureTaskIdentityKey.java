package bodya.popov.ru.hubble.users.domain.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static bodya.popov.ru.hubble.users.domain.model.FutureTaskIdentityKey.SEARCH_USERS;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * @author Popov Bogdan
 */

@Retention(SOURCE)
@IntDef({SEARCH_USERS})
public @interface FutureTaskIdentityKey {

    int SEARCH_USERS = 0;

}
