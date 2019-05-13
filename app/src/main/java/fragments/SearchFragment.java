package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import javax.annotation.Nullable;

import matchtravel.com.matchtravel.CityProfileActivity;
import matchtravel.com.matchtravel.R;
import matchtravel.com.matchtravel.Result;
import matchtravel.com.matchtravel.WishListActivity;

import static android.R.layout.simple_list_item_1;

public class SearchFragment extends Fragment {

    //la search bar
    EditText search;
    //la list view delle città
    ListView lv;
    //l'arraylist per la listview
    ArrayList<String> al;
    //adapter per la list view
    ArrayAdapter<String> aa;


    //={"Rome", "London", "Paris", "Madrid", "Berlin", "Barcelona", "Vienna", "New York", "Hong Kong", "Bangkok", "Rio de Janeiro", "Venice", "Prague", "Siena", "Tokyo", "Beijing", "Florence", "Milan", "Naples", "Turin", "Brussels", "Amsterdam", "Munich", "Bern", "Manchester", "Oxford", "Dublin", "Washington", "Los Angeles", "Mexico City", "Agrigento", "Otranto", "Gallipoli", "Vieste", "Geneva", "Dubai", "Maldive", "Mykonos","Athens", "Dusseldorf", "Ibiza", "Miami", "San Francisco", "Cairo", "Instanbul", "Sydney", "Singapore", "Shenzen", "Delhi", "Mumbai", "Kuala Lumpar", "Buenos Aires", "Cordoba", "Havana"};

    public SearchFragment(){
        //costruttore publico vuoto richiesto sempre
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        //città (dati) della listview
        final String[] cities = {"Rome", "London", "Paris", "Madrid", "Berlin", "Barcelona", "Vienna",
                "New York", "Hong Kong", "Bangkok", "Rio de Janeiro", "Venice", "Prague", "Siena",
                "Tokyo", "Beijing", "Florence", "Milan", "Naples", "Turin", "Brussels", "Amsterdam",
                "Munich", "Bern", "Manchester", "Oxford", "Dublin", "Washington", "Los Angeles",
                "Mexico City", "Agrigento", "Otranto", "Gallipoli", "Vieste", "Geneva", "Dubai",
                "Maldive", "Mykonos", "Athens", "Dusseldorf", "Ibiza", "Miami", "San Francisco",
                "Cairo", "Instanbul", "Sydney", "Singapore", "Shenzen", "Delhi", "Mumbai",
                "Kuala Lumpar", "Buenos Aires", "Cordoba", "Havana"};


        lv = (ListView) view.findViewById(R.id.result_list_items);

        al = new ArrayList<String>();

        // adapter per adattare ogni stringa della città ad un singolo elemento della listview
        aa = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                al
        );

        //assegna l'adapter alla listview
        lv.setAdapter(aa);

        //aggiungo città all'arraylist
        al.addAll(Arrays.asList(cities));


        //metodo che al click su una delle città va al profilo delle città
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String s = aa.getItem(position);

                //TODO intent che va alla pagina della città cliccata
                Intent goToProfileOfCitySelected = new Intent(getActivity(), CityProfileActivity.class);
                goToProfileOfCitySelected.putExtra("city_name",s);
                startActivity(goToProfileOfCitySelected);

            }
        });

        //inizializzazione della search bar
        search = (EditText) view.findViewById(R.id.search_bar);


        // Filtro search sulla lista
        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                String text = search.getText().toString().toLowerCase(Locale.getDefault());
                aa.getFilter().filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {}

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {}
        });





        return view;
    }



}
