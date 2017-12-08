package bodya.popov.ru.hubble.users.di.module;

import bodya.popov.ru.hubble.users.data.api.GithubUsersApi;
import bodya.popov.ru.hubble.users.di.UsersScope;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Popov Bogdan
 */

@Module
public class ApiModule {

    @Provides
    @UsersScope
    GithubUsersApi provideGithubUsersApi(OkHttpClient okHttpClient,
                                         Converter.Factory converterFactory, CallAdapter.Factory adapterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
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

    @Provides
    @UsersScope
    CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @UsersScope
    Converter.Factory provideConverterFactory() {
        return JacksonConverterFactory.create();
    }

}
