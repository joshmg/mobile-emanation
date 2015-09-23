package com.ohiohealth.leviathan.API;

import com.google.gson.GsonBuilder;
import com.ohiohealth.leviathan.API.services.BobertService;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Alex Berson on 9/23/2015.
 */
public class Bobert {
    private RestAdapter restAdapter;
    private String API_URL = "http://orb.ohiohealth.com/";
    public Bobert()
    {

    }

    protected RestAdapter.Builder newRestAdapterBuilder() {
        return new RestAdapter.Builder();
    }

    protected RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            RestAdapter.Builder builder = newRestAdapterBuilder();

            builder.setEndpoint(API_URL);
            builder.setConverter(new GsonConverter(new GsonBuilder().create()));


            restAdapter = builder.build();
        }

        return restAdapter;
    }

    public BobertService bobertService(){
        return getRestAdapter().create(BobertService.class);
    }

}
