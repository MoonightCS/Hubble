package bodya.popov.ru.hubble.users.presentation.presenter;

import java.util.List;

import javax.inject.Inject;

import bodya.popov.ru.hubble.users.domain.interactor.UsersInteractor;
import bodya.popov.ru.hubble.users.domain.model.User;
import bodya.popov.ru.hubble.users.presentation.view.SearchUsersView;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        singleUserList
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::consumeSuccessResult, throwable -> mView.showLoadingIndicator(false));
    }

    private void consumeSuccessResult(List<User> userList) {
        mView.showNoFoundUsers(userList.isEmpty());
        mView.showUsers(userList);
        mView.showLoadingIndicator(false);
    }


}
