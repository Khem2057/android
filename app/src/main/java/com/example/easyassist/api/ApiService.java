package com.example.easyassist.api;

import com.example.easyassist.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiService {
//    @POST("/signup")  // Replace with your actual endpoint
//    Call<Void> signup(@Header("Authorization") String token, @Body SignupRequest signupRequest);


//    @POST("/api/login")  // Adjust this endpoint to match your API
//    Call<UserModel> signIn(@Body UserModel userModel);
@POST("/api/login")
Call<UserModel> postLogin(@Body UserModel userModel);
}
