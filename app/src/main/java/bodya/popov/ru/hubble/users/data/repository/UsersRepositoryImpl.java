package bodya.popov.ru.hubble.users.data.repository;

import android.util.Log;

import java.io.IOException;

import bodya.popov.ru.hubble.users.data.api.GithubUsersApi;
import bodya.popov.ru.hubble.users.data.bean.request.SearchUsersRequestBean;
import bodya.popov.ru.hubble.users.data.bean.response.UsersResponseBean;
import bodya.popov.ru.hubble.users.domain.repository.UsersRepository;
import rx.Single;

/**
 * @author Popov Bogdan
 */

public class UsersRepositoryImpl implements UsersRepository {

    private static final String TAG = "UsersRepositoryImpl";

    private GithubUsersApi mApi;

    public UsersRepositoryImpl(GithubUsersApi api) {
        mApi = api;
    }

    @Override
    public UsersResponseBean getUsersResponse(SearchUsersRequestBean requestBean) {
        UsersResponseBean responseBean = null;
        try {
            responseBean = mApi.getData(requestBean.getQuery()).execute().body();
        } catch (IOException e) {
            Log.e(TAG, "A network error occurred in getUsersResponse() method");
            e.printStackTrace();
        }
        return responseBean;
    }

    @Override
    public Single<UsersResponseBean> getRxUsersResponse(SearchUsersRequestBean requestBean) {
        return mApi.getRxData(requestBean.getQuery());
    }

}
