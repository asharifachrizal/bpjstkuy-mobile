package com.example.asharifachrizal.BPJSTKUY;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asharifachrizal.BPJSTKUY.api.ApiInterface;
import com.example.asharifachrizal.BPJSTKUY.api.RetrofitInstance;
import com.example.asharifachrizal.BPJSTKUY.fragment.DashboardFragment;
import com.example.asharifachrizal.BPJSTKUY.fragment.InformationFragment;
import com.example.asharifachrizal.BPJSTKUY.fragment.ProfileFragment;
import com.example.asharifachrizal.BPJSTKUY.fragment.ReportFragment;
import com.example.asharifachrizal.BPJSTKUY.fragment.SimulationFragment;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new DashboardFragment();
    final Fragment fragment2 = new InformationFragment();
    final Fragment fragment3 = new ReportFragment();
    final Fragment fragment4 = new SimulationFragment();
    final Fragment fragment5 = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    return true;
                case R.id.navigation_information:
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    return true;
                case R.id.navigation_report:
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    return true;
                case R.id.navigation_simulation:
                    fm.beginTransaction().hide(active).show(fragment4).commit();
                    active = fragment4;
                    return true;
                case R.id.navigation_profile:
                    fm.beginTransaction().hide(active).show(fragment5).commit();
                    active = fragment5;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.content, fragment5, "5").hide(fragment5).commit();
        fm.beginTransaction().add(R.id.content, fragment4, "4").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.content, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.content, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.content,fragment1, "1").commit();
    }

}
