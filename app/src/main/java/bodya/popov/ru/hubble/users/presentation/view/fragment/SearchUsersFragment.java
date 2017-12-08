package bodya.popov.ru.hubble.users.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bodya.popov.ru.hubble.R;
import bodya.popov.ru.hubble.users.di.UsersSubComponent;
import bodya.popov.ru.hubble.users.domain.model.User;
import bodya.popov.ru.hubble.users.presentation.presenter.UserListPresenter;
import bodya.popov.ru.hubble.users.presentation.view.ComponentKeeper;
import bodya.popov.ru.hubble.users.presentation.view.SearchUsersView;
import bodya.popov.ru.hubble.users.presentation.view.adapter.UserListAdapter;

/**
 * @author Popov Bogdan
 */

public class SearchUsersFragment extends BaseFragment implements SearchUsersView {

    public static final String TAG = "SearchUsersFragment";

    private EditText mEditText;
    private ProgressBar mProgressBar;
    private TextView mNoUsersFoundTextView;
    private RecyclerView mRecyclerView;
    private Button mSearchButton;

    private UserListAdapter mUserListAdapter;

    @Inject
    UserListPresenter mListPresenter;

    public static SearchUsersFragment newInstance() {
        return new SearchUsersFragment();
    }

    // fragment lifecycle start
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        FragmentActivity activity = getActivity();
        if (activity != null) {
            //noinspection unchecked
            ((ComponentKeeper<UsersSubComponent>) activity).getScopeComponent().inject(this);
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getToolbarDelegate().showHomeButton(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        mListPresenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mListPresenter.attachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mListPresenter.detachView();
    }

    @Override
    public void onStop() {
        super.onStop();
        mListPresenter.detachView();
    }
    // fragment lifecycle end

    // BaseFragment start
    @Override
    protected String getToolbarTitle() {
        return getResources().getString(R.string.search);
    }
    // end


    // SearchUsersView start
    @Override
    public void showUsers(List<User> userList) {
        mUserListAdapter.setData(userList);
    }

    @Override
    public void showNoFoundUsers(boolean show) {

    }
    // end

    @Override
    protected void initViews(View parent) {
        mSearchButton = parent.findViewById(R.id.search_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListPresenter.onSearchBtnClicked();
            }
        });
        mEditText = parent.findViewById(R.id.search_edit_text);
        mProgressBar = parent.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);

        mNoUsersFoundTextView = parent.findViewById(R.id.no_users_found_view);
        mNoUsersFoundTextView.setVisibility(View.GONE);

        mRecyclerView = parent.findViewById(R.id.users_list_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        mUserListAdapter = new UserListAdapter(new ArrayList<User>());
        mRecyclerView.setAdapter(mUserListAdapter);
    }

}
