package fragments;

import android.os.Bundle;
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
import matchtravel.com.matchtravel.R;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;
import wishlistUtility.WishlistAdapter;

public class HomeFragment extends Fragment {

    private User currentUser;
    private View layout;
    private WishlistAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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

        //giving to the adapter the list of city of the current user
        recyclerViewAdapter.setCities(currentUser.destinations);

        //list of user per city (of the current user)
        Map<City, List<User>> cityUserMap = new HashMap<>();
        UserManager userManager = new UserManager(ObjectBox.get());
        for(City c : currentUser.destinations){
            //building map
            List<User> usersWithTheSameDestination = userManager.getUsersForCity(c);
            cityUserMap.put(c, usersWithTheSameDestination);
        }
        recyclerViewAdapter.setUserPerCity(cityUserMap);
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
    }
}
