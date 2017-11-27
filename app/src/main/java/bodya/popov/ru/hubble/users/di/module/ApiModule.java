package bodya.popov.ru.hubble.users.di.module;

import bodya.popov.ru.hubble.users.data.api.GithubUsersApi;
import bodya.popov.ru.hubble.users.di.UsersScope;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Popov Bogdan
 */

@Module
public class ApiModule {

    @Provides
    @UsersScope
    GithubUsersApi provideGithubUsersApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(GithubUsersApi.class);
    }


    @Provides
    @UsersScope
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }

}
