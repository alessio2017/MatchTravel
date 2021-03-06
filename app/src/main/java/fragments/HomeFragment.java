package fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import datadb.City;
import datadb.User;
import dialogWishlistCellUtility.MoreUserDialog;
import matchtravel.com.matchtravel.CityProfileActivity;
import matchtravel.com.matchtravel.R;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;
import wishlistUtility.WishlistAdapter;
import wishlistUtility.WishlistViewHolder;

public class HomeFragment extends Fragment implements WishlistViewHolder.OnWhishListCellClickListener {

    private User currentUser;
    private View layout;
    private WishlistAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.layout = inflater.inflate(R.layout.fragment_home, container, false);
        if(currentUser!=null)
            updateRecyclerView();
        return layout;
    }

    public void setCurrentUser(User user){
        if(user!=null){
            this.currentUser = user;
            if(layout!=null)
                updateRecyclerView();
        }
    }

    private void updateRecyclerView(){
        if(recyclerViewAdapter == null)
            recyclerViewAdapter = new WishlistAdapter();

        //giving to the adapter the activity pointer
        recyclerViewAdapter.setParent(this);

        //giving to the adapter the list of city of the current user
        recyclerViewAdapter.setCities(currentUser.destinations);

        //list of user per city (of the current user)
        Map<City, List<User>> cityUserMap = new HashMap<>();
        UserManager userManager = new UserManager(ObjectBox.get());
        for(City c : currentUser.destinations){
            //building map
            List<User> usersWithTheSameDestination = userManager.getUsersForCity(c);
            usersWithTheSameDestination.remove(currentUser);
            cityUserMap.put(c, usersWithTheSameDestination);
        }
        recyclerViewAdapter.setUserPerCity(cityUserMap);

        //initialize recyclerView
        RecyclerView recyclerView;
        try{
            recyclerView = layout.findViewById(R.id.wishlistRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(recyclerViewAdapter);
            Log.i("HOME_FRAGMENT", "RecyclerView inizializzata con successo");
        }catch (Exception e){
            e.printStackTrace();
            Log.i("HOME_FRAGMENT", "RecyclerView non inizializzata");
        }

        //notifying to the adapter that the set is changed
        recyclerViewAdapter.notifyDataSetChanged();

        if(currentUser.destinations.size() == 0){
            layout.findViewById(R.id.textViewHome).setVisibility(View.VISIBLE);
        }else{
            layout.findViewById(R.id.textViewHome).setVisibility(View.GONE);
        }
    }

    /*Open dialog window where the user see all the users that share a destination with him*/
    @Override
    public void onPlusButtonClicked(List<User> users) {
        Context context = layout.getContext();
        MoreUserDialog dialog = new MoreUserDialog(context);
        dialog.setUsers(users);
        dialog.show();
    }

    /*Open activity where city info are shown*/
    @Override
    public void onCityClicked(City city) {
        Intent intent = new Intent(this.getActivity(), CityProfileActivity.class);
        intent.putExtra("city_name", city.getName());
        intent.putExtra("fromResult", false);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onStartButtonClicked(final City city) {
        /*User has clicked the star button. May he want to delete this city?*/
        final AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setMessage("Are you sure you want to delete this city?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                currentUser = (new UserManager(ObjectBox.get())).removeDestination(currentUser, city);
                setCurrentUser(currentUser);
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }
}
