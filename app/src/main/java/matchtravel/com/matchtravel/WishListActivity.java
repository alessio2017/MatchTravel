package matchtravel.com.matchtravel;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import java.util.ArrayList;

import fragments.HomeFragment;
import fragments.ProfileOwnFragment;
import fragments.SearchFragment;
import fragments.SurveyFragment;


public class WishListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wishlist_activity);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationbar_for_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment()); //carica di default il fragment della home
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragments, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){

            case R.id.home_fragment_button:
                fragment = new HomeFragment();
                 break;
            case R.id.search_destinations_fragment_button:
                fragment = new SearchFragment();
                break;
            case R.id.survey_fragment_button:
                fragment = new SurveyFragment();
                break;
            case R.id.profile_own_fragment_button:
                fragment = new ProfileOwnFragment();
                break;


        }

        return loadFragment(fragment);
    }
}