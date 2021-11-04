package com.example.restapi.API;

import com.example.restapi.Service.AccountService;
import com.example.restapi.Service.ItemService;

public class APIs {

    public static  final  String BASE_URL="http://192.168.2.5:8081";

    public static ItemService getItemService(){
        return Client.getClient(BASE_URL).create(ItemService.class);
    }
    public static AccountService getUserService(){
        return Client.getClient(BASE_URL).create(AccountService.class);
    }

}
