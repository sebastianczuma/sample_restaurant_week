package com.scz.restaurantweek.LayoutClassesEvents;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scz.restaurantweek.Activities.ItemInfo;
import com.scz.restaurantweek.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name;
    TextView price;
    ImageView image;

    RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        name = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
        image = itemView.findViewById(R.id.grid_item_image);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ItemInfo.class);
        view.getContext().startActivity(intent);
    }
}