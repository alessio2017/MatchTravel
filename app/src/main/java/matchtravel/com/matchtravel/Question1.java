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


public class Question1 extends Fragment {

    private SurveyManager sur;

    private ImageView SeaLake;
    private ImageView Mountain;
    private ImageView Art;
    private ImageView Romantic;
    private ImageView Food;


    public Question1() {
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
        View view = inflater.inflate(R.layout.fragment_question1, container, false);



        SeaLake = (ImageView) view.findViewById(R.id.sea_lake_1);
        Mountain = (ImageView) view.findViewById(R.id.mountain_1);
        Art = (ImageView) view.findViewById(R.id.art_1);
        Romantic = (ImageView) view.findViewById(R.id.romantic_1);
        Food = (ImageView) view.findViewById(R.id.food_1);

        SeaLake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(0);
                Fragment f = new Question2();
                ((Question2) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });
        Mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(1);
                Fragment f = new Question2();
                ((Question2) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(1)
                 */
            }
        });
        Art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(2);
                Fragment f = new Question2();
                ((Question2) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(2)
                 */
            }
        });
        Food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(3);
                Fragment f = new Question2();
                ((Question2) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(3)
                 */
            }
        });

        Romantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer1(4);
                Fragment f = new Question2();
                ((Question2) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(4)
                 */
            }
        });
        return view;
    }
}


