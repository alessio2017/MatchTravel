package dialogWishlistCellUtility;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import datadb.User;
import de.hdodenhof.circleimageview.CircleImageView;
import matchtravel.com.matchtravel.ProfileNotOwn;
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

    public void bindData(final User user, Drawable image, final Context context){
        if(image!=null)
            this.imageUser.setImageDrawable(image);
        else
            Log.e("DIALOG USER", "Image for user " +user.getSurname() + " not found.");
        String name = user.getName() + "\n" + user.getSurname();
        this.nameUser.setText(name);
        this.nameUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileNotOwn.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("surname", user.getSurname());
                context.startActivity(intent);
            }
        });
        this.contactUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileNotOwn.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("surname", user.getSurname());
                context.startActivity(intent);
            }
        });
    }
}
