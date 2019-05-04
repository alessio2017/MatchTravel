package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;

import datadb.User;
import matchtravel.com.matchtravel.R;

public class HomeFragment extends Fragment {

    private User currentUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
        //TODO: caricare lista delle città dell'utente corrente
    }

    public void setCurrentUser(User user){
        if(user!=null)
            this.currentUser = user;
        //TODO: update list of cities
    }
}
