package wishlistUtility;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import datadb.City;
import datadb.User;
import matchtravel.com.matchtravel.R;

public class WishlistViewHolder extends RecyclerView.ViewHolder {

    private TextView cityName;
    private TextView user1Name;
    private TextView user2Name;
    private TextView user3Name;
    private ImageView cityImage;
    private ImageView user1Image;
    private ImageView user2Image;
    private ImageView user3Image;
    private ImageView contactUser1;
    private ImageView contactUser2;
    private ImageView contactUser3;
    private ImageView favouriteBtn;

    public WishlistViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cityName = itemView.findViewById(R.id.cityName);
        this.user1Name = itemView.findViewById(R.id.userName1);
        this.user2Name = itemView.findViewById(R.id.userName2);
        this.user3Name = itemView.findViewById(R.id.userName3);
        //image view
        this.cityImage = itemView.findViewById(R.id.imageCity);
        this.user1Image = itemView.findViewById(R.id.imageUser1);
        this.user2Image = itemView.findViewById(R.id.imageUser2);
        this.user3Image = itemView.findViewById(R.id.imageUser3);
        //contact button
        this.contactUser1 = itemView.findViewById(R.id.buttonGoToProfile1);
        this.contactUser2 = itemView.findViewById(R.id.buttonGoToProfile2);
        this.contactUser3 = itemView.findViewById(R.id.buttonGoToProfile3);
        //star button
        this.favouriteBtn = itemView.findViewById(R.id.buttonStar);
    }

    public void bindData(final City city, final List<User> users){
        cityName.setText(city.getName());
        //TODO: set city image
        //TODO: set button star

        String userName = "";

        if(users.size()>0){
            userName = users.get(0).getName() + "\n" + users.get(0).getSurname();
            user1Name.setText(userName);
            //TODO: set user image
            if(users.size()>1){
                userName = users.get(1).getName() + "\n" + users.get(1).getSurname();
                user2Name.setText(userName);
                //TODO: set user image
                if(users.size()>2){
                    userName = users.get(2).getName() + "\n" + users.get(2).getSurname();
                    user3Name.setText(userName);
                    //TODO: set user image
                }
                else{
                    //hiding image and button
                    user3Name.setVisibility(View.GONE);
                    user3Image.setVisibility(View.GONE);
                    contactUser3.setVisibility(View.GONE);
                }
            }
            else{
                //hiding image and button
                user2Name.setVisibility(View.GONE);
                user3Name.setVisibility(View.GONE);
                user2Image.setVisibility(View.GONE);
                user3Image.setVisibility(View.GONE);
                contactUser2.setVisibility(View.GONE);
                contactUser3.setVisibility(View.GONE);
            }
        }
        else{
            //hiding image and button
            user1Name.setVisibility(View.GONE);
            user2Name.setVisibility(View.GONE);
            user3Name.setVisibility(View.GONE);
            user1Image.setVisibility(View.GONE);
            user2Image.setVisibility(View.GONE);
            user3Image.setVisibility(View.GONE);
            contactUser1.setVisibility(View.GONE);
            contactUser2.setVisibility(View.GONE);
            contactUser3.setVisibility(View.GONE);
        }

        this.favouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: rimuovere la città tra le preferite dell'utente, deve uscire un popup del tipo: "sei sicuro di..."
            }
        });
    }
}
