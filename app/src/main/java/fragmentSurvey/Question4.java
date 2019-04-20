package fragmentSurvey;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import matchtravel.com.matchtravel.R;
import objectBoxUtility.*;

public class Question4 extends Fragment {
    private SurveyManager sur;

    private ViewPager pager;
    private ImageView Relax;
    private ImageView Trip;
    private ImageView Museum;
    private ImageView Club;
    private ImageView All;


    public Question4() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Question4(SurveyManager sur){
        this.sur = sur;
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
        View view = inflater.inflate(R.layout.fragment_question4, container, false);

        pager = container.findViewById(R.id.pager);

        Relax = (ImageView) view.findViewById(R.id.relax_1);
        Trip = (ImageView) view.findViewById(R.id.trip_1);
        Museum = (ImageView) view.findViewById(R.id.museum_1);
        Club = (ImageView) view.findViewById(R.id.club_1);
        All = (ImageView) view.findViewById(R.id.all_1);

        Relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(0);
                pager.setCurrentItem(4);

            }
        });
        Trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(1);
                pager.setCurrentItem(4);

            }
        });
        Museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(2);
                pager.setCurrentItem(4);
            }
        });
        Club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(3);
                pager.setCurrentItem(4);
            }
        });
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(4);
                pager.setCurrentItem(4);
            }
        });
        return view;
    }


}
