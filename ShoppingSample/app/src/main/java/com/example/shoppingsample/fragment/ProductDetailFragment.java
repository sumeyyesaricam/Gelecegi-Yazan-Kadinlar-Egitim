package com.example.shoppingsample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoppingsample.R;

public class ProductDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_product_detail, container, false);
        ImageView imageProduct=view.findViewById(R.id.imageProduct);
        TextView txtPrice=view.findViewById(R.id.txtPrice);
        txtPrice.setText(getArguments().getString("price"));
        getActivity().setTitle(getArguments().getString("name"));
        //imageProduct.setImageResource(getArguments().getInt("image"));
        return view;
    }

}