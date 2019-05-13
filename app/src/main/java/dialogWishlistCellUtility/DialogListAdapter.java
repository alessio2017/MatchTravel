package dialogWishlistCellUtility;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import datadb.User;
import matchtravel.com.matchtravel.R;

public class DialogListAdapter extends RecyclerView.Adapter {

    private List<User> moreUser;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_user_row, parent, false);
        return new DialogListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //TODO: get image resource
        ((DialogListViewHolder) viewHolder).bindData(moreUser.get(i),null);
    }

    @Override
    public int getItemCount() {
        return moreUser.size();
    }

    public void setMoreUser(List<User> users){
        this.moreUser = users;
    }
}
