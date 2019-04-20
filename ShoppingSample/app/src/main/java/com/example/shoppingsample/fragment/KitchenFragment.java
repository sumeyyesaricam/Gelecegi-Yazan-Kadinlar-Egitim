package com.example.shoppingsample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingsample.R;
import com.example.shoppingsample.adapter.ProductAdapter;
import com.example.shoppingsample.model.Product;

import java.util.ArrayList;
import java.util.List;

public class KitchenFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_kitchen, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recycler_kitchen);

        ProductAdapter productAdapter =
                new ProductAdapter(getData(), getActivity());
        recyclerView.setAdapter(productAdapter);


        recyclerView.setLayoutManager
                (new GridLayoutManager(getActivity(), 2));
        return view;
    }

    public List<Product> getData(){
        List<Product> products=new ArrayList<Product>();
        products.add(new Product(1,R.drawable.tencere,64
                ,"Papilla Entel Karnıyarık Tencere - 26 cm"));
        products.add(new Product(2,R.drawable.kasik,89
                ,"The Mia Çay Kaşığı 6 Parça - Rose"));
        products.add(new Product(3,R.drawable.bardak,52
                ,"Lav Diamond 18 Parça Cam Bardak Takımı"));
        products.add(new Product(4,R.drawable.kap,6
                ,"Lav DT0217 Cam Saklama Kabı"));
        return products;
    }
}
