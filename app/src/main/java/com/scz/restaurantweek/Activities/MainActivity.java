package com.scz.restaurantweek.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.scz.restaurantweek.Fragments.FragmentAbout;
import com.scz.restaurantweek.Fragments.FragmentWhere;
import com.scz.restaurantweek.Fragments.ParentFragmentEventsMap;
import com.scz.restaurantweek.Fragments.ParentFragmentListMap;
import com.scz.restaurantweek.R;


public class MainActivity extends AppCompatActivity implements
        ParentFragmentListMap.OnFragmentInteractionListener,
        ParentFragmentEventsMap.OnFragmentInteractionListener,
        FragmentAbout.OnFragmentInteractionListener,
        FragmentWhere.OnFragmentInteractionListener {
    DrawerLayout drawerLayout;

    public void onFragmentInteraction() {
        drawerLayout.openDrawer(Gravity.START);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer);

        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.list:

                        ParentFragmentListMap parentFragmentListMap = new ParentFragmentListMap();
                        Bundle args1 = new Bundle();
                        parentFragmentListMap.setArguments(args1);
                        transaction.replace(R.id.fragment_container, parentFragmentListMap);
                        transaction.commit();

                        return true;

                    case R.id.restaurants:

                        ParentFragmentEventsMap parentFragmentEventsMap = new ParentFragmentEventsMap();
                        Bundle args2 = new Bundle();
                        parentFragmentEventsMap.setArguments(args2);
                        transaction.replace(R.id.fragment_container, parentFragmentEventsMap);
                        transaction.commit();

                        return true;

                    case R.id.about:

                        FragmentAbout fragmentAbout = new FragmentAbout();
                        Bundle args3 = new Bundle();
                        fragmentAbout.setArguments(args3);
                        transaction.replace(R.id.fragment_container, fragmentAbout);
                        transaction.commit();

                        return true;

                    case R.id.where:

                        FragmentWhere fragmentWhere = new FragmentWhere();
                        Bundle args4 = new Bundle();
                        fragmentWhere.setArguments(args4);
                        transaction.replace(R.id.fragment_container, fragmentWhere);
                        transaction.commit();

                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Coś poszło nie tak", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });


        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            ParentFragmentListMap firstFragment = new ParentFragmentListMap();

            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}
