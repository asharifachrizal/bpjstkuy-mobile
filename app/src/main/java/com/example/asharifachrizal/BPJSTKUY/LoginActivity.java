package com.example.asharifachrizal.BPJSTKUY;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asharifachrizal.BPJSTKUY.api.ApiInterface;
import com.example.asharifachrizal.BPJSTKUY.api.RetrofitInstance;
import com.example.asharifachrizal.BPJSTKUY.model.Auth;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;
import com.example.asharifachrizal.BPJSTKUY.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView textViewAutofill;
    EditText editTextEmail, editTextPIN;
    Button buttonLogin;

    ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewAutofill = (TextView)findViewById(R.id.textViewAutofill);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPIN = (EditText)findViewById(R.id.editTextPIN);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);

        textViewAutofill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail.setText("user0@example.com");
                editTextPIN.setText("123456");
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(editTextEmail.getText().toString(), editTextPIN.getText().toString());
            }
        });
    }

    private void validate(String email, String password) {
        Auth auth = new Auth(email, password);
        Call<User> call = service.auth(auth);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    SharedPreferences preferences = getSharedPreferences("mPreferences", MODE_PRIVATE);
                    preferences.edit().putString("token", "Bearer " + response.body().getToken()).apply();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    Log.wtf("Auth", response.body().getToken() + "");
                }
                else {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Terjadi Kesalahan!")
                            .setMessage("Kombinasi email dan PIN salah. Silahkan memasukkan inputan email dan PIN kembali.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    alertDialog.show();
                    Log.wtf("Auth", response.body() + "");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "error :(" + t + ")", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
