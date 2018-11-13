package com.example.asharifachrizal.BPJSTKUY.fragment;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.asharifachrizal.BPJSTKUY.DisplayProfileFragment;
import com.example.asharifachrizal.BPJSTKUY.R;
import com.example.asharifachrizal.BPJSTKUY.SliderIndicator;
import com.example.asharifachrizal.BPJSTKUY.SliderPagerAdapter;
import com.example.asharifachrizal.BPJSTKUY.SliderView;
import com.example.asharifachrizal.BPJSTKUY.api.ApiInterface;
import com.example.asharifachrizal.BPJSTKUY.api.RetrofitInstance;
import com.example.asharifachrizal.BPJSTKUY.model.Banner;
import com.example.asharifachrizal.BPJSTKUY.model.BannerList;
import com.example.asharifachrizal.BPJSTKUY.model.News;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);

        DisplayProfileFragment displayProfileFragment = new DisplayProfileFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentDisplayProfile, displayProfileFragment);
        fragmentTransaction.commit();

        SharedPreferences preferences = getActivity().getSharedPreferences("mPreferences", MODE_PRIVATE);
        String token = preferences.getString("token", null);

        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<BannerList> call = service.getBanners(token);
        Log.wtf("token: ", token + "");

        call.enqueue(new Callback<BannerList>() {
            @Override
            public void onResponse(Call<BannerList> call, Response<BannerList> response) {
                generateBannerList(response.body().getBannerList(), rootView);
            }

            @Override
            public void onFailure(Call<BannerList> call, Throwable t) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("Terjadi Kesalahan!")
                        .setMessage("Silahkan cek kembali pengaturan jaringan anda.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                alertDialog.show();
            }
        });

        return rootView;
    }

    private void generateBannerList(ArrayList<Banner> bannerDataList, View rootView) {

        sliderView.setDurationScroll(1000);
        List<Fragment> fragments = new ArrayList<>();
        for(int i = 0; i < bannerDataList.size(); i++) {
            fragments.add(SliderFragment.newInstance(bannerDataList.get(i).getPath()));
        }

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

}
