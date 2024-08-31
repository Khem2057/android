package com.example.easyassist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easyassist.api.RetrofitClient;
import com.example.easyassist.api.ApiService;
import com.example.easyassist.model.SignupRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class singup extends AppCompatActivity {
    private EditText fullnameEditText, addressEditText, contactEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button signup;
    private TextView signuparrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        // Initialize views
        signup = findViewById(R.id.signButton);
        signuparrow = findViewById(R.id.arrow);
        fullnameEditText = findViewById(R.id.Fullname);
        addressEditText = findViewById(R.id.Address);
        contactEditText = findViewById(R.id.Contact);
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.Password);
        confirmPasswordEditText = findViewById(R.id.ConfirmPassword);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = fullnameEditText.getText().toString().trim();
                String address = addressEditText.getText().toString().trim();
                String contact = contactEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                if (validateInputs(fullname, address, contact, email, password, confirmPassword)) {
//                    signupUser(fullname, address, contact, email, password);
                }
            }
        });

        signuparrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(singup.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateInputs(String fullname, String address, String contact, String email, String password, String confirmPassword) {
        if (TextUtils.isEmpty(fullname)) {
            fullnameEditText.setError("Full name is required");
            fullnameEditText.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(address)) {
            addressEditText.setError("Address is required");
            addressEditText.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(contact)) {
            contactEditText.setError("Contact number is required");
            contactEditText.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Email is required");
            emailEditText.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            passwordEditText.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Passwords do not match");
            confirmPasswordEditText.requestFocus();
            return false;
        }
        return true;
    };

//    private void signupUser(String fullname, String address, String contact, String email, String password) {
//        ApiService apiService = RetrofitClient.getApiService();
//        SignupRequest signupRequest = new SignupRequest(fullname, address, contact, email, password);
//
//        // Retrieve the Bearer token from SharedPreferences
//        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
//        String token = "Bearer " + sharedPreferences.getString("token", "");

//        Call<Void> call = apiService.signup(token, signupRequest);
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(singup.this, "Sign-up successful", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(singup.this, home.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(singup.this, "Sign-up failed: " + response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }

//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Toast.makeText(singup.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }


//}