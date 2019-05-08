package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import javax.annotation.Nullable;

import datadb.User;
import matchtravel.com.matchtravel.R;
import matchtravel.com.matchtravel.SurveyActivity;
import matchtravel.com.matchtravel.WishListActivity;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;

public class ProfileOwnFragment extends Fragment {
    private ImageView facebook;
    private ImageView mail;
    private ImageView instagram;

    private TextView edit_own;
    private TextView terms;
    private TextView privacy_own;

    private TextView ageown;
    private TextView stateown;
    private TextView nationown;


    private User currentUser;
    private UserManager userManager;
    private Context context;

    OnChangeCurrentUserListener callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_own, container, false);

        this.userManager = new UserManager(ObjectBox.get());
        this.context = getContext();

        facebook = (ImageView) view.findViewById(R.id.facebook);
        mail = (ImageView) view.findViewById(R.id.mail);
        instagram = (ImageView) view.findViewById(R.id.instagram);

        //home_own = (Button) view.findViewById(R.id.home_own);
        //search_own = (Button) view.findViewById(R.id.search_own);
        //survey_own = (Button) view.findViewById(R.id.survey_own);

        edit_own = (TextView) view.findViewById(R.id.edit_own);
        terms = (TextView) view.findViewById(R.id.terms);
        privacy_own = (TextView) view.findViewById(R.id.privacy_own);

        ageown = (TextView) view.findViewById(R.id.ageown);
        stateown = (TextView) view.findViewById(R.id.stateown);
        nationown = (TextView) view.findViewById(R.id.nationown);

        //settare info dell'utente che mostreremo loggato alla prof.
        ageown.setText("29 yo");
        stateown.setText("Single");
        nationown.setText("from"+"Uk");

        //settare descrizione dell'utente finale
        //description.setText("Hi! I do not speak much in front of people…\n" +
              //  "I'm not shy, i just do not talk, although most people say I am one of the most funny people on the planet and also that i remember them a famous spy:Mr. English. Never hear of...\n" +
               // "\"");

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        /*home_own.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });*/

        /*search_own.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });*/

        /*survey_own.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goToSurvey = new Intent(getActivity(), SurveyActivity.class);
                startActivity(goToSurvey);
            }

        });*/

        edit_own.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO: ora è possibile cambiare immagine e descrizione (o solo descrizione?)
            }
        });

        privacy_own.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //creating and inflating popup menu to change current user
                PopupMenu popup = new PopupMenu(getContext(), privacy_own);
                popup.getMenuInflater().inflate(R.menu.popup_current_user, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //retrieve desidered user
                        User user = userManager.getRealUser("" + item.getTitle());
                        //retrieve shared preference
                        SharedPreferences sharedPreferences = context.
                                getSharedPreferences(getString(R.string.sharedPref_file),
                                        Context.MODE_PRIVATE);
                        //retrieve current user
                        int currentUserId = sharedPreferences.getInt(
                                getString(R.string.sharedPref_current_user),
                                0);
                        //update current user
                        int newId;
                        if(user.getName().equals("Daniele"))
                            newId = 0;
                        else if(user.getName().equals("Alessio"))
                            newId = 1;
                        else
                            newId = 2;

                        if(newId != currentUserId){
                            //the activity now have the new current user
                            callback.onUserSelected(user);
                            setCurrentUser(user);
                            //the sharedPreferences are updated
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt(context.getString(R.string.sharedPref_current_user), newId);
                            editor.commit();

                            Log.i("CAMBIO PROFILO", "RIUSCITO");
                        }
                        else
                            Log.i("CAMBIO PROFILO", "NESSUN CAMBIO. PROFILO GIA' MEMORIZZATO");

                        return true;
                    }
                });

                popup.show();
            }
        });

        return view;
    }

    public void setCurrentUser(User user){
        if(user!=null)
            this.currentUser = user;
        //TODO: update delle varie view
    }

    /*interfaccia necessaria per comunicare all'activity del cambio di utente*/
    public interface OnChangeCurrentUserListener{
        void onUserSelected(User user);
    }
    /*metodo di utility dell'interfaccia*/
    public void setOnChangeCurrentUserListener(OnChangeCurrentUserListener listener){
        this.callback = listener;
    }
}
