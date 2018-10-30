package com.scz.restaurantweek.LayoutClassesEvents;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scz.restaurantweek.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<EventObject> itemList;

    public RecyclerViewAdapter(List<EventObject> itemList) {
        this.itemList = itemList;
    }

    @Override
    @NonNull
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_event, parent, false);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).getNazwa());
        holder.price.setText(itemList.get(position).getCena());

        if (itemList.get(position).getNazwa().equals("Azja na talerzu")) {
            holder.image.setImageResource(R.drawable.azja_na_talerzu);
        } else if (itemList.get(position).getNazwa().equals("BROWAR KSIĘŻY MŁYN w BACCARO!")) {
            holder.image.setImageResource(R.drawable.browar);
        } else if (itemList.get(position).getNazwa().equals("Degustacja DWA PRZEZ CZTERY z MAISON A.S.")) {
            holder.image.setImageResource(R.drawable.degustacja_dwa);
        } else if (itemList.get(position).getNazwa().equals("Drink Up! Warsztaty koktajlowe w centrum Warszawy!")) {
            holder.image.setImageResource(R.drawable.drink_up);
        }
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}