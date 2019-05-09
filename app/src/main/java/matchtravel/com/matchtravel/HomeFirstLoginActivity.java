package matchtravel.com.matchtravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import datadb.User;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;

/* Questa classe gestisce il primo login dell'utente (nel nostro caso l'user test), che permette la
* visualizzazione dei dati personali che in teoria prende dai social ma in questo esempio prende dal
* database locale in objectBoxUtility.ObjectBox e permette l'inserimento di una descrizione personale */
public class HomeFirstLoginActivity extends AppCompatActivity {

    private ProgressBar loadingBar;
    private EditText txt_description_user;
    private ImageView btn_find_destinations;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homefirstlogin);

        loadingBar = (ProgressBar) findViewById(R.id.progressBar);
        txt_description_user = (EditText) findViewById(R.id.txt_description_user);
        btn_find_destinations = (ImageView) findViewById(R.id.btn_find_destinations);

        /* questo metodo permette all'utente di andare a fare il questionario al click del bottone */
        btn_find_destinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*NOTA BENE: in questo modo, dato che è il primo login, si andrà sempre a modificare
                * la descrizione dell'utente Daniele...*/
                //retrieve current user
                User currentUser;
                UserManager userManager = new UserManager(ObjectBox.get());

                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.sharedPref_file), MODE_PRIVATE);
                int user = sharedPreferences.getInt(getString(R.string.sharedPref_current_user), 0);
                /*se "user" = 0, allora Daniele, se 1 allora Alessio, se 2 allora Umberto*/
                if(user == 0)
                    currentUser = userManager.getRealUser("Daniele");
                else if (user == 1)
                    currentUser = userManager.getRealUser("Alessio");
                else
                    currentUser = userManager.getRealUser("Umberto");
                //changing description
                String newDesc = txt_description_user.getText().toString();
                userManager.changeDescription(currentUser, newDesc);

                //going to the first survey
                Intent goToSurvey = new Intent(HomeFirstLoginActivity.this, SurveyActivity.class);
                startActivity(goToSurvey);
            }
        });

    }
}
