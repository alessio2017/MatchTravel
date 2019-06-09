package profileUtility;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import datadb.City;
import de.hdodenhof.circleimageview.CircleImageView;
import matchtravel.com.matchtravel.R;

public class ProfileNotAdapter extends RecyclerView.Adapter<ProfileNotAdapter.ViewHolder> {
    private List<City> results;
    private Activity parent;

    // Define listener member variable
    private OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ProfileNotAdapter(List<City> cities, Activity activity) {
        results = cities;
        this.parent = activity;
    }
    @NonNull
    @Override

    public ProfileNotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.citieslist_cell, viewGroup, false);

        // Return a new holder instance
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProfileNotAdapter.ViewHolder myViewHolder, int i) {
        City city = results.get(i);

        myViewHolder.nomeCity.setText(city.getName());
        String resourceName = city.getName().toLowerCase().replace(" ","").concat("_pic");
        int resourceId =  parent.getResources().getIdentifier(resourceName, "drawable", parent.getPackageName());
        Drawable image = parent.getDrawable(resourceId);
        myViewHolder.imageCity.setImageDrawable(image);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private CircleImageView imageCity;
        private TextView nomeCity;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            this.imageCity = itemView.findViewById(R.id.imageCity);
            this.nomeCity = itemView.findViewById(R.id.nomeCity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }
}
