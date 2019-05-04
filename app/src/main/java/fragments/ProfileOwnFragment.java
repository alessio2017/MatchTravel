package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.annotation.Nullable;

import datadb.User;
import matchtravel.com.matchtravel.R;
import matchtravel.com.matchtravel.SurveyActivity;

public class ProfileOwnFragment extends Fragment {
    private Button facebook;
    private Button mail;
    private Button instagram;
    //private Button home_own;
    //private Button search_own;
    //private Button survey_own;

    private TextView edit_own;
    private TextView terms;
    private TextView privacy_own;

    private TextView ageown;
    private TextView stateown;
    private TextView nationown;

    private TextView description;

    private User currentUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_own, container, false);

        facebook = (Button) view.findViewById(R.id.facebook);
        mail = (Button) view.findViewById(R.id.mail);
        instagram = (Button) view.findViewById(R.id.instagram);

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

            }
        });

        return view;
    }

    public void setCurrentUser(User user){
        if(user!=null)
            this.currentUser = user;
        //TODO: update delle varie view
    }
}
