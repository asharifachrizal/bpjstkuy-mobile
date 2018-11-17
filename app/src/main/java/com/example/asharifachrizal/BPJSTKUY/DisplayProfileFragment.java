package com.example.asharifachrizal.BPJSTKUY;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.asharifachrizal.BPJSTKUY.api.ApiInterface;
import com.example.asharifachrizal.BPJSTKUY.api.RetrofitInstance;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;
import com.example.asharifachrizal.BPJSTKUY.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView mTextViewName;
    TextView mTextViewNIK;
    TextView mTextViewEmail;

    public DisplayProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplayProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisplayProfileFragment newInstance(String param1, String param2) {
        DisplayProfileFragment fragment = new DisplayProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_display_profile, container, false);

        getAuthUser(rootView);

        return rootView;
    }

    private void getAuthUser(final View rootView) {

        final ImageView mImageView = (ImageView) rootView.findViewById(R.id.imageViewProfilePicture);

        final TextView mTextViewName = (TextView)rootView.findViewById(R.id.textViewName);
        final TextView mTextViewNIK = (TextView)rootView.findViewById(R.id.textViewNIK);
        final TextView mTextViewEmail = (TextView)rootView.findViewById(R.id.textViewEmail);

        SharedPreferences preferences = getActivity().getSharedPreferences("mPreferences", MODE_PRIVATE);
        String token = preferences.getString("token", null);

        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<User> call = service.getUser(token);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.default_display_picture);
                requestOptions.error(R.drawable.default_display_picture);

                Glide.with(getActivity())
                        .setDefaultRequestOptions(requestOptions)
                        .load(response.body().getPath_dp())
                        .apply(requestOptions.circleCropTransform())
                        .into(mImageView);

                mTextViewName.setText(response.body().getName());
                mTextViewNIK.setText(response.body().getNik());
                mTextViewEmail.setText(response.body().getEmail());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext())
//                        .setTitle("Terjadi Kesalahan!")
//                        .setMessage("Silahkan cek kembali pengaturan jaringan anda.")
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//                alertDialog.show();
            }
        });
    }

}
