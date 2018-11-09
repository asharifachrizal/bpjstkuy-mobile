package com.example.asharifachrizal.BPJSTKUY.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asharifachrizal.BPJSTKUY.R;
import com.example.asharifachrizal.BPJSTKUY.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private ArrayList<News> mNewsList;

    public NewsAdapter(ArrayList<News> mNewsList) {
        this.mNewsList = mNewsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_news, viewGroup, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        newsViewHolder.mTitleTextView.setText(mNewsList.get(i).getTitle());
        newsViewHolder.mBodyTextView.setText(mNewsList.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitleTextView;
        protected TextView mBodyTextView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTitleTextView = (TextView)itemView.findViewById(R.id.textViewNewsTitle);
            this.mBodyTextView = (TextView)itemView.findViewById(R.id.textViewBody);
        }
    }
}
