package com.example.football_iq.ui.topics

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_iq.R
import com.example.football_iq.adapters.TopicsContentAdapter
import com.example.football_iq.convertor.AppDatabase
import com.example.football_iq.data.TopicsContent
import com.example.football_iq.data.TopicsContentDao

class TopicsFragment : Fragment() {
    companion object {
        fun newInstance() = TopicsFragment()
    }

    private lateinit var viewModel: TopicsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_topics, container, false)
        val context: Context = view.context

        // Configure the RecyclerView
        val contentListView: RecyclerView = view.findViewById(R.id.topics_content_list)
        contentListView.layoutManager = LinearLayoutManager(context)

        // Configure the adapter
        val contentAdapter = TopicsContentAdapter(getData())
        contentListView.adapter = contentAdapter

        return view
    }

    private fun getData(): Array<TopicsContent> {
        val academyDao: TopicsContentDao = AppDatabase.getInstance(requireContext()).academyContentDao()
        return academyDao.getAllContent().toTypedArray()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[TopicsViewModel::class.java]
    }
}