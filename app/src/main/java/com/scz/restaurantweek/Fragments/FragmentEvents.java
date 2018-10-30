package com.scz.restaurantweek.Fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scz.restaurantweek.LayoutClassesEvents.EventObject;
import com.scz.restaurantweek.LayoutClassesEvents.RecyclerViewAdapter;
import com.scz.restaurantweek.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentEvents extends Fragment {
    RecyclerViewAdapter rcAdapter;
    FragmentEvents ctx;
    List<EventObject> rowListItem;

    public FragmentEvents() {
        // Required empty public constructor
    }

    @Override
    public void onPause() {
        super.onPause();
        //handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ctx = this;

        // Declarations
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        RecyclerView rView = view.findViewById(R.id.recycler_view);

        // Recycle View setup
        rowListItem = getAllItemList();
        rcAdapter = new RecyclerViewAdapter(rowListItem);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setAdapter(rcAdapter);
        SpaceItemDecoration dividerItemDecoration = new SpaceItemDecoration(20);
        rView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    private List<EventObject> getAllItemList() {
        List<EventObject> allItems = new ArrayList<>();
        allItems.add(new EventObject(
                "Azja na talerzu",
                "200zł za osobę"));
        allItems.add(new EventObject(
                "BROWAR KSIĘŻY MŁYN w BACCARO!",
                "90zł za osobę"));
        allItems.add(new EventObject(
                "Degustacja DWA PRZEZ CZTERY z MAISON A.S.",
                "95zł za osobę"));
        allItems.add(new EventObject(
                "Drink Up! Warsztaty koktajlowe w centrum Warszawy!",
                "149zł za osobę"));

        return allItems;
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private final int space;

        private SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = space;
            outRect.left = space;
        }
    }
}
