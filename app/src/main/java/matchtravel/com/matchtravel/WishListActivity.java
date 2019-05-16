package matchtravel.com.matchtravel;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import datadb.City;
import datadb.User;
import fragments.Question;
import fragments.HomeFragment;
import fragments.ProfileOwnFragment;
import fragments.SearchFragment;
import objectBoxUtility.CityManager;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;


public class WishListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ProfileOwnFragment.OnChangeCurrentUserListener {

    private BottomNavigationView bottomNavigationView;
    private UserManager userManager;
    private User currentUser;
    private Fragment currentFragment;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wishlist);

        this.userManager = new UserManager(ObjectBox.get());

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationbar_for_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setItemIconTintList(null);

        loadFragment(new HomeFragment()); //carica di default il fragment della home

        /*Retrieve dell'utente effettivo, uno tra Daniele, Umberto ed Alessio*/
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.sharedPref_file), MODE_PRIVATE);
        int user = sharedPreferences.getInt(getString(R.string.sharedPref_current_user), 0);
        /*se "user" = 0, allora Daniele, se 1 allora Alessio, se 2 allora Umberto*/
        if(user == 0)
            this.currentUser = userManager.getRealUser("Daniele");
        else if (user == 1)
            this.currentUser = userManager.getRealUser("Alessio");
        else
            this.currentUser = userManager.getRealUser("Umberto");

        /*Sarà il fragment che deve far visualizzare la lista di città dell'utente.*/
        ((HomeFragment) this.currentFragment).setCurrentUser(currentUser);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragments, fragment)
                    .commit();

            this.currentFragment = fragment;
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
                ((HomeFragment) fragment).setCurrentUser(currentUser);
                break;
            case R.id.search_destinations_fragment_button:
                fragment = new SearchFragment();
                break;
            case R.id.survey_fragment_button:
                fragment = new Question();
                break;
            case R.id.profile_own_fragment_button:
                fragment = new ProfileOwnFragment();
                ((ProfileOwnFragment) fragment).setCurrentUser(currentUser);
                break;


        }

        return loadFragment(fragment);
    }

    /*metodo derivante dall'interfaccia OnChangeCurrentUser*/
    @Override
    public void onUserSelected(User user) {
        this.currentUser = user;
    }

    /*metodo derivante dall'interfaccia OnChangeCurrentUser*/
    @Override
    public void onAttachFragment(Fragment fragment){
        if(fragment instanceof ProfileOwnFragment){
            ProfileOwnFragment profileOwnFragment = (ProfileOwnFragment) fragment;
            profileOwnFragment.setOnChangeCurrentUserListener(this);
        }
    }

    /*Chiamato quando ritorna dall'activity CityProfileActivity*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
            if(resultCode == RESULT_OK){
                if(data.getBooleanExtra("CityPreferenceModified", false)){
                    /*something has been modified*/
                    String toRemove = data.getStringExtra("RemoveCity");
                    String toAdd = data.getStringExtra("AddCity");

                    if(toRemove!=null){
                        /*removing city from user list*/
                        City city = new CityManager(ObjectBox.get()).getCity(toRemove);
                        this.currentUser = userManager.removeDestination(currentUser, city);
                    }else{
                        /*adding city from user list*/
                        City city = new CityManager(ObjectBox.get()).getCity(toAdd);
                        this.currentUser = userManager.addDestination(currentUser, city);
                    }

                    try{
                        ((HomeFragment)this.currentFragment).setCurrentUser(currentUser);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

    }
}