package com.scz.restaurantweek.Fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scz.restaurantweek.LayoutClassesItems.ItemObject;
import com.scz.restaurantweek.LayoutClassesItems.RecyclerViewAdapter;
import com.scz.restaurantweek.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {
    RecyclerViewAdapter rcAdapter;
    List<ItemObject> rowListItem;

    public FragmentList() {
        // Required empty public constructor
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Declarations
        StaggeredGridLayoutManager lLayout = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
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

    private List<ItemObject> getAllItemList() {
        List<ItemObject> allItems = new ArrayList<>();
        allItems.add(new ItemObject(
                "16 Stołów",
                "Najlepsze na wieczór"));
        allItems.add(new ItemObject(
                "Ahimsa",
                "Najlepsze dla przyjaciół"));
        allItems.add(new ItemObject(
                "Albenca (Katowice)",
                "Najlepsze na randkę"));
        allItems.add(new ItemObject(
                "Alyki",
                "Najlepsze na wyjście rodzinne,\nNajlepsze na lunch"));
        allItems.add(new ItemObject(
                "Angelo Ristorante Restauracja Włoska",
                "Najlepsze na wyjście rodzinne"));
        allItems.add(new ItemObject(
                "Anna de Croy",
                "Najlepsze na wieczór"));

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
