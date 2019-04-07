package com.example.myappp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FavoriteFragment2 extends Fragment {

    ImageView imageHealth;
    TextView textHealth;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite2,
                null);

        imageHealth=view.findViewById(R.id.imageView);
        textHealth=view.findViewById(R.id.textView);



        return view;
    }
}
