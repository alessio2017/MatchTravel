package matchtravel.com.matchtravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import datadb.City;
import datadb.User;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.SurveyManager;
import objectBoxUtility.UserManager;
import resultUtility.ResultAdapter;
import resultUtility.ResultViewHolder;

public class Result extends AppCompatActivity implements ResultViewHolder.OnTouchResultCell {

    private UserManager userManager;
    private User currentUser;
    private ResultAdapter adapter;
    private List<City> toAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.toAdd = new ArrayList<>();

        //setting current user
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.sharedPref_file), MODE_PRIVATE);
        final int user = sharedPreferences.getInt(getString(R.string.sharedPref_current_user),0);
        String userName;
        switch (user){
            case 0:
                userName = "Daniele";
                break;
            case 1:
                userName = "Alessio";
                break;
            default:
                userName = "Umberto";
                break;
        }
        this.userManager = new UserManager(ObjectBox.get());
        this.currentUser = new UserManager(ObjectBox.get()).getRealUser(userName);

        //setting result list
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        int a5 = 0;
        int a6 = 0;

        try{
            a1 = getIntent().getIntExtra("answer1", 0);
            a2 = getIntent().getIntExtra("answer2", 0);
            a3 = getIntent().getIntExtra("answer3", 0);
            a4 = getIntent().getIntExtra("answer4", 0);
            a5 = getIntent().getIntExtra("answer5", 0);
            a6 = getIntent().getIntExtra("answer6", 0);
        }catch (Exception e){
            e.printStackTrace();
        }

        SurveyManager surveyManager = new SurveyManager();
        surveyManager.setAnswers(a1,a2,a3,a4,a5,a6);
        List<City> results = surveyManager.getCitiesFromSurvey();

        if(results.size()!=0){
            //setting recyclerView with the results
            this.adapter = new ResultAdapter();
            adapter.setResults(results, this);

            RecyclerView recyclerView = findViewById(R.id.result_activity_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }

        //setting button onClickListener
        Button btnContinue = findViewById(R.id.result_btn_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.addDestination(currentUser,toAdd);
                goToWishList();
            }
        });

        Button btnRepeat = findViewById(R.id.result_btn_repeat);
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.addDestination(currentUser,toAdd);
                Intent repeatSurvey = new Intent(Result.this, SurveyActivity.class);
                startActivity(repeatSurvey);
            }
        });
    }

    private void goToWishList(){
        Intent goToWishList = new Intent(Result.this, WishListActivity.class);
        startActivity(goToWishList);
    }

    @Override
    public void onTouchImage(City city) {
        //adding city to destination list
        toAdd.add(city);
        //removing from list
        adapter.removeItem(city);
        //notify to the user that the city is now one of his desired destination
        Toast.makeText(this, R.string.notifyCityAdded, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTouchInfoButton(City city) {
        //TODO: profilo città
    }
}
