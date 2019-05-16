package matchtravel.com.matchtravel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragments.Question;
import objectBoxUtility.*;

public class SurveyActivity extends AppCompatActivity {

    private SurveyManager sur;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        this.sur = new SurveyManager();

        Fragment f = new Question();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.fragment_su, f);
        t.commit();
    }
}
