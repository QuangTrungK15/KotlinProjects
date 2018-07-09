package com.example.dell.learnretrofitforrestapi

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AndroidVersion (@SerializedName("name") val name: String,
                           @SerializedName("ver") val version: String,
                           val api: String) : Serializable