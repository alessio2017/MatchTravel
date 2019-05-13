package matchtravel.com.matchtravel;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import datadb.City;
import objectBoxUtility.CityManager;
import objectBoxUtility.ObjectBox;

public class CityProfileActivity extends AppCompatActivity {

    private TextView name_city;
    private ImageView image_city;
    private TextView description_city;
    private ImageView button_comeback_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_profile);

        name_city = findViewById(R.id.lbl_city_name);
        image_city = findViewById(R.id.img_city);
        description_city = findViewById(R.id.lbl_description_of_city);
        description_city.setMovementMethod(new ScrollingMovementMethod());
        button_comeback_activity = findViewById(R.id.btn_back_activity);

        CityManager cityManager = new CityManager(ObjectBox.get());
        String nameCity = getIntent().getStringExtra("city_name");
        City city = cityManager.getCity(nameCity);

        //richiama il metodo per poter settare i dettagli della città
        editDetailsMethod(city);

        //al click della freccia torna all'activity indietro
        button_comeback_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    //questo metodo setta il nome, la descrizione e l'immagine della città
    private void editDetailsMethod(City city) {
        name_city.setText(city.getName());
        description_city.setText(city.getDescription());
        image_city.setImageDrawable(getCityImage(city));
    }

    //questo metodo prende l'img della città che viene cliccata
    private Drawable getCityImage(City city){
        //parsing the right string: cityname_pic
        String resourceName = city.getName().toLowerCase().replace(" ","").concat("_pic_profile");
        Log.i("RESULT_SURVEY", "Looking for: " + resourceName);
        //getting the id of the resource "cityname_pic.png"
        int resourceId =  this.getResources().getIdentifier(resourceName, "drawable", this.getPackageName());
        //getting the real image
        Drawable image = this.getDrawable(resourceId);

        return image;
    }

}
