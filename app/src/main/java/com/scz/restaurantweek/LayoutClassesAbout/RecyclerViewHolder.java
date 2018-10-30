package com.scz.restaurantweek.LayoutClassesAbout;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scz.restaurantweek.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView tytul;
    TextView opis;
    ImageView im;


    RecyclerViewHolder(View itemView) {
        super(itemView);

        tytul = itemView.findViewById(R.id.tytul);
        opis = itemView.findViewById(R.id.opis);
        im = itemView.findViewById(R.id.grid_item_image);
    }
}