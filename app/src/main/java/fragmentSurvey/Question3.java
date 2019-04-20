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


public class Question3 extends Fragment {

    private ViewPager pager;
    private SurveyManager sur;
    private ImageView Very_low;
    private ImageView Low;
    private ImageView Medium;
    private ImageView High;

    public void setSur(SurveyManager sur){
        this.sur=sur;
    }


    public Question3() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Question3(SurveyManager sur){
        this.sur = sur;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question3, container, false);

        pager = container.findViewById(R.id.pager);

        Very_low = (ImageView) view.findViewById(R.id.very_low_1);
        Low = (ImageView) view.findViewById(R.id.low_1);
        Medium = (ImageView) view.findViewById(R.id.medium_1);
        High = (ImageView) view.findViewById(R.id.high_1);

        Very_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer3(0);
                pager.setCurrentItem(3);
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        Low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer3(1);
                pager.setCurrentItem(3);
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer3(2);
                pager.setCurrentItem(3);

            }
        });
        High.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer3(3);
                pager.setCurrentItem(3);

            }
        });



        return view;
    }



}
