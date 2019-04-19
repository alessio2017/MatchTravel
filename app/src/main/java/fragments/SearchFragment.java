package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.annotation.Nullable;

import matchtravel.com.matchtravel.R;

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
        String cities [] = {"Rome", "London", "Paris", "Madrid", "Berlin", "Barcelona", "Vienna",
                "New York", "Hong Kong", "Bangkok", "Rio de Janeiro", "Venice", "Prague", "Siena",
                "Tokyo", "Beijing", "Florence", "Milan", "Naples", "Turin", "Brussels", "Amsterdam",
                "Munich", "Bern", "Manchester", "Oxford", "Dublin", "Washington", "Los Angeles",
                "Mexico City", "Agrigento", "Otranto", "Gallipoli", "Vieste", "Geneva", "Dubai",
                "Maldive", "Mykonos","Athens", "Dusseldorf", "Ibiza", "Miami", "San Francisco",
                "Cairo", "Instanbul", "Sydney", "Singapore", "Shenzen", "Delhi", "Mumbai",
                "Kuala Lumpar", "Buenos Aires", "Cordoba", "Havana"};


        search = (EditText) view.findViewById(R.id.search_bar);

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



        return view;
    }


}


