package com.example.asharifachrizal.BPJSTKUY.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asharifachrizal.BPJSTKUY.LoginActivity;
import com.example.asharifachrizal.BPJSTKUY.R;
import com.example.asharifachrizal.BPJSTKUY.adapter.NewsAdapter;
import com.example.asharifachrizal.BPJSTKUY.api.ApiInterface;
import com.example.asharifachrizal.BPJSTKUY.api.RetrofitInstance;
import com.example.asharifachrizal.BPJSTKUY.model.News;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment {


    public InformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_information, container, false);

        /*Create handle for the RetrofitInstance interface*/
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<NewsList> call = service.getNews();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.wtf("URL Called", response + "");
                generateNewsList(response.body().getNewsList(), rootView);
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.wtf("URL Called", t + "");
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

        // Inflate the layout for this fragment
        return rootView;
    }

    /*Method to generate List of news using RecyclerView with custom adapter*/
    private void generateNewsList(ArrayList<News> newsDataList, View rootView) {
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewNewsList);

        NewsAdapter mNewsAdapter = new NewsAdapter(newsDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mNewsAdapter);
    }

}
