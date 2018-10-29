package com.example.asharifachrizal.prototypebpjstku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView textViewAutofill;
    EditText editTextEmail, editTextPIN;
    Button buttonLogin;
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
                editTextEmail.setText("lionelmessi@mailinator.com");
                editTextPIN.setText("123456");
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail.setText("lionelmessi@mailinator.com");
                editTextPIN.setText("123456");
            }
        });
    }
}
