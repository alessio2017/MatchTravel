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


public class Question5 extends Fragment {
    private SurveyManager sur;

    private ViewPager pager;
    private ImageView Not;
    private ImageView Care;
    private ImageView Bit;
    private ImageView Much;



    public Question5() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Question5(SurveyManager sur){
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
        View view = inflater.inflate(R.layout.fragment_question5, container, false);
        pager = container.findViewById(R.id.pager);

        Not = (ImageView) view.findViewById(R.id.not_1);
        Care = (ImageView) view.findViewById(R.id.care_1);
        Bit = (ImageView) view.findViewById(R.id.bit_1);
        Much = (ImageView) view.findViewById(R.id.much_1);


        Not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(0);
                pager.setCurrentItem(5);
            }
        });

        Care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(1);
                pager.setCurrentItem(5);
            }
        });

        Bit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(2);
                pager.setCurrentItem(5);
            }
        });

        Much.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(3);
                pager.setCurrentItem(5);
            }
        });
        return view;
    }


}
