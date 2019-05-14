package dialogWishlistCellUtility;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import datadb.User;
import de.hdodenhof.circleimageview.CircleImageView;
import matchtravel.com.matchtravel.R;

public class DialogListViewHolder extends RecyclerView.ViewHolder {

    private CircleImageView imageUser;
    private TextView nameUser;
    private ImageView contactUserBtn;

    public DialogListViewHolder(@NonNull View itemView) {
        super(itemView);

        this.imageUser = itemView.findViewById(R.id.imageUserMoreUserList);
        this.nameUser = itemView.findViewById(R.id.userNameMoreUserList);
        this.contactUserBtn = itemView.findViewById(R.id.buttonGoToProfileMoreUserList);
    }

    public void bindData(User user, Drawable image){
        if(image!=null)
            this.imageUser.setImageDrawable(image);
        String name = user.getName() + "\n" + user.getSurname();
        this.nameUser.setText(name);
        this.contactUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: go to personal profile of user
            }
        });
    }
}
