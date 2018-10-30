package com.scz.restaurantweek.LayoutClassesWhere;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scz.restaurantweek.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<WhereObject> itemList;

    public RecyclerViewAdapter(List<WhereObject> itemList) {
        this.itemList = itemList;
    }

    @Override
    @NonNull
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_where, parent, false);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.miasto.setText(itemList.get(position).getMiasto());

        if (itemList.get(position).getMiasto().equals("Warszawa")) {
            holder.im.setBackgroundResource(R.drawable.city_warszawa);
        } else if (itemList.get(position).getMiasto().equals("Kraków")) {
            holder.im.setBackgroundResource(R.drawable.city_krakow);
        } else if (itemList.get(position).getMiasto().equals("Trójmiasto")) {
            holder.im.setBackgroundResource(R.drawable.city_trojmiasto);
        } else if (itemList.get(position).getMiasto().equals("Wrocław")) {
            holder.im.setBackgroundResource(R.drawable.city_wroclaw);
        } else if (itemList.get(position).getMiasto().equals("Poznań")) {
            holder.im.setBackgroundResource(R.drawable.city_poznan);
        } else if (itemList.get(position).getMiasto().equals("Silesia")) {
            holder.im.setBackgroundResource(R.drawable.city_silesia);
        } else if (itemList.get(position).getMiasto().equals("Lublin")) {
            holder.im.setBackgroundResource(R.drawable.city_lublin);
        } else if (itemList.get(position).getMiasto().equals("Łódź")) {
            holder.im.setBackgroundResource(R.drawable.city_lodz);
        } else if (itemList.get(position).getMiasto().equals("Szczecin")) {
            holder.im.setBackgroundResource(R.drawable.city_szczecin);
        } else if (itemList.get(position).getMiasto().equals("Białystok")) {
            holder.im.setBackgroundResource(R.drawable.city_bialystok);
        } else if (itemList.get(position).getMiasto().equals("Rzeszów")) {
            holder.im.setBackgroundResource(R.drawable.city_rzeszow);
        } else if (itemList.get(position).getMiasto().equals("Słupsk i Ustka")) {
            holder.im.setBackgroundResource(R.drawable.city_slupsk_i_ustka);
        } else if (itemList.get(position).getMiasto().equals("Warmia i Mazury")) {
            holder.im.setBackgroundResource(R.drawable.city_warmia_i_mazury);
        }

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}