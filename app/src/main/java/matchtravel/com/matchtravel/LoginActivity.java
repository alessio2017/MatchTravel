package matchtravel.com.matchtravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import objectBoxUtility.AttractionManager;
import objectBoxUtility.CityManager;
import objectBoxUtility.KindManager;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;


/* Questa classe permette la gestione del login di un user test che verrà usato come riferimento
per mostrare le varie funzionalità dell'app*/
public class LoginActivity extends AppCompatActivity {

    //dichiarazione dei due bottoni fake che in realtà sono immagini
    private ImageView btnFacebook;
    private ImageView btnGoogle;
    private ProgressBar loadingBar;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login); //viene settata la view del Login

        btnFacebook = (ImageView) findViewById(R.id.btn_facebook_access);
        btnGoogle = (ImageView) findViewById(R.id.btn_google_access);
        loadingBar = (ProgressBar) findViewById(R.id.progressBar);

        loadingBar.setVisibility(View.INVISIBLE); //anche se di default sull xml era gia su invisible


        /* Metodo che al click del bottone gestisce il login e le splash screen. Nota bene: nel db ci
        dev'essere un valore in grado di poterci dire se l'utente test ha gia compilato il questionario
        o meno.  */

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingBar.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "Logged with facebook!", Toast.LENGTH_LONG).show();
                loginMethod();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingBar.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "Logged with google!", Toast.LENGTH_LONG).show();
                loginMethod();
            }
        });


        /*Il codice seguente inizializza il database. Non cambiare.*/
        ObjectBox.init(this);

        /*Inizializzazione del DB tramite SharedPreference*/
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.sharedPref_file), MODE_PRIVATE);
        boolean isInit = sharedPreferences.getBoolean(getString(R.string.sharedPref_db_init), false);
        if(!isInit){
            /* init db */
            AttractionManager attractionManager = new AttractionManager(ObjectBox.get());
            KindManager kindManager = new KindManager(ObjectBox.get());
            CityManager cityManager = new CityManager(ObjectBox.get());
            UserManager userManager = new UserManager(ObjectBox.get());

            /*Non cambiare l'ordine!*/
            attractionManager.init();
            Log.i("ObBox","Attraction manager completato");
            kindManager.init();
            Log.i("ObBox","Kind manager completato");
            cityManager.init();
            Log.i("ObBox","City manager completato");
            userManager.init();
            Log.i("ObBox","User manager completato");

            /*Salvate le modifiche sulle shared preference in modo da non ripetere l'inizializzazione*/
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(getString(R.string.sharedPref_db_init), true);
            editor.commit();
        }
    }



    public void loginMethod(){
        //se l'utente lo ha già fatto, non deve ripetere il primo questionario
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.sharedPref_file), MODE_PRIVATE);
        boolean firstLogin = sharedPreferences.getBoolean(getString(R.string.sharedPref_firstLogin), true);
        if(firstLogin){
            //changing shared pref. Now the user won't do again the first survey
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(getString(R.string.sharedPref_firstLogin), false);
            editor.commit();

            //going to the new activity
            Intent goToHomeFirstLogin = new Intent(LoginActivity.this, HomeFirstLoginActivity.class);
            startActivity(goToHomeFirstLogin);
        }
        else{
            Intent goToHome = new Intent(LoginActivity.this, WishListActivity.class);
            startActivity(goToHome);
        }
    }






}


