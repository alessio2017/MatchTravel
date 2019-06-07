package fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

import matchtravel.com.matchtravel.R;
import matchtravel.com.matchtravel.Result;
import objectBoxUtility.SurveyManager;
import surveyUtility.SurveyAdapter;
import surveyUtility.SurveyViewHolder;

public class Question extends Fragment implements SurveyViewHolder.OnAnswerGivenListener {

    private SurveyManager surveyManager;
    private int questionId;
    private TextView textQuestionView;
    private RecyclerView recyclerView;
    private StateProgressBar stateProgressBar;
    public Question() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_survey, container, false);
        this.surveyManager = new SurveyManager();
        this.questionId = 0;
        this.textQuestionView = view.findViewById(R.id.textQuestionSurvey);
        this.recyclerView = view.findViewById(R.id.surveyRecyclerView);
        this.stateProgressBar = (StateProgressBar) view.findViewById(R.id.state_progress_bar);


        updateView();
        return view;
    }

    private void updateView() {

        //setting question
        String textQuestion;

        switch (questionId){
            case 0:
                textQuestion = getString(R.string.first_question);
                break;
            case 1:
                textQuestion = getString(R.string.second_question);
                break;
            case 2:
                textQuestion = getString(R.string.third_question);
                break;
            case 3:
                textQuestion = getString(R.string.fourth_question);
                break;
            case 4:
                textQuestion = getString(R.string.fifth_question);
                break;
            default:
                textQuestion = getString(R.string.sixth_question);
                break;
        }

        textQuestionView.setText(textQuestion);

        //setting answer list
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SurveyAdapter adapter = new SurveyAdapter(questionId);
        adapter.setParent(this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAnswerGiven(int answer) {
        switch (questionId){
            case 0:
                surveyManager.setAnswer1(answer);
                proceed();
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                stateProgressBar.setCurrentStateDescriptionColor(ContextCompat.getColor(this.getContext(), R.color.dark_grey));
                stateProgressBar.setStateDescriptionColor(ContextCompat.getColor(this.getContext(),  R.color.dark_grey));
                stateProgressBar.enableAnimationToCurrentState(true);
                break;
            case 1:

                surveyManager.setAnswer2(answer);
                proceed();
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                stateProgressBar.enableAnimationToCurrentState(true);
                stateProgressBar.setCurrentStateDescriptionColor(ContextCompat.getColor(this.getContext(), R.color.dark_grey));
                stateProgressBar.setStateDescriptionColor(ContextCompat.getColor(this.getContext(),  R.color.dark_grey));
                break;
            case 2:
                surveyManager.setAnswer3(answer);
                proceed();
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                stateProgressBar.setCurrentStateDescriptionColor(ContextCompat.getColor(this.getContext(), R.color.dark_grey));
                stateProgressBar.setStateDescriptionColor(ContextCompat.getColor(this.getContext(),  R.color.dark_grey));
                stateProgressBar.enableAnimationToCurrentState(true);
                break;
            case 3:
                surveyManager.setAnswer4(answer);
                proceed();
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                stateProgressBar.setCurrentStateDescriptionColor(ContextCompat.getColor(this.getContext(), R.color.dark_grey));
                stateProgressBar.setStateDescriptionColor(ContextCompat.getColor(this.getContext(),  R.color.dark_grey));
                stateProgressBar.enableAnimationToCurrentState(true);
                break;
            case 4:
                surveyManager.setAnswer5(answer);
                proceed();

                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);
                stateProgressBar.setCurrentStateDescriptionColor(ContextCompat.getColor(this.getContext(), R.color.dark_grey));
                stateProgressBar.setStateDescriptionColor(ContextCompat.getColor(this.getContext(),  R.color.dark_grey));
                stateProgressBar.enableAnimationToCurrentState(true);
                stateProgressBar.setAllStatesCompleted(true);
                break;
            default:
                surveyManager.setAnswer6(answer);
                goToResult();
                break;
        }
    }

    private void proceed() {
        questionId++;
        updateView();
    }

    private void goToResult(){
        //going to results
        Intent myIntent = new Intent(getActivity(), Result.class);
        myIntent.putExtra("answer1", surveyManager.getAnswer1());
        myIntent.putExtra("answer2", surveyManager.getAnswer2());
        myIntent.putExtra("answer3", surveyManager.getAnswer3());
        myIntent.putExtra("answer4", surveyManager.getAnswer4());
        myIntent.putExtra("answer5", surveyManager.getAnswer5());
        myIntent.putExtra("answer6", surveyManager.getAnswer6());

        startActivity(myIntent);
    }
}
