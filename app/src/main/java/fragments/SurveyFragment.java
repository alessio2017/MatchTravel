package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.Nullable;

import matchtravel.com.matchtravel.R;
import matchtravel.com.matchtravel.SurveyActivity;
import matchtravel.com.matchtravel.SurveyPageAdapter;
import objectBoxUtility.SurveyManager;

public class SurveyFragment extends Fragment {
    private SurveyManager sur;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_survey, container, false);
        ViewPager viewPager = view.findViewById(R.id.pager);
        // Create an adapter that knows which fragment should be shown on each page
        this.sur = new SurveyManager();
        SurveyPageAdapter adapterTab = new SurveyPageAdapter(getActivity().getSupportFragmentManager(), sur);
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapterTab);
        viewPager.setOffscreenPageLimit(2);
        return view;
    }

}
