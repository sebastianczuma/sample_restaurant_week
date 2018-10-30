package com.scz.restaurantweek.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.scz.restaurantweek.LayoutClassesAbout.AboutObject;
import com.scz.restaurantweek.LayoutClassesAbout.RecyclerViewAdapter;
import com.scz.restaurantweek.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentAbout extends Fragment {
    RecyclerViewAdapter rcAdapter;
    List<AboutObject> rowListItem;
    private OnFragmentInteractionListener mListener;

    public FragmentAbout() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_about, container, false);

        ImageButton hamburger = view.findViewById(R.id.hamburger);

        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });

        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        RecyclerView rView = view.findViewById(R.id.recycler_view);

        rowListItem = getAllItemList();
        rcAdapter = new com.scz.restaurantweek.LayoutClassesAbout.RecyclerViewAdapter(rowListItem);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setAdapter(rcAdapter);

        return view;
    }

    private List<AboutObject> getAllItemList() {
        List<AboutObject> allItems = new ArrayList<>();
        allItems.add(new AboutObject(
                "Rezerwacje online!",
                "Festiwalowe menu i Restauracje na www.RestaurantWeek.pl"));
        allItems.add(new AboutObject(
                "Najwyższy poziom Restauracji!",
                "Starannie wybrane wyjątkowe i najbardziej autorskie Restauracje."));
        allItems.add(new AboutObject(
                "Trzydaniowe doświadczenie restauracyjne",
                "Popisowe menu festiwalowe: przystawka, danie główne, deser."));
        allItems.add(new AboutObject(
                "Festiwalowa cena 49zł",
                "Najlepsza okazja na poznanie ze Znajomymi nowych smaków, kuchni i Restauracji."));
        allItems.add(new AboutObject(
                "Ósmy gość gratis",
                "Towarzyskość to zdrowie! Zaproś znajomych - razem świętujcie w jeszcze lepszej cenie!"));
        allItems.add(new AboutObject(
                "Czas rezerwacji!",
                "Wasz czas to 90 minut. Po nim będą już czekać następni Goście. To równe szanse na wymarzone doświadczenia restauracyjne szanse dla każdego."));

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
