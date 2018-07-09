package com.example.dell.learnretrofitforrestapi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {


    private val TAG = MainActivity::class.java.simpleName
    private var mAdapter: AndroidVersionAdapter? = null

    lateinit var rv_android_list : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_android_list = findViewById(R.id.rv_android_list)
        initRecyclerView()
        requestAndroidVersion()
    }



    private fun initRecyclerView() {


        rv_android_list.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_android_list.layoutManager = layoutManager

    }


    private fun requestAndroidVersion() {
        Repository.createService(ApiService::class.java).getAndroidVersion()
                .observeOn(AndroidSchedulers.mainThread()) // Chi dinh du lieu chinh tren mainthread
                .subscribeOn(Schedulers.io())//chi dinh cho request lam viec tren I/O Thread(request to api ,  download a file,...)
                .subscribe(
                        //cú pháp của rxjava trong kotlin
                        { result ->
                            //request thành công
                            handleSuccessAndroidVersion(result)
                        },
                        { error ->
                            //request thất bai
                            handlerErrorAndroidVersion(error)
                        }
                )
    }

    private fun handlerErrorAndroidVersion(error : Throwable) {
        Log.e(TAG, "handlerErrorAndroidVersion: ${error.localizedMessage}")
        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    private fun handleSuccessAndroidVersion(result:List<AndroidVersion>) {


        mAdapter = AndroidVersionAdapter(result,this , {
            val intent = Intent(this, Main2Activity::class.java)
            /*intent.putExtra("name",it.name)
            intent.putExtra("version",it.version)
            intent.putExtra("api",it.api)*/
            intent.putExtra("android",it)
            startActivity(intent)
        })
        rv_android_list.adapter = mAdapter


    }


    private fun onItemClicked(android : AndroidVersion) {
        //Toast.makeText(this, "Clicked: ${android.name}", Toast.LENGTH_LONG).show()

    }


}
