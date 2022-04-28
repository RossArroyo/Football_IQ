package com.example.football_iq.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.football_iq.R
import com.example.football_iq.data.TopicsContent


 class TopicsContentAdapter(private val dataSet: Array<TopicsContent>):
    RecyclerView.Adapter<TopicsContentAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title_text)
        var description: TextView = view.findViewById(R.id.description_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topics_content_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            title.text = dataSet[position].title
            description.text = dataSet[position].description
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}