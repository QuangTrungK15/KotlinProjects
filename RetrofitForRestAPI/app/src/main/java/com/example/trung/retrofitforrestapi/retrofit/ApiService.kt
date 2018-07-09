package com.example.trung.retrofitforrestapi.retrofit

import com.example.trung.retrofitforrestapi.retrofit.response.EarthQuakeResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {


    //URL specified in the annotation
    @GET("fdsnws/event/1/query?endtime=2016-01-31&format=geojson&limit=10&minmag=6&starttime=2016-01-01")
    fun getEarthQuacke(): Observable<EarthQuakeResponse>

}