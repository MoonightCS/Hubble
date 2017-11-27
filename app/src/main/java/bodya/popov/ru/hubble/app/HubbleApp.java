package bodya.popov.ru.hubble.app;

import android.app.Application;

import bodya.popov.ru.hubble.app.di.AppComponent;
import bodya.popov.ru.hubble.app.di.DaggerAppComponent;
import bodya.popov.ru.hubble.app.di.IHasComponent;

/**
 * @author Popov Bogdan
 */

public class HubbleApp extends Application implements IHasComponent<AppComponent> {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().build();
    }

    @Override
    public AppComponent getComponent() {
        return mAppComponent;
    }
}
