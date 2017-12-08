package bodya.popov.ru.hubble.users.presentation.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import bodya.popov.ru.hubble.app.async.SingleAsyncExecution;
import bodya.popov.ru.hubble.users.domain.interactor.UsersInteractor;
import bodya.popov.ru.hubble.users.domain.model.User;
import bodya.popov.ru.hubble.users.presentation.view.SearchUsersView;
import rx.Single;

/**
 * @author Popov Bogdan
 */

public class UserListPresenter {

    private SearchUsersView mView;
    private boolean isLoaded;

    private UsersInteractor mUsersInteractor;

    @Inject
    public UserListPresenter(UsersInteractor usersInteractor) {
        mUsersInteractor = usersInteractor;
    }

    public void attachView(SearchUsersView view) {
        mView = view;
        if (isLoaded) {
            mView.showLoadingIndicator(false);
        }
    }

    public void detachView() {
        mView = null;
    }

    public void onSearchBtnClicked(final String searchValue) {
        isLoaded = false;
        mView.showLoadingIndicator(true);
        Single<List<User>> singleUserList = mUsersInteractor.getSingleUserList(searchValue);
        singleUserList.subscribe(userList -> {
            mView.showUsers(userList);
            mView.showLoadingIndicator(false);
        }, throwable -> mView.showLoadingIndicator(false));
    }


    private SingleAsyncExecution.Callback<List<User>> mSearchCallback = new SingleAsyncExecution.Callback<List<User>>() {
        @Override
        public void onSuccess(@NonNull List<User> result) {
            mView.showUsers(result);
            mView.showLoadingIndicator(false);
        }

        @Override
        public void onException(Exception e) {
            mView.showLoadingIndicator(false);
        }
    };


}
