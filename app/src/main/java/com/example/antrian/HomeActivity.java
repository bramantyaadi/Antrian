package com.example.antrian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        navigationView = findViewById(R.id.nav_bottom_home);
        navigationView.setOnNavigationItemSelectedListener(this);
        if (savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.home_menu);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home_menu:
                fragment = new MainFragment();
                break;
            case R.id.list_menu:
                fragment = new ListFragment();
                break;
            case R.id.menu_logout:
                finish();
                Intent Home = new Intent(HomeActivity.this , MainActivity.class);
                startActivityForResult(Home , 100);
                break;

        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frm_home2 , fragment).commit();
            return true;
        }
        return false;
    }
}