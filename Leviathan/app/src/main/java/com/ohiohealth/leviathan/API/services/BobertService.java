package com.ohiohealth.leviathan.API.services;

import com.ohiohealth.leviathan.API.entities.CategoryPositionResults;
import com.ohiohealth.leviathan.API.entities.DictionaryList;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Alex Berson on 9/23/2015.
 */
public interface BobertService {
    @GET("/ptsws/Service1.svc/GetCategories")
    DictionaryList getCategories();

    @GET("/ptsws/Service1.svc/GetCategoryPositions/{categoryId}")
    CategoryPositionResults GetCategoryPositionsResult(@Path("categoryId") int categoryId);
}
