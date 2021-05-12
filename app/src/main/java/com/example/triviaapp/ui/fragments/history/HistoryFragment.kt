package com.example.triviaapp.ui.fragments.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.triviaapp.R
import com.example.triviaapp.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {
    private val viewModel: HistoryViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHistoryBinding.bind(view)
        val historyAdapter = HistoryAdapter()
        binding.apply {
            recyclerViewHistory.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = historyAdapter
                setHasFixedSize(true)
            }
            viewModel.getAllTrivia().observe(viewLifecycleOwner, {
                historyAdapter.submitList(it)
            })
        }
    }
}