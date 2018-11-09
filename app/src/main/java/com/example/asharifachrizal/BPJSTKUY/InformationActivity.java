package com.example.asharifachrizal.BPJSTKUY;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.asharifachrizal.BPJSTKUY.adapter.NewsAdapter;
import com.example.asharifachrizal.BPJSTKUY.api.ApiInterface;
import com.example.asharifachrizal.BPJSTKUY.api.RetrofitInstance;
import com.example.asharifachrizal.BPJSTKUY.model.News;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InformationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

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
                generateNewsList(response.body().getNewsList());
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.wtf("URL Called", t + "");
                Toast.makeText(InformationActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateNewsList(ArrayList<News> newsDataList) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewNewsList);

        mNewsAdapter = new NewsAdapter(newsDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(InformationActivity.this);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mNewsAdapter);
    }

}
