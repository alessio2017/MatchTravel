package matchtravel.com.matchtravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


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

        btnFacebook = (ImageView) findViewById(R.id.facebook_btn);
        btnGoogle = (ImageView) findViewById(R.id.google_btn);
        loadingBar = (ProgressBar) findViewById(R.id.progressBar);


        loadingBar.setVisibility(View.INVISIBLE); //anche se di default sull xml era gia su invisible


        /* Metodo che al click del bottone gestisce il login e le splash screen. Nota bene: nel db ci
        dev'essere un valore in grado di poterci dire se l'utente test ha gia compilato il questionario
        o meno.  */

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingBar.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "You are loggin with facebook, please wait..", Toast.LENGTH_LONG).show();
                //loginMethod()
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingBar.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "You are loggin with google, please wait..", Toast.LENGTH_LONG).show();
                //loginMethod()
            }
        });

    }


    /*
    loginMethod(){
        if (maifattoquestionario) vai all'activity del questionario
            else vai all'activity della wishlist (homepage)
    }
    */





}


