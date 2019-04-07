package com.example.myappp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<health_life> healthlist;
    Context context;

    public CustomAdapter(ArrayList<health_life> healthlist, Context context) {
        this.healthlist = healthlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return healthlist.size();
    }

    @Override
    public Object getItem(int position) {
        return healthlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.design_health,null);
        ImageView imageView=
                (ImageView)v.findViewById(R.id.imageView2);
        TextView txtUsername=
                (TextView)v.findViewById(R.id.txt);
        TextView txtTime=
                (TextView)v.findViewById(R.id.txtcal);
        imageView.setImageResource(healthlist.get(position).photo);
        txtUsername.setText(healthlist.get(position).text);
        txtTime.setText(healthlist.get(position).calori);
        return v;
    }
}