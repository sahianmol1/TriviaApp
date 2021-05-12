package com.example.triviaapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.triviaapp.R
import com.example.triviaapp.data.Trivia
import com.example.triviaapp.databinding.FragmentBestCricketerBinding
import com.google.android.material.snackbar.Snackbar

class BestCricketerFragment : Fragment(R.layout.fragment_best_cricketer) {
    private val args: BestCricketerFragmentArgs by navArgs()
    private lateinit var binding: FragmentBestCricketerBinding
    private var selectedName: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBestCricketerBinding.bind(view)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {

        binding.apply {
            radioAdam.setOnClickListener {
                selectedName = getString(R.string.text_adam_gilchrist)
            }

            radioJacques.setOnClickListener {
                selectedName = getString(R.string.text_jack_kallis)
            }

            radioSachin.setOnClickListener {
                selectedName = getString(R.string.text_sachin_tendulakr)
            }

            radioVirat.setOnClickListener {
                selectedName = getString(R.string.text_virat_kohli)
            }

            buttonNext.setOnClickListener {
                if (selectedName.isBlank()) {
                    Snackbar.make(requireView(), getString(R.string.text_select_a_player_name), Snackbar.LENGTH_LONG)
                        .show()
                } else {
                    val action =
                        BestCricketerFragmentDirections.actionBestCricketerFragmentToIndianFlagFragment(
                            Trivia(args.name, selectedName, "")
                        )
                    findNavController().navigate(action)
                }
            }
        }

    }
}