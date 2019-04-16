package matchtravel.com.matchtravel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Question6 extends Fragment {
    private SurveyManager sur;

    private ImageView Hot;
    private ImageView Temperate;
    private ImageView Cold;
    private ImageView NotCare;


    public Question6() {
        // Required empty public constructor
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
                String result =""+sur.getA1()+" "+sur.getA2()+" "+sur.getA3()+" "+sur.getA4()+" "+sur.getA5()+" "+sur.getA6();

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
                String result =""+sur.getA1()+" "+sur.getA2()+" "+sur.getA3()+" "+sur.getA4()+" "+sur.getA5()+" "+sur.getA6();

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
                String result =""+sur.getA1()+" "+sur.getA2()+" "+sur.getA3()+" "+sur.getA4()+" "+sur.getA5()+" "+sur.getA6();

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
                String result =""+sur.getA1()+" "+sur.getA2()+" "+sur.getA3()+" "+sur.getA4()+" "+sur.getA5()+" "+sur.getA6();

                Intent myIntent = new Intent(getActivity(), Result.class);
                myIntent.putExtra("results",result);
                startActivity(myIntent);
            }
        });
        return view;

    }


}
