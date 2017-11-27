package bodya.popov.ru.hubble.users.presentation.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import bodya.popov.ru.hubble.R;
import bodya.popov.ru.hubble.users.di.UsersSubComponent;
import bodya.popov.ru.hubble.users.presentation.ActionNavigator;
import bodya.popov.ru.hubble.users.presentation.view.ComponentKeeper;
import bodya.popov.ru.hubble.users.presentation.view.ToolbarDelegate;
import bodya.popov.ru.hubble.users.presentation.view.fragment.SearchUsersFragment;
import bodya.popov.ru.hubble.users.presentation.view.fragment.UsersRetainFragment;

public class UserListActivity extends AppCompatActivity implements ToolbarDelegate, ActionNavigator, ComponentKeeper<UsersSubComponent> {

    private static final String TAG_RETAINED_FRAGMENT = "RetainedFragment";

    private UsersRetainFragment mUsersRetainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.host_root_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mUsersRetainFragment = (UsersRetainFragment) fragmentManager.findFragmentByTag(TAG_RETAINED_FRAGMENT);
        if (mUsersRetainFragment == null) {
            mUsersRetainFragment = new UsersRetainFragment();
            fragmentManager.beginTransaction().add(mUsersRetainFragment, TAG_RETAINED_FRAGMENT).commit();
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.host_root_linear_layout,
                            SearchUsersFragment.newInstance(),
                            SearchUsersFragment.TAG)
                    .commit();
        }

    }

    // ToolbarDelegate section start
    @Override
    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }

    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }

    @Override
    public void showHomeButton(boolean show) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(show);
            actionBar.setDisplayHomeAsUpEnabled(show);
            actionBar.setHomeButtonEnabled(show);
        }
    }
    // end

    // ActionNavigator section start
    @Override
    public void gotoCountManager() {

    }

    @Override
    public void goBack() {
        this.onBackPressed();
    }
    // end

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.host_root_linear_layout, fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public UsersSubComponent getScopeComponent() {
        UsersSubComponent component = null;
        if (mUsersRetainFragment != null) {
            component = mUsersRetainFragment.getSubComponent();
        }
        return component;
    }
}
