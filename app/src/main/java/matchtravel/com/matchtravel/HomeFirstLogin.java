package matchtravel.com.matchtravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/* Questa classe gestisce il primo login dell'utente (nel nostro caso l'user test), che permette la
* visualizzazione dei dati personali che in teoria prende dai social ma in questo esempio prende dal
* database locale in objectBoxUtility.ObjectBox e permette l'inserimento di una descrizione personale */
public class HomeFirstLogin extends AppCompatActivity {

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
                /* qui va gestito l'intent che porta all'activity del questionario ed inoltre va
                * aggiornata la descrizione che l'utente inserisce nel DB. Nota: se l'utente preme il
                * bottone senza inserire nulla di default viene inserito: " Just joined this
                * application! write me " , questo per chi ha Android API 26+ */
                Intent goToSurvey = new Intent(HomeFirstLogin.this, SurveyActivity.class);
                startActivity(goToSurvey);
            }
        });

    }
}
