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

public class FurnitureFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_furniture, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recycler_furniture);

        ProductAdapter productAdapter =
                new ProductAdapter(getData(), getActivity());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager
                (new GridLayoutManager(getActivity(), 2));
        return view;
    }

    public List<Product> getData(){
        List<Product> products=new ArrayList<Product>();
        products.add(new Product(1,R.drawable.koltuk,500
                ,"Sigma Tasarım Asya 2'li Koltuk - Turkuaz"));
        products.add(new Product(2,R.drawable.raf,500
                ,"Nav Decoration Merlin 3'lü Duvar Rafı - Beyaz"));
        products.add(new Product(3,R.mipmap.ic_launcher,500
                ,"Kurşun Kalem"));
        products.add(new Product(4,R.mipmap.ic_launcher,500
                ,"Kurşun Kalem"));
        return products;
    }
}