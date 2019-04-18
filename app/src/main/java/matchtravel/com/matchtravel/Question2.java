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


public class Question2 extends Fragment {
    private SurveyManager sur;
    private ImageView Abroad;
    private ImageView Locally;
    private ImageView Both;

    public void setSur(SurveyManager sur){
        this.sur=sur;
    }

    public Question2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question2, container, false);
        Abroad = (ImageView) view.findViewById(R.id.abroad_1);
        Locally = (ImageView) view.findViewById(R.id.locally_1);
        Both = (ImageView) view.findViewById(R.id.both_1);


        Abroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer2(0);
                Fragment f = new Question3();
                ((Question3) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });

        Locally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer2(1);
                Fragment f = new Question3();
                ((Question3) f).setSur(sur);
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment, f);
                t.commit();
                /* qui va gestito l'intent che porta all'activity per la seconda domanda
                sur.setAnswer1(0)
                 */
            }
        });

        Both.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sur.setAnswer2(2);
                Fragment f = new Question3();
                ((Question3) f).setSur(sur);
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


