package fragmentSurvey;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import objectBoxUtility.*;
import matchtravel.com.matchtravel.R;

public class Question1 extends Fragment {

    private SurveyManager sur;

    private ImageView SeaLake;
    private ImageView Mountain;
    private ImageView Art;
    private ImageView Romantic;
    private ImageView Food;
    private ViewPager pager;


    public Question1() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Question1(SurveyManager sur){
        this.sur = sur;
        Log.d("CIAO", this.sur.toString());
    }

    public void setSur(SurveyManager sur){
        this.sur=sur;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question1, container, false);


        pager = container.findViewById(R.id.pager);
        SeaLake = (ImageView) view.findViewById(R.id.sea_lake_1);
        Mountain = (ImageView) view.findViewById(R.id.mountain_1);
        Art = (ImageView) view.findViewById(R.id.art_1);
        Romantic = (ImageView) view.findViewById(R.id.romantic_1);
        Food = (ImageView) view.findViewById(R.id.food_1);

        SeaLake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(0);
                pager.setCurrentItem(1);
            }
        });
        Mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(1);
                pager.setCurrentItem(1);
            }
        });
        Art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(2);
                pager.setCurrentItem(1);
            }
        });
        Food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(3);
                pager.setCurrentItem(1);
            }
        });

        Romantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(4);
                pager.setCurrentItem(1);
            }
        });
        return view;
    }
}


