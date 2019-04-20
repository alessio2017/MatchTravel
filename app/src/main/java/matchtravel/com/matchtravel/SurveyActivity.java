package matchtravel.com.matchtravel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import fragmentSurvey.*;
import objectBoxUtility.*;

public class SurveyActivity extends AppCompatActivity {

    private SurveyManager sur;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.pager);
        // Create an adapter that knows which fragment should be shown on each page
        this.sur = new SurveyManager();
        SurveyPageAdapter adapterTab = new SurveyPageAdapter(getSupportFragmentManager(), sur);
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapterTab);
        viewPager.setOffscreenPageLimit(2);

        /*this.sur = new SurveyManager();

        Fragment f = new Question1();
        ((Question1) f).setSur(sur);
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.fragment_su, f);
        t.commit();*/
    }
}
