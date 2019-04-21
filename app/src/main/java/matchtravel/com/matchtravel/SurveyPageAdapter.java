package matchtravel.com.matchtravel;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragmentSurvey.*;
import objectBoxUtility.SurveyManager;

public class SurveyPageAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private SurveyManager sur;

    public SurveyPageAdapter(FragmentManager fm, SurveyManager sur) {
        super(fm);
        this.sur = sur;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position)  {
        if (position == 0)
            return new Question1(sur);
        else if(position == 1)
            return new Question2(sur);
        else if(position == 2)
            return new Question3(sur);
        else if(position == 3)
            return new Question4(sur);
        else if(position == 4)
            return new Question5(sur);
        else
            return new Question6(sur);
    }

    @Override
    public int getCount() {
        return 6;
    }




}