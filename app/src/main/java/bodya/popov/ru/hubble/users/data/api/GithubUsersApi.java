package bodya.popov.ru.hubble.users.data.api;

import bodya.popov.ru.hubble.users.data.bean.response.UsersResponseBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

/**
 * @author Popov Bogdan
 */

public interface GithubUsersApi {

    @GET("/search/users")
    Call<UsersResponseBean> getData(@Query("q") String query);

    @GET("/search/users")
    Single<UsersResponseBean> getRxData(@Query("q") String query);

}
