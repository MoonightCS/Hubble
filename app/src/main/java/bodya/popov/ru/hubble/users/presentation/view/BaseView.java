package bodya.popov.ru.hubble.users.presentation.view;

/**
 * @author Popov Bogdan
 */

public interface BaseView {

    /**
     * показать/скрыть индикатор загрузки
     *
     * @param loading true - чтобы показать, false - скрыть
     */
    void showLoadingIndicator(boolean loading);


}
