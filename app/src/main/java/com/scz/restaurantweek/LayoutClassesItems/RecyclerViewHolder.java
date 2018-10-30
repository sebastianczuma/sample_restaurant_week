package com.scz.restaurantweek.LayoutClassesItems;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.scz.restaurantweek.Activities.ItemInfo;
import com.scz.restaurantweek.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name;
    TextView about;
    ImageView image;
    Button showMenu;


    RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        name = itemView.findViewById(R.id.name);
        about = itemView.findViewById(R.id.about);
        image = itemView.findViewById(R.id.grid_item_image);
        showMenu = itemView.findViewById(R.id.show_menu);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ItemInfo.class);
        view.getContext().startActivity(intent);
    }
}