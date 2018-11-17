package com.example.asharifachrizal.BPJSTKUY._slider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.asharifachrizal.BPJSTKUY.R;

public class SliderFragment extends Fragment {

    private static final String ARG_PARAM1 = "params";
    private String imageUrls;

    public SliderFragment() {
    }

    public static SliderFragment newInstance(String params) {
        SliderFragment fragment = new SliderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, params);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        imageUrls = getArguments().getString(ARG_PARAM1);
        final View rootView = inflater.inflate(R.layout.fragment_slider, container, false);


        ImageView mImageView = (ImageView) rootView.findViewById(R.id.imageViewSlider);
        final ProgressBar mProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBarImageSlider);

        RequestOptions requestOptions = new RequestOptions();

        Glide.with(getActivity())
                .setDefaultRequestOptions(requestOptions)
                .load(imageUrls)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        mProgressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        mProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(mImageView);

        return rootView;

    }
}
