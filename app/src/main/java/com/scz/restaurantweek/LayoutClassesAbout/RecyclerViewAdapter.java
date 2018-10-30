package com.scz.restaurantweek.LayoutClassesAbout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scz.restaurantweek.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<AboutObject> itemList;

    public RecyclerViewAdapter(List<AboutObject> itemList) {
        this.itemList = itemList;
    }

    @Override
    @NonNull
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_about, parent, false);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.tytul.setText(itemList.get(position).getTytul());
        holder.opis.setText(itemList.get(position).getOpis());

        if (position == 0) {
            holder.im.setBackgroundResource(R.drawable.ic_icon_01);
        } else if (position == 1) {
            holder.im.setBackgroundResource(R.drawable.ic_icon_02);
        } else if (position == 2) {
            holder.im.setBackgroundResource(R.drawable.ic_icon_03);
        } else if (position == 3) {
            holder.im.setBackgroundResource(R.drawable.ic_icon_04);
        } else if (position == 4) {
            holder.im.setBackgroundResource(R.drawable.ic_icon_05);
        } else if (position == 5) {
            holder.im.setBackgroundResource(R.drawable.ic_icon_06);
        }

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}