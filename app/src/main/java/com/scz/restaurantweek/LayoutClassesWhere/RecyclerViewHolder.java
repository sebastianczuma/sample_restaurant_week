package com.scz.restaurantweek.LayoutClassesWhere;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scz.restaurantweek.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView miasto;
    ImageView im;


    RecyclerViewHolder(View itemView) {
        super(itemView);

        miasto = itemView.findViewById(R.id.miasto);
        im = itemView.findViewById(R.id.grid_item_image);
    }
}