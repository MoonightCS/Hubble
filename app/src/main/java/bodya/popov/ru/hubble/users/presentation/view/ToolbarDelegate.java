package bodya.popov.ru.hubble.users.presentation.view;

import android.support.v7.widget.Toolbar;

/**
 * @author Popov Bogdan
 */

public interface ToolbarDelegate {

    /**
     * установить текущий тулбар
     */
    void setToolbar(Toolbar toolbar);

    /**
     * показать кнопку "домой" как "назад"
     *
     * @param showHomeAsUp true, если показывать кнопку "домой" как "назад"
     */
    void setDisplayHomeAsUpEnabled(boolean showHomeAsUp);

    /**
     * показать/убрать кнопку "домой"
     *
     * @param show true, если показывать кнопку "домой"
     */
    void showHomeButton(boolean show);

}
