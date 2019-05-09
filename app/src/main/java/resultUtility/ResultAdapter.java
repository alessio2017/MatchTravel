package resultUtility;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import datadb.City;
import matchtravel.com.matchtravel.R;

public class ResultAdapter extends RecyclerView.Adapter  {

    private List<City> results;
    private Activity parent;

    public ResultAdapter(){}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_cell, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        City city = results.get(i);
        //parsing the right string: cityname_pic
        String resourceName = city.getName().toLowerCase().replace(" ","").concat("_pic");
        Log.i("RESULT_SURVEY", "Looking for: " + resourceName);
        //getting the id of the resource "cityname_pic.png"
        int resourceId =  parent.getResources().getIdentifier(resourceName, "drawable", parent.getPackageName());
        //getting the real image
        Drawable image = parent.getDrawable(resourceId);
        //binding data and setting listener event
        ((ResultViewHolder) viewHolder).bindData(city, image);
        ((ResultViewHolder) viewHolder).setOnTouchResultCellListener((ResultViewHolder.OnTouchResultCell) parent);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<City> cities, Activity parent){
        this.results = cities;
        this.parent = parent;
    }

    public void removeItem(City city){
        this.results.remove(city);
        this.notifyDataSetChanged();
    }
}
