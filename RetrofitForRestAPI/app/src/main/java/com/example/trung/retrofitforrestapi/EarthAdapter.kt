package com.example.trung.retrofitforrestapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trung.retrofitforrestapi.model.FeatureItem
import com.example.trung.retrofitforrestapi.model.SmallFeatureItem
import com.example.trung.retrofitforrestapi.retrofit.response.EarthQuakeResponse
import kotlinx.android.synthetic.main.item.view.*

class EarthAdapter(private val earthQuakelistResponse : List<FeatureItem>) : RecyclerView.Adapter<EarthAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = earthQuakelistResponse.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  {
        holder.bind(earthQuakelistResponse[position], position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(feature: FeatureItem, position: Int ) {
            itemView.txt_Title.text = feature.properties.title
            itemView.txt_Description.text = feature.properties.detail

        }


    }
}