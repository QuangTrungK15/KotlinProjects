package com.example.trung.retrofitforrestapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.trung.retrofitforrestapi.model.FeatureItem
import com.example.trung.retrofitforrestapi.retrofit.ApiService
import com.example.trung.retrofitforrestapi.retrofit.Repository
import com.example.trung.retrofitforrestapi.retrofit.response.EarthQuakeResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {




    private val TAG = MainActivity::class.java.simpleName
    private var mAdapter: EarthAdapter? = null

    lateinit var rv_android_list : RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        requestEarthQuake()
        rv_android_list = findViewById(R.id.rv_android_list)
        initRecyclerView()





    }

    private fun requestEarthQuake() {
        //Log.e(TAG,"123123123213123")

        Repository.createService(ApiService::class.java).getEarthQuacke()
                .observeOn(AndroidSchedulers.mainThread()) // Chi dinh du lieu chinh tren mainthread
                .subscribeOn(Schedulers.io())//chi dinh cho request lam viec tren I/O Thread(request to api ,  download a file,...)
                .subscribe(
                        //cú pháp của rxjava trong kotlin
                        {
                           // Log.e(TAG,"123123123213123"+it.features[0].properties.title)

                            result ->
                            handleSuccessEarthQuake(result.features)
                        },
                        { error ->
                            //request thất bai
                            Log.e(TAG,""+error)
                            handlerErrorEarthQuake(error)
                        }
                )
    }

    private fun handlerErrorEarthQuake(error: Throwable?) {

    }

    private fun handleSuccessEarthQuake(result: List<FeatureItem>) {


        //Log.e(TAG,""+result[0].title)
        mAdapter = EarthAdapter(result)
        rv_android_list.adapter = mAdapter


    }

    private fun initRecyclerView() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_android_list.layoutManager = layoutManager
    }
}
