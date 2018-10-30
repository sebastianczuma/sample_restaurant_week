package com.scz.restaurantweek.LayoutClassesItems;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.scz.restaurantweek.Activities.Book;
import com.scz.restaurantweek.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<ItemObject> itemList;

    public RecyclerViewAdapter(List<ItemObject> itemList) {
        this.itemList = itemList;
    }

    @Override
    @NonNull
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, parent, false);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).getNazwa());
        holder.about.setText(itemList.get(position).getOpis());

        if (itemList.get(position).getNazwa().equals("16 Stołów")) {
            holder.image.setImageResource(R.drawable.f);
        } else if (itemList.get(position).getNazwa().equals("Ahimsa")) {
            holder.image.setImageResource(R.drawable.d);
        } else if (itemList.get(position).getNazwa().equals("Albenca (Katowice)")) {
            holder.image.setImageResource(R.drawable.e);
        } else if (itemList.get(position).getNazwa().equals("Alyki")) {
            holder.image.setImageResource(R.drawable.a);
        } else if (itemList.get(position).getNazwa().equals("Angelo Ristorante Restauracja Włoska")) {
            holder.image.setImageResource(R.drawable.b);
        } else if (itemList.get(position).getNazwa().equals("Anna de Croy")) {
            holder.image.setImageResource(R.drawable.c);
        }

        holder.showMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.menu_dialog);
                dialog.findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.findViewById(R.id.button_reserve).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Book.class);
                        view.getContext().startActivity(intent);
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}