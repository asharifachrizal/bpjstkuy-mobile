package com.example.asharifachrizal.BPJSTKUY;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

//    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    FragmentTransaction fragmentDashboardTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentDashboardTransaction.replace(R.id.content, dashboardFragment);
                    fragmentDashboardTransaction.commit();
                    return true;
                case R.id.navigation_information:
                    InformationFragment informationFragment = new InformationFragment();
                    FragmentTransaction fragmentInformationTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentInformationTransaction.replace(R.id.content, informationFragment);
                    fragmentInformationTransaction.commit();
                    return true;
                case R.id.navigation_report:
                    ReportFragment reportFragment = new ReportFragment();
                    FragmentTransaction fragmentReportTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentReportTransaction.replace(R.id.content, reportFragment);
                    fragmentReportTransaction.commit();
                    return true;
                case R.id.navigation_simulation:
                    SimulationFragment simulationFragment = new SimulationFragment();
                    FragmentTransaction fragmentSimulationTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentSimulationTransaction.replace(R.id.content, simulationFragment);
                    fragmentSimulationTransaction.commit();
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentProfileTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentProfileTransaction.replace(R.id.content, profileFragment);
                    fragmentProfileTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DashboardFragment dashboardFragment = new DashboardFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, dashboardFragment);
        fragmentTransaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
