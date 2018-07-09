package com.example.dell.learnretrofitforrestapi

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_android_version.view.*

class AndroidVersionAdapter(private val androidVersionList: List<AndroidVersion>, var context: Context,val onItemClick: (AndroidVersion) -> Unit )
    : RecyclerView.Adapter<AndroidVersionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_android_version, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = androidVersionList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(androidVersionList[position], position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(android: AndroidVersion, position: Int ) {
            itemView.tv_name.text = android.name
            itemView.tv_version.text = android.version
            itemView.tv_api_level.text = android.api

            itemView.setOnClickListener { onItemClick(android) }


            /* //Log.e(MainActivity::class.java.simpleName,""+android.name)

             val intent = Intent(context, Main2Activity::class.java)

             intent.putExtra("name",android.name)
             intent.putExtra("version",android.version)
             intent.putExtra("api",android.api)
             context.startActivity(intent)*/


        }


    }


}