package bodya.popov.ru.hubble.users.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import bodya.popov.ru.hubble.R;
import bodya.popov.ru.hubble.users.presentation.ActionNavigator;
import bodya.popov.ru.hubble.users.presentation.view.BaseView;
import bodya.popov.ru.hubble.users.presentation.view.ToolbarDelegate;

/**
 * @author Popov Bogdan
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    private ToolbarDelegate mToolbarDelegate;
    private ActionNavigator mActionNavigator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            this.mActionNavigator = (ActionNavigator) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement ActionNavigator");
        }

        try {
            this.mToolbarDelegate = (ToolbarDelegate) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement ToolbarDelegate");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mToolbarDelegate = null;
        mActionNavigator = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar(view);
        initViews(view);
    }

    @Override
    public void showLoadingIndicator(boolean loading) {
        ProgressBar loadingIndicator = null;
        View view = getView();
        if (view != null) {
            loadingIndicator = getView().findViewById(R.id.progress_bar);
        }
        if (loadingIndicator != null) {
            loadingIndicator.setVisibility(loading ? View.VISIBLE : View.GONE);
        }
    }

    protected ToolbarDelegate getToolbarDelegate() {
        return mToolbarDelegate;
    }

    protected ActionNavigator getNavigator() {
        return mActionNavigator;
    }

    protected abstract String getToolbarTitle();

    protected abstract void initViews(View parent);

    private void initToolbar(View fragmentView) {
        if (mToolbarDelegate == null) {
            return;
        }

        Toolbar toolbar = fragmentView.findViewById(R.id.toolbar);
        toolbar.setTitle(getToolbarTitle());

        mToolbarDelegate.setToolbar(toolbar);
        mToolbarDelegate.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionNavigator.goBack();
            }
        });
    }

}
