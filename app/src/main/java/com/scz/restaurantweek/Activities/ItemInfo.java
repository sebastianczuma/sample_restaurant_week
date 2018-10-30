package com.scz.restaurantweek.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.scz.restaurantweek.R;

public class ItemInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        TabLayout tabLayout = findViewById(R.id.tabs_titles);
        tabLayout.addTab(tabLayout.newTab().setText("Menu A"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu B"));

        Button map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:50.060843,19.936423?q=50.060843,19.936423(16+Stołów)");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                getApplicationContext().startActivity(intent);
            }
        });

        ImageButton goBack = findViewById(R.id.goback);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button book = findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Book.class);
                startActivity(intent);
            }
        });
    }
}
