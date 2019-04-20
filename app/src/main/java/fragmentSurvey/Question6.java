package fragmentSurvey;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import matchtravel.com.matchtravel.R;
import matchtravel.com.matchtravel.Result;
import objectBoxUtility.*;


public class Question6 extends Fragment {
    private SurveyManager sur;

    private ViewPager pager;
    private ImageView Hot;
    private ImageView Temperate;
    private ImageView Cold;
    private ImageView NotCare;


    public Question6() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Question6(SurveyManager sur){
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
        View view = inflater.inflate(R.layout.fragment_question6, container, false);
        pager = container.findViewById(R.id.pager);

        Hot = (ImageView) view.findViewById(R.id.hot_1);
        Temperate = (ImageView) view.findViewById(R.id.temperate_1);
        Cold = (ImageView) view.findViewById(R.id.cold_1);
        NotCare = (ImageView) view.findViewById(R.id.notcare_1);


        Hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer6(0);

                /* qui va gestito l'intent che porta all'activity per gestione risultati

                 */
                String result =""+sur.getAnswer1()+" "+sur.getAnswer2()+" "+sur.getAnswer3()+" "+sur.getAnswer4()+" "+sur.getAnswer5()+" "+sur.getAnswer6();

                Intent myIntent = new Intent(getActivity(), Result.class);
                myIntent.putExtra("results",result);
                startActivity(myIntent);
            }
        });
        Temperate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer6(1);

                /* qui va gestito l'intent che porta all'activity per gestione risultati

                 */
                String result =""+sur.getAnswer1()+" "+sur.getAnswer2()+" "+sur.getAnswer3()+" "+sur.getAnswer4()+" "+sur.getAnswer5()+" "+sur.getAnswer6();

                Intent myIntent = new Intent(getActivity(), Result.class);
                myIntent.putExtra("results",result);
                startActivity(myIntent);
            }
        });
        Cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer6(2);

                /* qui va gestito l'intent che porta all'activity per gestione risultati

                 */
                String result =""+sur.getAnswer1()+" "+sur.getAnswer2()+" "+sur.getAnswer3()+" "+sur.getAnswer4()+" "+sur.getAnswer5()+" "+sur.getAnswer6();
                Intent myIntent = new Intent(getActivity(), Result.class);
                myIntent.putExtra("results",result);
                startActivity(myIntent);
            }
        });
        NotCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer6(3);

                /* qui va gestito l'intent che porta all'activity per gestione risultati

                 */
                String result =""+sur.getAnswer1()+" "+sur.getAnswer2()+" "+sur.getAnswer3()+" "+sur.getAnswer4()+" "+sur.getAnswer5()+" "+sur.getAnswer6();
                Intent myIntent = new Intent(getActivity(), Result.class);
                myIntent.putExtra("results",result);
                startActivity(myIntent);
            }
        });
        return view;

    }


}
