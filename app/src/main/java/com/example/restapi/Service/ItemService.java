package com.example.restapi.Service;

import com.example.restapi.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemService {
    @GET("/api/items/get")
    Call<List<Item>> getItems(@Header("Authorization")String jwt);

    @POST("/api/items/add")
    Call<Item> addItem(@Body Item item);


    @DELETE("/api/items/{id}")
    Call<Integer> deleteItem(@Path("id") int id);

    @PUT("/api/items")
    Call<Item>  editItem(@Body Item item, @Query("id") int id);
}
