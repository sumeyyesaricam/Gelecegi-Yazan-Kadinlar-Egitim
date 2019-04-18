package com.example.shoppingsample.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoppingsample.MainActivity;
import com.example.shoppingsample.R;
import com.example.shoppingsample.fragment.FurnitureFragment;
import com.example.shoppingsample.fragment.ProductDetailFragment;
import com.example.shoppingsample.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    public List<Product> productList;
    LayoutInflater inflater;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtProductName;
        public TextView txtPrice;
        public ImageView imageProduct;

        public MyViewHolder(View v) {
            super(v);
            txtProductName = (TextView) itemView.findViewById(R.id.txtProductName);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            imageProduct = (ImageView) itemView.findViewById(R.id.imageProduct);

        }
    }

    public ProductAdapter(List<Product> _productList, Context _context) {
        productList = _productList;
        context = _context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_product, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtProductName.setText(productList.get(position).getProductName());
        holder.txtPrice.setText(String.valueOf(productList.get(position).getPrice()) + " TL");
        holder.imageProduct.setImageResource(productList.get(position).getProductImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailFragment productDetailFragment = new ProductDetailFragment();
                Bundle args = new Bundle();
                args.putString("name", productList.get(position).getProductName());
                args.putString("price", String.valueOf(productList.get(position).getPrice()) + " TL");
                args.putInt("image", productList.get(position).getProductImage());
                productDetailFragment.setArguments(args);
                ((MainActivity) holder.itemView.getContext()).getFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, productDetailFragment)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
