package resultUtility;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import datadb.City;
import matchtravel.com.matchtravel.R;

public class ResultViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageCity;
    private ImageView infoCityBtn;
    private TextView cityName;

    private OnTouchResultCell callback;

    public ResultViewHolder(@NonNull View itemView) {
        super(itemView);

        this.imageCity = itemView.findViewById(R.id.result_image_city);
        this.infoCityBtn = itemView.findViewById(R.id.result_info_city);
        this.cityName = itemView.findViewById(R.id.result_city_name);
    }

    public void bindData(final City city, Drawable imageCity){
        //setting name
        this.cityName.setText(city.getName());
        //setting info
        this.infoCityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onTouchInfoButton(city);
            }
        });
        //setting image city
        this.imageCity.setImageDrawable(imageCity);
        this.imageCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onTouchImage(city);
            }
        });
    }

    public interface OnTouchResultCell{
        void onTouchImage(City city);
        void onTouchInfoButton(City city);
    }

    public void setOnTouchResultCellListener(OnTouchResultCell listener){
        this.callback = listener;
    }
}
