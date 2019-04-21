package com.example.gezginapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {
    public List<Place> placeList;
    LayoutInflater inflater;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView post_description;
        public TextView post_title;
        public ImageView post_picture;

        public MyViewHolder(View v) {
            super(v);
            post_description = (TextView) itemView.findViewById(R.id.post_description);
            post_title = (TextView) itemView.findViewById(R.id.post_title);
            post_picture = (ImageView) itemView.findViewById(R.id.post_picture);

        }
    }

    public PlaceAdapter(List<Place> _placeList, Context _context) {
        placeList = _placeList;
        context = _context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PlaceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_place, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.post_description.setText(placeList.get(position).description);
        holder.post_title.setText(String.valueOf(placeList.get(position).placeName));
        holder.post_picture.setImageResource(placeList.get(position).placeImage);

    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }
}