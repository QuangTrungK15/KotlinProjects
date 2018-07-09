package com.example.dell.learnretrofitforrestapi

import io.reactivex.Observable
import retrofit2.http.GET


interface ApiService {


    //URL specified in the annotation
    @GET("android/jsonarray/")
    fun getAndroidVersion(): Observable<List<AndroidVersion>>

}