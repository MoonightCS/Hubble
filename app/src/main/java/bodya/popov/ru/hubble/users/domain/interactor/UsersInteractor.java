package bodya.popov.ru.hubble.users.domain.interactor;

import android.util.LongSparseArray;

import java.util.List;
import java.util.concurrent.Callable;

import bodya.popov.ru.hubble.app.async.FutureTask;
import bodya.popov.ru.hubble.app.async.SingleAsyncExecution;
import bodya.popov.ru.hubble.users.data.bean.request.SearchUsersRequestBean;
import bodya.popov.ru.hubble.users.data.bean.response.UserBean;
import bodya.popov.ru.hubble.users.data.bean.response.UsersResponseBean;
import bodya.popov.ru.hubble.users.domain.repository.UsersRepository;
import bodya.popov.ru.hubble.users.domain.converter.UserBeanUserConverter;
import bodya.popov.ru.hubble.users.domain.model.User;
import rx.Single;
import rx.schedulers.Schedulers;

import static bodya.popov.ru.hubble.users.domain.model.FutureTaskIdentityKey.SEARCH_USERS;

/**
 * @author Popov Bogdan
 */

public class UsersInteractor {

    private final UsersRepository mRepository;
    private final UserBeanUserConverter mUserConverter;
    private LongSparseArray<FutureTask<List<User>>> mFutureTasksArray;

    public UsersInteractor(UsersRepository repository, UserBeanUserConverter userConverter) {
        mRepository = repository;
        mUserConverter = userConverter;
        mFutureTasksArray = new LongSparseArray<>();
    }

    public Single<List<User>> getSingleUserList(String query) {
        final SearchUsersRequestBean requestBean = new SearchUsersRequestBean();
        requestBean.setQuery(query);
        return mRepository.getRxUsersResponse(requestBean)
                .map(usersResponseBean -> mUserConverter.convertList(usersResponseBean.getUserBeanList()))
                .observeOn(Schedulers.computation());
    }

    public FutureTask<List<User>> getUserList(String query, SingleAsyncExecution.Callback<List<User>> callback) {
        FutureTask<List<User>> futureTask = mFutureTasksArray.get(SEARCH_USERS);
        if (futureTask != null && !futureTask.isDone()) {
            futureTask.cancel();
        }
        mFutureTasksArray.remove(SEARCH_USERS);
        final SearchUsersRequestBean requestBean = new SearchUsersRequestBean();
        requestBean.setQuery(query);

        SingleAsyncExecution<List<User>> singleAsyncExecution = SingleAsyncExecution.createFromCallableWithId(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                UsersResponseBean usersResponse = mRepository.getUsersResponse(requestBean);
                List<UserBean> userBeanList = usersResponse.getUserBeanList();
                return mUserConverter.convertList(userBeanList);
            }
        });
        FutureTask<List<User>> taskForArray = singleAsyncExecution
                .withCallback(callback)
                .execute();
        mFutureTasksArray.put(SEARCH_USERS, taskForArray);
        return taskForArray;
    }
}
