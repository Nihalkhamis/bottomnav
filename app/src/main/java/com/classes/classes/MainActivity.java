package com.classes.classes;

import android.content.Intent;
import android.os.Bundle;

import com.classes.classes.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;


    DrawerLayout drawer;
    NavigationView navigationView;
    HomeFragment homeFragment;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         drawer = findViewById(R.id.drawer_layout);
         navigationView = findViewById(R.id.nav_view);

        homeFragment = new HomeFragment();

        manager = getSupportFragmentManager();

        setHomeScreen();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                menuItem.setChecked(true);
                drawer.closeDrawers();

                switch (id) {
                    case R.id.nav_TodayCollections:
                        setTodayCollectionActivity();
                        break;
                    case R.id.nav_delayedListings:
                        setTodayCollectionActivity();
                        break;
                    case R.id.nav_numOfStudents:
                        setTodayCollectionActivity();
                        break;
                    case R.id.nav_DataOfStudents:
                        setTodayCollectionActivity();
                        break;
                    case R.id.nav_tableOfClasses:
                        setTodayCollectionActivity();
                        break;

                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setHomeScreen() {
        manager.beginTransaction().replace(R.id.nav_host_fragment, homeFragment , "").commit();
    }

    public void  setTodayCollectionActivity(){
        Intent intent = new Intent(MainActivity.this,TodayCollection.class);
        startActivity(intent);
    }

    public void menu() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            drawer.openDrawer(Gravity.RIGHT);
        }
    }
}
