package com.example.trung.retrofitforrestapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FeatureItem {
    var type : String = ""
    lateinit var properties : SmallFeatureItem

}