package com.example.myappp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteFragment3 extends Fragment {

    ArrayList<health_life> healthlist = new ArrayList<>();
    ListView listView;
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater , @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        healthlist.add(new health_life
                (R.drawable.indir, "Yumurta,Peynir,Zeytin", "5000 C"));
        healthlist.add(new health_life
                (R.drawable.images,"Mevsim yeşillikleri,Salata.", "2000 C"));
        healthlist.add(new health_life
                (R.drawable.indir1,"Badem,Fındık,Ceviz.", "4000 C"));

        CustomAdapter customAdapter=
                new CustomAdapter(healthlist,getContext() );
        View view =inflater.inflate(R.layout.fragment_favorite3,null);
        listView = view.findViewById(R.id.list_health);
        listView.setAdapter(customAdapter);


         return view;
    }
}

