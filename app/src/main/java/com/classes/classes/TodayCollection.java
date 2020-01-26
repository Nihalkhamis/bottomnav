package com.classes.classes;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.classes.classes.ui.complex.ComplexFragment;
import com.classes.classes.ui.detailed.DetailedFragment;
import com.classes.classes.ui.total.TotalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class TodayCollection extends AppCompatActivity {
    TextView TodayCollection_tv;
    FragmentManager manager;
    DetailedFragment detailedFragment;
    TotalFragment totalFragment;
    ComplexFragment complexFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_collection);
        bottomNavigationView = findViewById(R.id.nav_view);


        TodayCollection_tv = findViewById(R.id.TodayCollection_tv);
        manager = getSupportFragmentManager();

        detailedFragment = new DetailedFragment();
        totalFragment = new TotalFragment();
        complexFragment = new ComplexFragment();

        TodayCollection_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_detailed:
                        setDetailedFragment();
                        break;
                    case R.id.navigation_total:
                        setTotalFragment();
                        break;
                    case R.id.navigation_complex:
                        setComplexFragment();
                        break;
                }
                return false;
            }
        });

    }


//        navView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.navigation_detailed:
//                    setDetailedFragment();
//                    break;
//                    case R.id.navigation_total:
//                    setTotalFragment();
//                    break;
//                    case R.id.navigation_complex:
//                    setComplexFragment();
//                    break;
//                }
//            }
//        });

    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_detailed, R.id.nav_total, R.id.nav_complex)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment2);
//        NavigationUI.setupWithNavController(navView, navController);


    public void setDetailedFragment() {
        Log.d("TTT", "setDetailedFragment: "+"here 1");
        manager.beginTransaction().replace(R.id.nav_host_fragment2, detailedFragment).commit();
    }

    public void setTotalFragment() {
        manager.beginTransaction().replace(R.id.nav_host_fragment2, totalFragment).commit();
    }

    public void setComplexFragment() {
        manager.beginTransaction().replace(R.id.nav_host_fragment2, complexFragment).commit();
    }


}
