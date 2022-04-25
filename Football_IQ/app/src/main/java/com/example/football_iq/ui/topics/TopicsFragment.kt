package com.example.football_iq.ui.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.football_iq.databinding.FragmentTopicsBinding

class TopicsFragment : Fragment() {

    private lateinit var topicsViewModel: TopicsViewModel
    private var _binding: FragmentTopicsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        topicsViewModel =
            ViewModelProvider(this).get(TopicsViewModel::class.java)

        _binding = FragmentTopicsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTopics
        topicsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}