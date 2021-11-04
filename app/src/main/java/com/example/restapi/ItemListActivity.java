package com.example.restapi;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.restapi.API.APIs;
import com.example.restapi.Adapter.ItemListAdapter;
import com.example.restapi.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListActivity extends Activity {
    SharedPreferences sharedPreferences;

    private ItemListAdapter itemListAdapter;

    @BindView(R.id.rv_itemList) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences("secret", MODE_PRIVATE);
        String jwt = sharedPreferences.getString("Bearer ", "null");
        Log.e("JWT item: ", jwt);
        Call<List<Item>> call = APIs.getItemService().getItems("Bearer " + jwt);
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                Log.e("", "response:" + response.body());
                List<Item> itemList = response.body();

                itemListAdapter = new ItemListAdapter(itemList);
                recyclerView.setAdapter(itemListAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.d("", "fail: " + t.getMessage());
            }
        });

    }


}