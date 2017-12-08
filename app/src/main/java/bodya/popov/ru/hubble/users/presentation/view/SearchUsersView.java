package bodya.popov.ru.hubble.users.presentation.view;

import java.util.List;

import bodya.popov.ru.hubble.users.domain.model.User;

/**
 * @author Popov Bogdan
 */

public interface SearchUsersView extends BaseView {


    void showUsers(List<User> userList);

    void showNoFoundUsers(boolean show);



}
