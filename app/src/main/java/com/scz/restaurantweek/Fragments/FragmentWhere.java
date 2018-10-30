package com.scz.restaurantweek.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.scz.restaurantweek.LayoutClassesWhere.RecyclerViewAdapter;
import com.scz.restaurantweek.LayoutClassesWhere.WhereObject;
import com.scz.restaurantweek.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentWhere extends Fragment {
    RecyclerViewAdapter rcAdapter;
    List<WhereObject> rowListItem;
    private OnFragmentInteractionListener mListener;

    public FragmentWhere() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_where, container, false);

        ImageButton hamburger = view.findViewById(R.id.hamburger);

        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });

        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 2);
        RecyclerView rView = view.findViewById(R.id.recycler_view);

        rowListItem = getAllItemList();
        rcAdapter = new com.scz.restaurantweek.LayoutClassesWhere.RecyclerViewAdapter(rowListItem);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setAdapter(rcAdapter);

        return view;
    }

    private List<WhereObject> getAllItemList() {
        List<WhereObject> allItems = new ArrayList<>();
        allItems.add(new WhereObject(
                "Warszawa"));
        allItems.add(new WhereObject(
                "Kraków"));
        allItems.add(new WhereObject(
                "Trójmiasto"));
        allItems.add(new WhereObject(
                "Wrocław"));
        allItems.add(new WhereObject(
                "Poznań"));
        allItems.add(new WhereObject(
                "Silesia"));
        allItems.add(new WhereObject(
                "Lublin"));
        allItems.add(new WhereObject(
                "Łódź"));
        allItems.add(new WhereObject(
                "Szczecin"));
        allItems.add(new WhereObject(
                "Białystok"));
        allItems.add(new WhereObject(
                "Rzeszów"));
        allItems.add(new WhereObject(
                "Słupsk i Ustka"));
        allItems.add(new WhereObject(
                "Warmia i Mazury"));

        Log.d("t", "l: " + allItems.size());

        return allItems;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
