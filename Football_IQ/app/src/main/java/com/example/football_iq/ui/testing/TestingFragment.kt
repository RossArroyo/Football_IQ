package com.example.football_iq.ui.testing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.football_iq.databinding.FragmentTestingBinding

class TestingFragment : Fragment() {

    private lateinit var testingViewModel: TestingViewModel
    private var _binding: FragmentTestingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testingViewModel =
            ViewModelProvider(this).get(TestingViewModel::class.java)

        _binding = FragmentTestingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTesting
        testingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}