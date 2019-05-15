package dialogWishlistCellUtility;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.util.List;

import datadb.User;
import matchtravel.com.matchtravel.R;

public class MoreUserDialog extends Dialog{

    private Context context;
    private List<User> users;
    private RecyclerView recyclerView;

    public MoreUserDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.dialog_more_user_wishlist);
        recyclerView = findViewById(R.id.more_user_recycler_view);
        updateView();
    }

    public void setUsers(List<User> users){
        this.users = users;
        updateView();
    }

    private void updateView(){
        //init recycler view
        if(recyclerView==null)
            recyclerView = findViewById(R.id.more_user_recycler_view);
        if(recyclerView!=null){
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            DialogListAdapter adapter = new DialogListAdapter();
            adapter.setMoreUser(users);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}
