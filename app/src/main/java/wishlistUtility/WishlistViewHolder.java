package wishlistUtility;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import datadb.City;
import datadb.User;
import de.hdodenhof.circleimageview.CircleImageView;
import matchtravel.com.matchtravel.ProfileNotOwn;
import matchtravel.com.matchtravel.R;

public class WishlistViewHolder extends RecyclerView.ViewHolder {

    private TextView cityName;
    private TextView user1Name;
    private TextView user2Name;
    private TextView user3Name;
    private ImageView cityImage;
    private CircleImageView user1Image;
    private CircleImageView user2Image;
    private CircleImageView user3Image;
    private ImageView contactUser1;
    private ImageView contactUser2;
    private ImageView contactUser3;
    private ImageView favouriteBtn;
    private ImageButton plusBtn;
    private View invisiblePlusBtn;

    private OnWhishListCellClickListener listener;

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
        //plus button
        this.plusBtn = itemView.findViewById(R.id.icon_plus);
        this.invisiblePlusBtn = itemView.findViewById(R.id.dialogInvisibleButton);
    }

    public void bindData(final City city, final List<User> users, Drawable image, Drawable[] userImages){
        cityName.setText(city.getName());
        cityImage.setImageDrawable(image);

        String userName = "";
        final Intent intentGoToUserProfile = new Intent(((Fragment) listener).getContext(), ProfileNotOwn.class);

        if(users.size()>0){
            userName = users.get(0).getName() + "\n" + users.get(0).getSurname();
            user1Name.setText(userName);
            user1Name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentGoToUserProfile.putExtra("name", users.get(0).getName());
                    intentGoToUserProfile.putExtra("surname",users.get(0).getSurname());
                    ((Fragment) listener).startActivity(intentGoToUserProfile);
                }
            });
            user1Image.setImageDrawable(userImages[0]);

            this.contactUser1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentGoToUserProfile.putExtra("name", users.get(0).getName());
                    intentGoToUserProfile.putExtra("surname",users.get(0).getSurname());
                    ((Fragment) listener).startActivity(intentGoToUserProfile);
                }
            });

            if(users.size()>1){
                userName = users.get(1).getName() + "\n" + users.get(1).getSurname();
                user2Name.setText(userName);
                user2Name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intentGoToUserProfile.putExtra("name", users.get(1).getName());
                        intentGoToUserProfile.putExtra("surname",users.get(1).getSurname());
                        ((Fragment) listener).startActivity(intentGoToUserProfile);
                    }
                });
                user2Image.setImageDrawable(userImages[1]);

                this.contactUser2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intentGoToUserProfile.putExtra("name", users.get(1).getName());
                        intentGoToUserProfile.putExtra("surname",users.get(1).getSurname());
                        ((Fragment) listener).startActivity(intentGoToUserProfile);
                    }
                });
                if(users.size()>2){
                    userName = users.get(2).getName() + "\n" + users.get(2).getSurname();
                    user3Name.setText(userName);
                    user3Name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            intentGoToUserProfile.putExtra("name", users.get(2).getName());
                            intentGoToUserProfile.putExtra("surname",users.get(2).getSurname());
                            ((Fragment) listener).startActivity(intentGoToUserProfile);
                        }
                    });
                    user3Image.setImageDrawable(userImages[2]);

                    this.contactUser3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            intentGoToUserProfile.putExtra("name", users.get(2).getName());
                            intentGoToUserProfile.putExtra("surname",users.get(2).getSurname());
                            ((Fragment) listener).startActivity(intentGoToUserProfile);
                        }
                    });
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
                listener.onStartButtonClicked(city);
            }
        });

        if(users.size()<=3){
            this.plusBtn.setVisibility(View.GONE);
            this.invisiblePlusBtn.setVisibility(View.GONE);
        }else {
            this.plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlusButtonClicked(users);
                }
            });
            this.invisiblePlusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlusButtonClicked(users);
                }
            });
        }

        this.cityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCityClicked(city);
            }
        });

        this.cityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCityClicked(city);
            }
        });
    }

    /*interfaccia per comunicare al fragment "HomeFragment" che è stato cliccato il pulsante "+"*/
    public interface OnWhishListCellClickListener {
        void onPlusButtonClicked(List<User> users);
        void onCityClicked(City city);
        void onStartButtonClicked(City city);
    }

    public void setOnPlusButtonClickedListener(OnWhishListCellClickListener listener){
        this.listener = listener;
    }
}
