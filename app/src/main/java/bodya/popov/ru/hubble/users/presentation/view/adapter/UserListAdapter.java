package bodya.popov.ru.hubble.users.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bodya.popov.ru.hubble.R;
import bodya.popov.ru.hubble.users.domain.model.User;

/**
 * @author Popov Bogdan
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private List<User> mUserList;

    public UserListAdapter(List<User> mUserBeanList) {
        this.mUserList = mUserBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = mUserList.get(position);
        holder.mLoginTextView.setText(user.getLogin());
        holder.mUrlTextView.setText(user.getUrl());
    }

    @Override
    public int getItemCount() {
        if (mUserList != null) {
            return mUserList.size();
        } else {
            return 0;
        }
    }

    public void setData(List<User> userList) {
        mUserList.clear();
        if (userList != null) {
            mUserList.addAll(userList);
        }
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mLoginTextView;
        private TextView mUrlTextView;

        ViewHolder(View itemView) {
            super(itemView);
            mLoginTextView = itemView.findViewById(R.id.login_text_view);
            mUrlTextView = itemView.findViewById(R.id.url_text_view);
        }
    }
}
