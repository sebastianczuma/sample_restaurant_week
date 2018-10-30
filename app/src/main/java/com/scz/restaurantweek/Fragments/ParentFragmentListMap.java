package com.scz.restaurantweek.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.scz.restaurantweek.LayoutAdapters.ViewPagerAdapter;
import com.scz.restaurantweek.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;


public class ParentFragmentListMap extends Fragment implements PopupMenu.OnMenuItemClickListener {
    private static String POPUP_CONSTANT = "mPopup";
    private static String POPUP_FORCE_SHOW_ICON = "setForceShowIcon";
    ViewPager mViewPager;
    private OnFragmentInteractionListener mListener;


    public ParentFragmentListMap() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list_map, container, false);
        TabLayout mTabLayout = view.findViewById(R.id.tabs_titles);

        mViewPager = view.findViewById(R.id.tabs_container);
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
        ImageButton hamburger = view.findViewById(R.id.hamburger);

        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });

        final ImageButton filter = view.findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(filter);
            }
        });


        final AppBarLayout appBarLayout = view.findViewById(R.id.id_appbar);


        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        params.setBehavior(new AppBarLayout.Behavior());

        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        if(position == 1) {
                            appBarLayout.setExpanded(true, true);
                        }

                    }
                }
        );

        final Button location = view.findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder4 = new AlertDialog.Builder(getContext());
                alertDialogBuilder4.setTitle("Lokalizacja");
                final String[] items3 = {"Cała Polska", "Warszawa", "Kraków", "Trójmiasto", "Wrocław", "Poznań", "Silesia", "Lublin", "Łódź", "Szczeciń", "Białystok", "Rzeszów", "Słupsk i Ustka", "Warmia i Mazury"};
                alertDialogBuilder4.setItems(items3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        location.setText(items3[i] + " \u25BC");
                    }
                });
                AlertDialog alertDialog4 = alertDialogBuilder4.create();
                alertDialog4.show();
            }
        });

        return view;
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(getContext(), v);
        try {
            Field[] fields = popup.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(POPUP_CONSTANT)) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popup);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod(POPUP_FORCE_SHOW_ICON, boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.list_popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.date:
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
                break;
            case R.id.hour:
                Toast.makeText(getContext(), "godzina", Toast.LENGTH_SHORT).show();
                break;
            case R.id.guests:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("Liczba gości");
                String[] items = {"Dowolna", "2 osoby", "3 osoby", "4 osoby", "5 osób", "6 osób", "7 osób", "8 osób"};
                alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                break;
            case R.id.kitchens:
                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(getContext());
                alertDialogBuilder2.setTitle("Kuchnie");
                String[] items2 = {"Polish Modern Cousine", "autorska", "europejska", "fine dining", "fusion", "menu mięsne", "menu rybne", "menu wegetariańskie", "międzynarodowa"};
                alertDialogBuilder2.setItems(items2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog2 = alertDialogBuilder2.create();
                alertDialog2.show();
                break;

            case R.id.tags:
                AlertDialog.Builder alertDialogBuilder3 = new AlertDialog.Builder(getContext());
                alertDialogBuilder3.setTitle("Tagi");
                String[] items3 = {"#pizza", "#seafood", "Koktail Martini tonic", "Kraków", "fusion", "Na specjalną okazję", "Najlepsze casualowe", "Najlepsze dla dużej paczki"};
                alertDialogBuilder3.setItems(items3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog3 = alertDialogBuilder3.create();
                alertDialog3.show();
                break;
        }

        return false;
    }

    void setupViewPager(ViewPager mViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentList(), "Oferta");
        adapter.addFragment(new FragmentMap1(), "Mapa");

        mViewPager.setAdapter(adapter);
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

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
        }
    }
}
