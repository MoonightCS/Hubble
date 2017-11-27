package bodya.popov.ru.hubble.users.presentation;

/**
 * @author Popov Bogdan
 */

public interface ActionNavigator {

    /**
     * Перейти к детальному просмотру пользователя
     */
    void gotoCountManager();

    /**
     * вернуться на предыдущий экран
     */
    void goBack();


}
