package surveyUtility;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import matchtravel.com.matchtravel.R;

public class SurveyViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView text;
    public int position;
    private OnAnswerGivenListener callback;

    public SurveyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.imageSurveyCell);
        this.text = itemView.findViewById(R.id.textSurveyCell);
        this.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onAnswerGiven(position);
            }
        });
    }

    public void bindData(String text, Drawable image, int position){
        this.image.setImageDrawable(image);
        this.text.setText(text);
        this.position = position;
    }

    public interface OnAnswerGivenListener{
        void onAnswerGiven(int answer);
    }

    public void setOnAnswerGivenListener(OnAnswerGivenListener listener){
        this.callback = listener;
    }
}
