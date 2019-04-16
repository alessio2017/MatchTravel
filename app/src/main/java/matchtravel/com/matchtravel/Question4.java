package matchtravel.com.matchtravel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Question4 extends Fragment {
    private SurveyManager sur;

    private ImageView Relax;
    private ImageView Trip;
    private ImageView Museum;
    private ImageView Club;
    private ImageView All;


    public Question4() {
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
        View view = inflater.inflate(R.layout.fragment_question4, container, false);


        Relax = (ImageView) view.findViewById(R.id.relax_1);
        Trip = (ImageView) view.findViewById(R.id.trip_1);
        Museum = (ImageView) view.findViewById(R.id.museum_1);
        Club = (ImageView) view.findViewById(R.id.club_1);
        All = (ImageView) view.findViewById(R.id.all_1);

        Relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(0);
                Fragment f = new Question5();
                ((Question5) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        Trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(1);
                Fragment f = new Question5();
                ((Question5) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        Museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(2);
                Fragment f = new Question5();
                ((Question5) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        Club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(3);
                Fragment f = new Question5();
                ((Question5) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer4(4);
                Fragment f = new Question5();
                ((Question5) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        return view;
    }


}
