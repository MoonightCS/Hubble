package bodya.popov.ru.hubble.users.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import bodya.popov.ru.hubble.app.di.AppComponent;
import bodya.popov.ru.hubble.app.di.IHasComponent;
import bodya.popov.ru.hubble.users.di.UsersSubComponent;

/**
 * @author Popov Bogdan
 */

public class UsersRetainFragment extends Fragment {

    private UsersSubComponent mSubComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
        setRetainInstance(true);
    }

    public UsersSubComponent getSubComponent() {
        return mSubComponent;
    }

    private void initComponent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            //noinspection unchecked
            mSubComponent = ((IHasComponent<AppComponent>) activity.getApplication())
                    .getComponent()
                    .usersSubComponentBuilder()
                    .build();
        }
    }
}
