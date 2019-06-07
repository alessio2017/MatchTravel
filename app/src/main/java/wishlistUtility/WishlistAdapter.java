package wishlistUtility;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import datadb.City;
import datadb.User;
import matchtravel.com.matchtravel.R;

public class WishlistAdapter extends RecyclerView.Adapter {

    private List<City> cities;
    private SparseArray<List<User>> userPerCity;
    private Fragment parent;

    public WishlistAdapter(){}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_cell, parent, false);
        return new WishlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //getting image of the city
        String resourceName = cities.get(i).getName().toLowerCase().replace(" ","").concat("_pic_icon");
        Log.i("RESULT_SURVEY", "Looking for: " + resourceName);
        //getting the id of the resource "cityname_pic_icon.png"
        int resourceId =  parent.getResources().getIdentifier(resourceName, "drawable", parent.getActivity().getPackageName());
        //getting the real image
        Drawable image = parent.getActivity().getDrawable(resourceId);

        ((WishlistViewHolder) viewHolder).setOnPlusButtonClickedListener((WishlistViewHolder.OnWhishListCellClickListener) parent);
        ((WishlistViewHolder) viewHolder).bindData(cities.get(i), userPerCity.get(i), image);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public void setCities(List<City> wishedCities){
        this.cities = new ArrayList<>();
        cities.addAll(wishedCities);
    }

    public void setUserPerCity(Map<City, List<User>> usersListPerCity){
        this.userPerCity = new SparseArray<>();

        //supposing that the list of cities is always initialize before the list of user!
        for(int i = 0; i<cities.size(); i++){
            City c = cities.get(i);
            List<User> users = usersListPerCity.get(c);
            userPerCity.append(i, users);
        }
    }

    public void setParent(Fragment parent){
        this.parent = parent;
    }
}

