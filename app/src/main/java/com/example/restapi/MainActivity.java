package com.example.restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.restapi.API.APIs;
import com.example.restapi.model.JwtResponse;
import com.example.restapi.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @BindView(R.id.login_username)
    EditText tv_username;

    @BindView(R.id.login_password)
    EditText tv_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Collection<Role> roles = new ArrayList<>();
//        roles.add(new Role(1));
//        User u = new User("m","m",null,roles);
//        addUser(u);
        Log.e("", "log");
    }

    @OnClick(R.id.login_btn)
    void Login() {
        User user = new User(tv_username.getText().toString(), tv_password.getText().toString());
        Call<JwtResponse> call = APIs.getUserService().getToken(user);
        sharedPreferences = getSharedPreferences("secret", MODE_PRIVATE);
        call.enqueue(new Callback<JwtResponse>() {
            @Override
            public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
                Log.d("jwt _login : ", "" + response.body());
                if (response.body() == null) {
                    Log.e("", "username or pass is incorredt");
                } else {
                    sharedPreferences.edit().putString("Bearer ", response.body().getJwt()).apply();
                    Log.e("", "login successs");
                       startActivity(new Intent(MainActivity.this,ItemListActivity.class));
                }
            }

            @Override
            public void onFailure(Call<JwtResponse> call, Throwable t) {
                Log.d("", "fail: " + t.getMessage());
            }

        });
    }


//    public void getToken(User user) {
//        Call<JwtResponse> call = APIs.getUserService().getToken(user);
//        String jwt;
//        call.enqueue(new Callback<JwtResponse>() {
//            @Override
//            public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
//                Log.d("jwt: ", "" + response.body());
//                String res = response.body().getJwt();
//            }
//
//            @Override
//            public void onFailure(Call<JwtResponse> call, Throwable t) {
//                Log.d("", "fail: " + t.getMessage());
//            }
//
//        });
//    }


//    public List listItems() {
//        Call<List<Item>> call = APIs.getItemService().getItems();
//        Log.d("cal", "Call " + call.toString());
//        List result = new ArrayList();
//        call.enqueue(new Callback<List<Item>>() {
//            @Override
//            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
//                for (Item i : response.body()) {
//                    Log.d("", " items:" + i.toString());
//                    result.add(i);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Item>> call, Throwable t) {
//                Log.d("", "fail: " + t.getMessage());
//
//            }
//        });
//        return result;
//    }
//
//    public List listUser() {
//        Call<List<User>> call = APIs.getUserService().getUsers();
//        Log.d("cal", "Call " + call.toString());
//        List result = new ArrayList();
//        call.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                for (User a : response.body()) {
//                    Log.d("", "acc" + a.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                Log.d("", "fail: " + t.getMessage());
//            }
//        });
//        return result;
//    }
//
//    public void addUser(User user) {
//        Call<User> call = APIs.getUserService().addUser(user);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                Log.d("", "acc" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.d("", "fail: " + t.getMessage());
//            }
//        });
//    }
//
//    public void updateItem(Item item, int id) {
//        Call<Item> call = itemService.editItem(item, id);
//        call.enqueue(new Callback<Item>() {
//            @Override
//            public void onResponse(Call<Item> call, Response<Item> response) {
//                Log.d("", "ADD:::" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Item> call, Throwable t) {
//                Log.d("", "fail: " + t.getMessage());
//            }
//        });
//
//    }
//
//    public void deleteItem(int id) {
//        Call<Integer> call = itemService.deleteItem(id);
//        call.enqueue(new Callback<Integer>() {
//            @Override
//            public void onResponse(Call<Integer> call, Response<Integer> response) {
//                Log.d("", "ADD:::" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Integer> call, Throwable t) {
//                Log.d("", "fail: " + t.getMessage());
//            }
//        });
//    }

}