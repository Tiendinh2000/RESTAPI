package com.example.restapi.Service;

import com.example.restapi.model.JwtResponse;
import com.example.restapi.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface AccountService {

    @GET("/api/user/get")
    Call<List<User>> getUsers();

    @POST("/api/user/add")
    Call<User> addUser(@Body User user);


    @DELETE("/api/user/delete/{id}")
    Call<User> deleteUser(@Query("id") int id);

    @PUT("/api/user")
    Call<User>  editUser(@Body User User, @Query("id") int id);

    @POST("/auth/signin")
    Call<JwtResponse> getToken(@Body User user);
}
