package matchtravel.com.matchtravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import datadb.City;
import datadb.User;
import objectBoxUtility.CityManager;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;

public class CityProfileActivity extends AppCompatActivity {

    private TextView name_city;
    private ImageView image_city;
    private TextView description_city;
    private Switch switchBtn;
    private User currentUser;
    private City city;

    /*questi valori booleani servono per gestire meglio il pulsante di switch*/
    private boolean initialState = false;
    private boolean actualState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_profile);

        name_city = findViewById(R.id.lbl_city_name);
        image_city = findViewById(R.id.img_city);
        description_city = findViewById(R.id.lbl_description_of_city);
        description_city.setMovementMethod(new ScrollingMovementMethod());
        switchBtn = findViewById(R.id.switch_to_add_favourites);
        ImageView button_comeback_activity = findViewById(R.id.btn_back_activity);

        final CityManager cityManager = new CityManager(ObjectBox.get());
        String nameCity = getIntent().getStringExtra("city_name");
        city = cityManager.getCity(nameCity);

        //richiama il metodo per poter settare i dettagli della città
        editDetailsMethod(city);

        //al click della freccia torna all'activity indietro
        button_comeback_activity.setOnClickListener(new View.OnClickListener() {
            /*l'aggiornamento della lista dei favoriti viene fatto qui perché altrimenti se l'utente iniziasse
             * a fare "attiva"/"disattiva" con il pulsante di switch si creerebbero delle transizioni complicate
             * a livello di database. In questo modo, consideriamo solo il risultato finale, ovvero quello che
             * rimane una volta che l'utente esce dall'acitivity.*/
            @Override
            public void onClick(View v) {
                /*Since bug problem, the update is done by the WishListActivity*/
                Intent intent = new Intent();
                if(actualState!=initialState){
                    intent.putExtra("CityPreferenceModified", true);
                    /*we have to remove or to add the city among the favourites of the user*/
                    if(currentUser.getDestinations().contains(city)){
                        /*notify to remove city*/
                        intent.putExtra("RemoveCity", city.getName());
                    }else{
                        /*notify to add city*/
                        intent.putExtra("AddCity", city.getName());
                    }
                }
                setResult(RESULT_OK, intent);
                finish();
                onBackPressed();
            }
        });

        boolean fromResult = getIntent().getBooleanExtra("fromResult", false);
        if(!fromResult){
            //verifica che la città sia presente o meno nella lista dell'utente
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.sharedPref_file), MODE_PRIVATE);
            int currentUserId = sharedPreferences.getInt(getString(R.string.sharedPref_current_user), 0);
            UserManager userManager = new UserManager(ObjectBox.get());
            switch (currentUserId){
                case 0:
                    currentUser = userManager.getRealUser("Daniele");
                    break;
                case 1:
                    currentUser = userManager.getRealUser("Alessio");
                    break;
                default:
                    currentUser = userManager.getRealUser("Umberto");
                    break;
            }

            boolean cityIsAmongFavourite = currentUser.getDestinations().contains(city);
            if(cityIsAmongFavourite){
                /*the switch button must be triggered*/
                switchBtn.toggle();
                initialState = true;
                actualState = true;
            }

            switchBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actualState = !actualState;
                }
            });
        }else{
            switchBtn.setVisibility(View.GONE);
        }

    }

    //questo metodo setta il nome, la descrizione e l'immagine della città
    private void editDetailsMethod(City city) {
        name_city.setText(city.getName());
        description_city.setText(city.getDescription());
        image_city.setImageDrawable(getCityImage(city));
    }

    //questo metodo prende l'img della città che viene cliccata
    private Drawable getCityImage(City city) {
        //parsing the right string: cityname_pic
        String resourceName = city.getName().toLowerCase().replace(" ", "").concat("_pic_profile");
        Log.i("RESULT_SURVEY", "Looking for: " + resourceName);
        //getting the id of the resource "cityname_pic.png"
        int resourceId = this.getResources().getIdentifier(resourceName, "drawable", this.getPackageName());
        //getting the real image
        return this.getDrawable(resourceId);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        if(actualState!=initialState){
            intent.putExtra("CityPreferenceModified", true);
            /*we have to remove or to add the city among the favourites of the user*/
            if(currentUser.getDestinations().contains(city)){
                /*notify to remove city*/
                intent.putExtra("RemoveCity", city.getName());
            }else{
                /*notify to add city*/
                intent.putExtra("AddCity", city.getName());
            }
        }
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
