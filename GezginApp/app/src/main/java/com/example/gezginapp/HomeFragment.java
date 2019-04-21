package com.example.gezginapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<Place> postList = new ArrayList<Place>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=
                inflater.inflate(R.layout.fragment_home,container,
                        false);
        RecyclerView recyclerView=view.findViewById(R.id.recycler_place);
        postList.add(new Place(R.drawable.foto1,"Trabzon","Karadeniz'in incisi olarak tabir edilen, eşsiz doğasıyla nefes kesen bir şehir Trabzon."));
        postList.add(new Place(R.drawable.foto2,"Mardin","Dicle ve Fırat nehirleri arasında yer alan Mardin Güneydoğu Anadolu Bölgesi'nin en çok merak edilen şehirlerinden biridir."));
        postList.add(new Place(R.drawable.foto3,"İzmir","ürkiye'nin batısında, Ege Denizi'nin kıyısında yer alan Ege'nin İncisi İzmir, Türkiye'nin 3'üncü büyük kentidir."));
        postList.add(new Place(R.drawable.foto4,"İstanbul","Avrupa ve Asya'yı birbirine bağlayan, çok sayıda medeniyetin izlerini taşıyan istanbul"));

        PlaceAdapter adapter=new PlaceAdapter(postList,getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation
                (LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager
                (linearLayoutManager);
        return view;
    }
}
