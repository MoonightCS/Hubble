package bodya.popov.ru.hubble.users.domain.interactor;

import java.util.List;
import java.util.concurrent.Callable;

import bodya.popov.ru.hubble.app.async.FutureTask;
import bodya.popov.ru.hubble.app.async.SingleAsyncExecution;
import bodya.popov.ru.hubble.users.data.bean.request.SearchUsersRequestBean;
import bodya.popov.ru.hubble.users.data.bean.response.UserBean;
import bodya.popov.ru.hubble.users.data.bean.response.UsersResponseBean;
import bodya.popov.ru.hubble.users.data.repository.UsersRepository;
import bodya.popov.ru.hubble.users.domain.converter.UserBeanUserConverter;
import bodya.popov.ru.hubble.users.domain.model.User;

/**
 * @author Popov Bogdan
 */

public class UsersInteractor {

    private final UsersRepository mRepository;
    private final UserBeanUserConverter mUserConverter;

    public UsersInteractor(UsersRepository repository, UserBeanUserConverter userConverter) {
        mRepository = repository;
        mUserConverter = userConverter;
    }

    public FutureTask<List<User>> configureUserList(String query, SingleAsyncExecution.Callback callback) {
        final SearchUsersRequestBean requestBean = new SearchUsersRequestBean();
        requestBean.setQuery(query);

        SingleAsyncExecution<List<User>> singleAsyncExecution = SingleAsyncExecution.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                UsersResponseBean usersResponse = mRepository.getUsersResponse(requestBean);
                List<UserBean> userBeanList = usersResponse.getUserBeanList();
                return mUserConverter.convertList(userBeanList);
            }
        });
        return singleAsyncExecution
                .withCallback(callback)
                .execute();
    }
}
