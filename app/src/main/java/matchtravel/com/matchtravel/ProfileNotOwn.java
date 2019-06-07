package matchtravel.com.matchtravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import datadb.City;
import datadb.User;
import de.hdodenhof.circleimageview.CircleImageView;
import io.objectbox.BoxStore;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.SurveyManager;
import objectBoxUtility.UserManager;
import profileUtility.*;

public class ProfileNotOwn extends AppCompatActivity {
    private UserManager manager;
    private User user;
    private String name;
    private String surname;


    private ProfileNotAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_not_own);
        this.manager = new UserManager((ObjectBox.get()));

        //quando c'è l'evento che genera la visualizzazione del profile bisogna passare(a questa attività)
        //nome e cognome dell'utente da visualizzare

        this.name = getIntent().getStringExtra("name");
        this.surname = getIntent().getStringExtra("surname");

        this.user = this.manager.getUser(name,surname);
        user.setName(this.name);
        user.setSurname(this.surname);

        TextView status = findViewById(R.id.stateown);
        status.setText(user.getStatus());
        TextView age = findViewById(R.id.ageown);
        age.setText(Integer.toString(calculateAge(user.getAge())) + " yo");
        TextView nation = findViewById(R.id.nationown);
        nation.setText(user.getCountry());
        TextView name = findViewById(R.id.txt_name);
        name.setText(this.name+" "+this.surname);
        TextView description = findViewById(R.id.edit_own);
        description.setText(user.getDescription());
        TextView listcity = findViewById(R.id.listcity);
        listcity.setText("Where "+this.name+" wants to go");

        //TODO settare immagine utente.
        CircleImageView image = findViewById(R.id.image_profilepic);

        List<City> cities = user.getDestinations();
        this.adapter = new ProfileNotAdapter(cities, this);


        RecyclerView recyclerView = findViewById(R.id.cityRecyclerView);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView btnBackHome = findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private int calculateAge(Date age) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        cal.setTime(age);
        int userYear = cal.get(Calendar.YEAR);
        return currentYear - userYear;
    }
}
