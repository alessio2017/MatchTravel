package surveyUtility;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import matchtravel.com.matchtravel.R;

public class SurveyAdapter extends RecyclerView.Adapter {

    private int questionId;
    private Fragment parent;

    public SurveyAdapter(int questionId){
        this.questionId = questionId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.survey_cell, parent, false);
        return new SurveyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Drawable image;
        String imageName;
        String text;

        //setting data
        if(questionId==0){
            switch (position){
                case 0:
                    text = "Sea";
                    imageName = "sea_lake";
                    break;
                case 1:
                    text = "Mountain";
                    imageName = "mountain_1";
                    break;
                case 2:
                    text = "Art";
                    imageName = "art_1";
                    break;
                case 3:
                    text = "Food";
                    imageName = "food_1";
                    break;
                default:
                    text = "Romantic";
                    imageName = "romantic_1";
                    break;
            }
        }else if (questionId == 1){
            switch (position){
                case 0:
                    text = "Abroad";
                    imageName = "abroad_1";
                    break;
                case 1:
                    text = "Locally";
                    imageName = "locally_1";
                    break;
                default:
                    text = "Both";
                    imageName = "both_1";
                    break;
            }
        }else if (questionId == 2){
            switch (position){
                case 0:
                    text = "Very low";
                    imageName = "very_low_1";
                    break;
                case 1:
                    text = "Low";
                    imageName = "low_1";
                    break;
                case 2:
                    text = "Medium";
                    imageName = "medium_1";
                    break;
                default:
                    text = "High";
                    imageName = "high_1";
                    break;
            }
        }else if (questionId == 3){
            switch (position){
                case 0:
                    text = "Relax";
                    imageName = "relax_1";
                    break;
                case 1:
                    text = "Trip outside";
                    imageName = "trip_1";
                    break;
                case 2:
                    text = "Visit museums";
                    imageName = "museum_1";
                    break;
                case 3:
                    text = "Go for clubs";
                    imageName = "club_1";
                    break;
                default:
                    text = "All of this !";
                    imageName = "all_1";
                    break;
            }
        }else if (questionId == 4){
            switch (position){
                case 0:
                    text = "Not at all";
                    imageName = "not_1";
                    break;
                case 1:
                    text = "I barely care";
                    imageName = "care_1";
                    break;
                case 2:
                    text = "A bit";
                    imageName = "bit_1";
                    break;
                default:
                    text = "Too much";
                    imageName = "much_1";
                    break;
            }
        }else{
            switch (position){
                case 0:
                    text = "Hot";
                    imageName = "hot_1";
                    break;
                case 1:
                    text = "Temperate";
                    imageName = "temperate_1";
                    break;
                case 2:
                    text = "Cold";
                    imageName = "cold_1";
                    break;
                default:
                    text = "I don't care";
                    imageName = "notcare_1";
                    break;
            }
        }
        //retrieve image
        int resourceId =  parent.getResources().getIdentifier(imageName, "drawable", parent.getActivity().getPackageName());
        image = parent.getActivity().getDrawable(resourceId);

        //binding data
        ((SurveyViewHolder) viewHolder).bindData(text, image, position);
        ((SurveyViewHolder) viewHolder).setOnAnswerGivenListener((SurveyViewHolder.OnAnswerGivenListener) parent);
    }

    @Override
    public int getItemCount() {
        if(questionId == 0 || questionId == 3)
            return 5;
        if(questionId == 2 || questionId == 5 || questionId == 4)
            return 4;
        else
            return 3;
    }

    public void setParent(Fragment parent){
        this.parent = parent;
    }
}
