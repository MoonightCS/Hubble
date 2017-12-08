package bodya.popov.ru.hubble.users.data.repository;

import bodya.popov.ru.hubble.users.data.bean.request.SearchUsersRequestBean;
import bodya.popov.ru.hubble.users.data.bean.response.UsersResponseBean;
import rx.Single;

/**
 * @author Popov Bogdan
 */

/**
 * Предоставляет данные по пользователям Github
 */
public interface UsersRepository {

    UsersResponseBean getUsersResponse(SearchUsersRequestBean requestBean);

    Single<UsersResponseBean> getRxUsersResponse(SearchUsersRequestBean requestBean);


}
