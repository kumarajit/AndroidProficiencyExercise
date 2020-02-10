package com.Canada.androidproficiencyexercise.retrofit;


import com.Canada.androidproficiencyexercise.Model.Canada;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    Observable<Canada> getData(@Query("limit") String limit);
}
