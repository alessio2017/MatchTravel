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



public class Question5 extends Fragment {
    private SurveyManager sur;

    private ImageView Not;
    private ImageView Care;
    private ImageView Bit;
    private ImageView Much;



    public Question5() {
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
        View view = inflater.inflate(R.layout.fragment_question5, container, false);
        Not = (ImageView) view.findViewById(R.id.not_1);
        Care = (ImageView) view.findViewById(R.id.care_1);
        Bit = (ImageView) view.findViewById(R.id.bit_1);
        Much = (ImageView) view.findViewById(R.id.much_1);


        Not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(0);
                Fragment f = new Question6();
                ((Question6) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });

        Care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(1);
                Fragment f = new Question6();
                ((Question6) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });

        Bit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(2);
                Fragment f = new Question6();
                ((Question6) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });

        Much.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer5(3);
                Fragment f = new Question6();
                ((Question6) f).setSur(sur);
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
