package com.example.dell.learnretrofitforrestapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Main2Activity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var av : AndroidVersion

        var tv_name = findViewById(R.id.tv_name) as TextView
        var tv_version = findViewById(R.id.tv_version) as TextView
        var tv_api_level = findViewById(R.id.tv_api_level) as TextView

        av = intent.getSerializableExtra("android") as AndroidVersion


        tv_name.setText(av.name)
        tv_version.setText(av.version)
        tv_api_level.setText(av.api)




    }
}
