package com.example.triviaapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.triviaapp.R
import com.example.triviaapp.data.Trivia
import com.example.triviaapp.databinding.FragmentIndianFlagBinding
import com.google.android.material.snackbar.Snackbar

class IndianFlagFragment : Fragment(R.layout.fragment_indian_flag) {
    private val args: IndianFlagFragmentArgs by navArgs()
    private var count = 0
    private val flagColorsList = mutableListOf<String>()
    private var flagColors: String = ""

    private lateinit var binding: FragmentIndianFlagBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIndianFlagBinding.bind(view)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {

            checkboxGreen.setOnClickListener {
                if (checkboxGreen.isChecked) {
                    flagColorsList.add(getString(R.string.color_green))
                    count++
                } else {
                    flagColorsList.remove(getString(R.string.color_green))
                    count--
                }
            }

            checkboxOrange.setOnClickListener {
                if (checkboxOrange.isChecked) {
                    flagColorsList.add(getString(R.string.text_orange))
                    count++
                } else {
                    flagColorsList.remove(getString(R.string.text_orange))
                    count--
                }
            }

            checkboxWhite.setOnClickListener {
                if (checkboxWhite.isChecked) {
                    flagColorsList.add(getString(R.string.text_white))
                    count++
                } else {
                    flagColorsList.remove(getString(R.string.text_white))
                    count--
                }
            }

            checkboxYellow.setOnClickListener {
                if (checkboxYellow.isChecked) {
                    flagColorsList.add(getString(R.string.text_yellow))
                    count++
                } else {
                    flagColorsList.remove(getString(R.string.text_yellow))
                    count--
                }
            }

            buttonNext.setOnClickListener {
                when (count) {
                    0, 1 -> {
                        Snackbar.make(
                            requireView(),
                            getString(R.string.text_select_more_than_one_item),
                            Snackbar.LENGTH_LONG
                        ).show()
                        return@setOnClickListener
                    }
                    else -> {
                        for (color in flagColorsList) {
                            flagColors += "$color, "
                        }
                        val action =
                            IndianFlagFragmentDirections.actionIndianFlagFragmentToSummaryFragment(
                                Trivia(
                                    args.triviaInfo.name,
                                    args.triviaInfo.cricketerName,
                                    flagColors.trim().substring(0, flagColors.trim().length - 1)
                                )
                            )
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}