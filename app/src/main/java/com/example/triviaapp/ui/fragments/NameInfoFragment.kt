package com.example.triviaapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.triviaapp.R
import com.example.triviaapp.databinding.FragmentNameInfoBinding

class NameInfoFragment : Fragment(R.layout.fragment_name_info) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNameInfoBinding.bind(view)

        binding.apply {
            buttonNext.setOnClickListener {
                val name = editTextName.text.toString()
                if (name.isBlank()) {
                    textInputNameLayout.error = getString(R.string.text_name_cant_be_empty)
                } else {
                    val action = NameInfoFragmentDirections.actionNameInfoFragmentToBestCricketerFragment(name.trim())
                    findNavController().navigate(action)
                }
            }
        }
    }

}